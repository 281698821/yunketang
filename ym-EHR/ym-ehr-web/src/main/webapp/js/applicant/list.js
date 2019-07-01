// layui  配置
layui.config({
    base: '/modules/' // 扩展模块目录
}).extend({ // 模块别名
    hpWindow: 'hpComponent/hpWindow',
    hpConfig: 'hpComponent/hpConfig',
    utils: 'admin/utils',
});
// layui初始化模块使用
layui.use(['table', 'hpWindow', 'utils'], function () {
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
            dataTable = table.render({
                elem: '#dataTable',
                url: "/applicantController/ajaxList",
                cellMinWidth: 80,
                showLoad: true,
                page: true,
                loading: false,
                cols: [[
                    {type: 'checkbox', fixed: 'left'},
                    {field: 'name', align: 'center', title: '名字'},
                    {field: 'sex', align: 'center', templet: cmd.fmt.sex, title: '性别'},
                    {field: 'qq', align: 'center', title: 'QQ'},
                    {field: 'phone', align: 'center', templet: cmd.fmt.phone, title: '电话'},
                    {field: 'email', align: 'center', templet: cmd.fmt.email, title: '邮箱'},
                    {field: 'age', align: 'center', templet: cmd.fmt.age, title: '年龄'},
                    {field: 'currentaddress', align: 'center', templet: cmd.fmt.currentaddress, title: '现住址'},
                    {field: 'applicanttime', align: 'center', templet: cmd.fmt.applicanttime, title: '应聘时间'},
                    {field: 'specialty', align: 'center', templet: cmd.fmt.specialty, title: '技术特长'},
                    {field: 'comments', align: 'center', templet: cmd.fmt.comments, title: '试官评价面'},
                    {field: 'mark', align: 'center', templet: cmd.fmt.mark, title: '备注'},
                    {fixed: 'right', width: 300, align: 'center', toolbar: '#barTool', title: '操作'}
                ]],
                // 数据渲染完成回调
                done: function (cols) {
                    layer.close(tableLoad);

                }
            });
            //监听工具条barTool
            table.on('tool(tableTool)', function (obj) {
                let data = obj.data;

                if (obj.event === 'del') {
                    layer.confirm('真的删除行么', function (index) {
                        $.ajax({
                            url: '/applicantController/delete',
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
                    hpWindow.openOne(".updateBtn", "/applicantController/saveUpdatePage?id=" + data.id, {
                        title: '修改',
                        area: ['550px', '550px'],
                        btn: ['确认', '取消'],
                        anim: 1,
                        success: function (layero, index) {
                            form.render();
                            form.on('submit(save)', function (data) {
                                var data = $('#hp-form').serializeJson();
                                $.ajax({
                                    url: '/applicantController/saveUpdate',
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

                } else if (obj.event === 'sendOffer') {
                    //发送邮件
                    $.ajax({
                        url: '/applicantController/email',
                        data: {"email": data.email, "nameArr": data.name},
                        type: 'post',
                        dataType: 'json',
                        success: function (json) {
                            if (json && json.code == 200) {
                                //执行重载
                                //cmd.reload('dataTable');
                                layer.msg(json.msg);
                            } else {
                                layer.msg('数据有误');
                            }
                        },
                        error: function () {
                            layer.msg('系统出错,请联系管理员');
                        }
                    })
                } else if (obj.event === 'enrollEmp') {
                    //录入员工
                    $.ajax({
                        url: '/applicantController/enrollEmp',
                        data: {"appId": data.id},
                        type: 'post',
                        dataType: 'json',
                        success: function (json) {
                            if (json && json.code == 200) {
                                //执行重载
                                //cmd.reload('dataTable');
                                layer.msg(json.msg);
                            } else {
                                layer.msg('数据有误');
                            }
                        },
                        error: function () {
                            layer.msg('系统出错,请联系管理员');
                        }
                    })
                }
            });

            // 监听搜索查询按钮点击事件
            form.on('submit(searchForm)', function (data) {
                //layer.msg(JSON.stringify(data.field));
                var datas = utils.removeNull(data.field)
                // 重新加载表格数据
                cmd.reload('dataTable', datas);
                return false;
            });

        },
        // 绑定事件
        bindEvent: function () {
            //导出
            $("#export").click(function () {

                location.href = '/applicantController/export';

            });

            // 批量发邮件
            $('#sendOffer').click(function () {
                layer.confirm('批量发送吗', function (index) {
                    var checkStatus = table.checkStatus('dataTable');
                    if (checkStatus) {
                        var email = "";
                        var arr = [];
                        var name = "";
                        var nameArr = [];
                        $.each(checkStatus.data, function (index, item) {
                            arr.push(item.email);
                        });
                        $.each(checkStatus.data, function (index, item) {
                            nameArr.push(item.name);
                        });
                        email = arr.join(',');
                        name = nameArr.join(',');
                        $.ajax({
                            url: '/applicantController/email',
                            data: {"email": email, "nameArr": name},
                            type: 'post',
                            dataType: 'json',
                            success: function (json) {
                                if (json && json.code == 200) {
                                    //执行重载
                                    cmd.reload('dataTable');
                                    layer.msg(json.msg);
                                } else {
                                    layer.msg('数据有误');
                                }
                            },
                            error: function () {
                                layer.msg('系统出错,请联系管理员');
                            }

                        })

                    }

                })

            });
            // 批量删除
            $('#deletesBtn').click(function () {
                layer.confirm('批量删除吗', function (index) {
                    var checkStatus = table.checkStatus('dataTable');
                    if (checkStatus) {
                        var ids = "";
                        var arr = [];
                        $.each(checkStatus.data, function (index, item) {
                            arr.push(item.id);
                        });
                        ids = arr.join(',');
                        $.ajax({
                            url: '/applicantController/deletes',
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
                                layer.msg('系统出错,请联系管理员');
                            }

                        })

                    }

                })

            });
            // 表格刷新
            $("#refrsh").click(function () {
                // 重置表单
                //$("#search-form")[0].reset();
                document.getElementById("search-form").reset();
                //执行重载
                table.reload('dataTable', {
                    page: {
                        curr: 1
                    },
                    where: {}
                });
            })
        },

        // 弹窗
        initOpenWindow: function () {
            // 添加弹窗
            hpWindow.open("#addBtn", "/applicantController/saveUpdatePage", {
                title: '添加',
                area: ['550px', '550px'],
                btn: ['确认', '取消'],
                anim: 1,
                success: function (layero, index) {
                    form.render();
                    form.on('submit(save)', function (data) {
                        var data = $('#hp-form').serializeJson();
                        $.ajax({
                            url: '/applicantController/saveUpdate',
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
            // 头像格式化
            headImg: function (d) {
                var html = '';
                if (d.headImg) {
                    html = '<img class="layui-circle" style="height:30px;width:30px" src="' + '/' + d.headImg + '" />';
                } else {
                    html = '<img class="layui-circle" style="height:30px;width:30px" src="' + '/img/1.jpg"  />';
                }
                return html;
            },
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
            dataTable.reload({
                page: {
                    curr: 1 //重新从第 1 页开始
                },
                where: data,//参数,
                done: function () {
                    // 关闭加载loading
                    layer.close(tableLoad);
                    // 清除where参数（如果不清会保留上次的参数）
                    this.where = {};
                }
            });

        }

    }
    // 执行cmd初始化
    cmd.init();


})