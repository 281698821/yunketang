// layui  配置
layui.config({
    base: '/modules/' // 扩展模块目录
}).extend({ // 模块别名
    hpWindow: 'hpComponent/hpWindow',
    hpConfig: 'hpComponent/hpConfig',
    utils: 'admin/utils',
});
// layui初始化模块使用
layui.use(['table', 'hpWindow','utils'], function () {
    var table = layui.table;
    var $ = layui.$;
    var hpWindow = layui.hpWindow;
    var form = layui.form;
    var utils = layui.utils;
    var dataTable;//解决表格查询会保留上次的参数
    // 命令
    var cmd = {
        //  初始化
        init: function () {
            this.initEvent();        // 初始化事件
            this.bindEvent();        // 初始化绑定事件
            this.initOpenWindow();   // 初始化弹窗
        },
        //  初始化事件
        initEvent: function () {
            // 加载loading
            var tableLoad = layer.load();
            // 数据表格渲染
            dataTable= table.render({
                elem: '#dataTable',
                url: "/talentpoolController/ajaxList",
                cellMinWidth: 80,
                showLoad: true,
                page: true,
                loading:false,
                cols: [[
                    {type: 'checkbox', fixed: 'left'},
                    {field: 'name', align: 'center', title: '姓名'},
                    {field: 'sex', align: 'center', templet: cmd.fmt.sex, title: '性别'},
                    {field: 'phone', align: 'center', title: '电话'},
                    {field: 'qq', align: 'center', title: 'QQ号码'},
                    {field: 'email', align: 'center', title: '邮箱'},
                    {field: 'age', align: 'center', title: '年龄'},
                    {field: 'currentaddress', align: 'center',title: '现住址'},
                    {field: 'specialty', align: 'center',title: '技术特长'},
                    {field: 'comments', align: 'center', title: '圈内评价'},
                    {field: 'asthecompany', align: 'center', title: '现所在公司'},
                    {field: 'mark', align: 'center', title: '备注'},
                    {fixed: 'right', width: 178, align: 'center', toolbar: '#barTool', title: '操作'}
                ]],
                // 数据渲染完成回调
                done: function () {
                    layer.close(tableLoad);
                }
            });


            //监听工具条
            table.on('tool(tableTool)', function (obj) {
                var data = obj.data;

                if (obj.event === 'del') {
                    layer.confirm('真的删除行么', function (index) {

                        $.ajax({
                            url: '/talentpoolController/delete',
                            data: {"id": data.id},
                            type: 'post',
                            dataType: 'json',
                            success: function (json) {
                                if (json && json.code == 200) {
                                    //执行重载
                                    //cmd.reload('dataTable');
                                    obj.del();
                                    layer.msg(json.msg);
                                    layer.close(index);
                                } else {
                                    layer.msg('数据有误');
                                }
                            },
                            error: function () {
                                layer.msg('系统出错,请联系管理员');
                            }

                        })
                    });
                } else if (obj.event === 'edit') {
                    //提交修改
                    hpWindow.openOne(".updateBtn", "/talentpoolController/saveUpdatePage?id=" + data.id, {
                        title: '修改',
                        area: ['500px', '550px'],
                        btn: ['确认', '取消'],
                        anim: 1,
                        success: function (layero, index) {
                            form.render();
                            form.on('submit(save)', function (data) {
                                var data = $('#hp-form').serializeJson();
                                $.ajax({
                                    url: '/talentpoolController/saveUpdate',
                                    data: data,
                                    type: 'post',
                                    dataType: 'json',
                                    //回调函数--整个响应体
                                    success: function (json) {
                                        if (json && json.code == 200) {
                                            //执行重载
                                            cmd.reload('dataTable');
                                            layer.msg(json.msg);
                                            layer.close(index);
                                        } else {
                                            layer.msg('数据有误');
                                        }
                                    },
                                    error: function () {
                                        layer.msg('系统出错,请联系管理员');
                                    }

                                })

                                return false;
                            });
                        },
                        yes: function (index, layero) {
                            layero.find('.icon-save').click();
                            //layer.close(index);
                        }

                    });

                }
            });

            // 监听搜索查询按钮点击事件--高级查询在这里发送数据到后台
            form.on('submit(searchForm)', function (data) {
                //layer.msg(JSON.stringify(data.field));
                $.get("/talentpoolController/findName?name="+data.field.name,function (d) {
                })
                var datas=utils.removeNull(data.field)
                // 重新加载表格数据
                cmd.reload('dataTable',datas);
                return false;
            });

        },
        // 绑定事件
        bindEvent: function () {
            //导出
            $("#export").click(function () {
                location.href = '/talentpoolController/export';
            });
            // 批量删除
            $('#deletesBtn').click(function () {
                layer.confirm('批量删除吗', function (index) {
                    var checkStatus = table.checkStatus('dataTable');
                    //如果选中的数据长度大于0，那么就执行批量删除，否则提示数据有误 if (checkStatus.data.length>0) {
                    if (checkStatus) {
                        var ids = "";
                        var arr = [];
                        $.each(checkStatus.data, function (index, item) {
                            arr.push(item.id);
                        });
                        ids = arr.join(',');
                        $.ajax({
                            url: '/talentpoolController/deletes',
                            data: {"ids": ids},
                            type: 'post',
                            dataType: 'json',
                            success: function (json) {
                                if (json && json.code == 200) {
                                    //执行重载
                                    cmd.reload('dataTable');
                                    layer.msg(json.msg);
                                    layer.close(index);
                                } else {
                                    layer.msg('数据有误');
                                }
                            },
                            error: function () {
                                layer.msg('请联系管理员');
                            }
                        })
                    }
                })
            });
            //面试邀请--监听面试邀请的按钮
            $("#offer").click(function () {
                var checkStatus = table.checkStatus('dataTable');
                if (checkStatus.data.length>0) {
                    layer.confirm('是否发送', function (index) {
                        if (checkStatus) {
                            var ids = "";
                            var arr = [];
                            $.each(checkStatus.data, function (index, item) {
                                arr.push(item.id);
                            });

                            ids = arr.join(',');
                            $.ajax({
                                url: '/talentpoolController/offer',
                                data: {"ids": ids},
                                type: 'post',
                                dataType: 'json',
                                success: function (json) {
                                    if (json && json.code == 200) {
                                        //执行重载
                                        cmd.reload('dataTable');
                                        layer.msg(json.msg);
                                        layer.close(index);
                                    } else {
                                        layer.msg('数据有误');
                                    }
                                },
                                error: function () {
                                    layer.msg('邮件发送成功');
                                }

                            })
                        }
                    })
                }else {
                    layer.alert('请选择潜在人才！！！', {
                        closeBtn: 0
                    });
                }
            })


            // 表格刷新
            $("#refrsh").click(function () {
                // 重置表单
                $("#search-form")[0].reset();
                //执行重载
                table.reload('dataTable', {
                    page: {
                        curr: 1
                    },
                    where: {

                    }
                });
            })
        },

        // 弹窗
        initOpenWindow: function () {
            // 添加弹窗
            hpWindow.open("#addBtn", "/talentpoolController/saveUpdatePage", {
                title: '添加',
                area: ['500px', '550px'],
                btn: ['确认', '取消'],
                anim: 1,
                success: function (layero, index) {
                    form.render();
                    form.on('submit(save)', function (data) {
                        var data = $('#hp-form').serializeJson();
                        $.ajax({
                            url: '/talentpoolController/saveUpdate',
                            data: data,
                            type: 'post',
                            dataType: 'json',
                            success: function (json) {
                                if (json && json.code == 200) {
                                    //执行重载
                                    cmd.reload('dataTable');
                                    layer.msg(json.msg);
                                    layer.close(index);
                                } else {
                                    layer.msg('数据有误');
                                }
                            },
                            error: function () {
                                layer.msg('系统出错,请联系管理员');
                            }

                        })

                        return false;
                    });
                },
                yes: function (index, layero) {
                    layero.find('.icon-save').click();
                    //layer.close(index);
                }

            });


        },
        // 格式化
        fmt: {
            // 性别格式化
            sex: function (d) {
                var html = '';
                if (d.sex == 1) {
                    html = '男';
                } else {
                    html = '女';
                }
                return html;
            }
        },
        // 刷新表格
        reload: function (id, data) {
            // 加载loading
            var tableLoad = layer.load();
            //执行重载
            dataTable.reload( {
                page: {
                    curr: 1 //重新从第 1 页开始
                },
                where: data,//参数,
                done: function () {
                    // 关闭加载loading
                    layer.close(tableLoad);
                    // 清除where参数（如果不清会保留上次的参数）
                    // this.where={};
                }
            });

        }

    }
    // 执行cmd初始化
    cmd.init();


})