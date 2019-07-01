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
                url: "/recruitmentdemandController/ajaxList",
                cellMinWidth: 80,
                showLoad: true,
                page: true,
                loading: false,
                cols: [[
                    {type: 'checkbox', fixed: 'left'},
                    {field: 'skillsrequired', align: 'center', title: '技能要求'},
                    {field: 'hiring', align: 'center', title: '招聘人数'},
                    {field: 'wagebudget', align: 'center', title: '薪资预算'},
                    {field: 'initiatetime', align: 'center', title: '发起时间'},
                    {field: 'state', align: 'center', templet: cmd.fmt.state, title: '状态'},
                    {field: 'mark', align: 'center', title: '备注'},
                    {field: 'emp', align: 'center', templet: cmd.fmt.emp, title: '发布人'},
                    {fixed: 'right', width: 178, align: 'center', toolbar: '#barTool', title: '操作'}
                ]],
                // 数据渲染完成回调
                done: function (cols) {
                    layer.close(tableLoad);
                }
            });
            //监听工具条
            table.on('tool(tableTool)', function (obj) {
                var data = obj.data;

                if (obj.event === 'del') {
                    layer.confirm('真的删除行么', function (index) {
                        $.ajax({
                            url: '/recruitmentdemandController/delete',
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
                    hpWindow.openOne(".updateBtn", "/recruitmentdemandController/saveUpdatePage?id=" + data.id, {
                        title: '修改',
                        area: ['550px', '550px'],
                        btn: ['确认', '取消'],
                        anim: 1,
                        success: function (layero, index) {
                            form.render();
                            form.on('submit(save)', function (data) {
                                var data = $('#hp-form').serializeJson();
                                $.ajax({
                                    url: '/recruitmentdemandController/saveUpdate',
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

                }
            });

            // 监听搜索查询按钮点击事件
            form.on('submit(searchForm)', function (data) {
                // console.log(data);
                //layer.msg(JSON.stringify(data.field));
                var datas = utils.removeNull(data.field);
                // 重新加载表格数据
                cmd.reload('dataTable', datas);
                return false;
            });

        },
        // 绑定事件
        bindEvent: function () {
            //导出
            $("#export").click(function () {
                location.href = '/recruitmentdemandController/export';
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
                            url: '/recruitmentdemandController/deletes',
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
                    where: {

                    }
                });
            })
        },

        // 弹窗
        initOpenWindow: function () {
            // 添加弹窗
            hpWindow.open("#addBtn", "/recruitmentdemandController/saveUpdatePage", {
                title: '添加',
                area: ['550px', '550px'],
                btn: ['确认', '取消'],
                anim: 1,
                success: function (layero, index) {
                    form.render();
                    form.on('submit(save)', function (data) {
                        var data = $('#hp-form').serializeJson();
                        //alert(data.empId);
                        //将当前登陆用户设置为发布人
                        // if (data != null && data != '') {
                        //     var keyuserb = "";
                        //     alert(keyuserb);
                        //     data.empId = 2;
                        // }
                        $.ajax({
                            url: '/recruitmentdemandController/saveUpdate',
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
            state: function (d) {
                var html = '';
                if (d.state == 1) {
                    return html = '<font color="#489a34">已处理</font>';
                } else if (d.state == 2) {
                    return html = '<font color="#FF0000">未处理</font>';
                }
                return html;
            },
            emp: function (d) {
                var name = '';
                if (d.emp != null && d.emp != "") {
                    return d.emp.name;
                }
                return name;
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
                    this.where={};
                }
            });

        }

    }
    // 执行cmd初始化
    cmd.init();


})