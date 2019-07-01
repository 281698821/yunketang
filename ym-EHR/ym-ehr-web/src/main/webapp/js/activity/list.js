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
                url: "/activityController/ajaxList",
                cellMinWidth: 80,
                showLoad: true,
                page: true,
                loading:false,
             //   id:'idTest',
                cols: [[
                    {type: 'checkbox', fixed: 'left'},
                    {field: 'theme', width: 100, fixed: true, align: 'center', title: '主题'},
                    {field: 'activityaddress', align: 'center', title: '活动地址'},
                    {field: 'introduce', align: 'center', title: '活动简介'},
                    {field: 'activitythedetail', align: 'center', title: '活动详情'},
                    {field: 'initatetime', align: 'center', title: '活动时间'},
                    {field: 'spending', align: 'center', title: '活动消费'},
                    {field: 'state', align: 'center', templet: cmd.fmt.state, title: '状态'},
                    {field: 'emp',  templet: cmd.fmt.empFmt,align: 'center', title: '组织人'},
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
                            url: '/activityController/delete',
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
                    hpWindow.openOne(".updateBtn", "/activityController/saveUpdatePage?id=" + data.id, {
                        title: '修改',
                        area: ['550px', '550px'],
                        btn: ['确认', '取消'],
                        anim: 1,

                        success: function (layero, index) {
                            form.render();
                            form.on('submit(save)', function (data) {
                                var data = $('#hp-form').serializeJson();
                                $.ajax({
                                    url: '/activityController/saveUpdate',
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
                //layer.msg(JSON.stringify(data.field));
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
                location.href = '/activityController/export';
            });

            // 批量删除
            $('#deletesBtn').click(function () {
                var checkStatus = table.checkStatus('dataTable');

                if (checkStatus.data.length>0) {

                    layer.confirm('批量删除吗', function (index) {

                        if (checkStatus) {
                            var ids = "";
                            var arr = [];
                            $.each(checkStatus.data, function (index, item) {
                                arr.push(item.id);
                            });
                            ids = arr.join(',');

                            $.ajax({
                                url: '/activityController/deletes',
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
                }else {
                    layer.alert('请选择一个或多个活动', {
                        closeBtn: 0
                    });
                }

            });
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
            });
            $("#inform").click(function () {
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
                                url: '/activityController/inform',
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

                }else {
                    layer.alert('请选择一个或多个活动', {
                        closeBtn: 0
                    });
                }
            })
        },

        // 弹窗
        initOpenWindow: function () {
            // 添加弹窗
            hpWindow.open("#addBtn", "/activityController/saveUpdatePage", {
                title: '添加',
                area: ['550px', '550px'],
                btn: ['确认', '取消'],
                anim: 1,
                success: function (layero, index) {
                    form.render();
                    form.on('submit(save)', function (data) {
                        var data = $('#hp-form').serializeJson();
                        if (data.spending > 10000) {
                            layer.alert("活动经费超出预算")
                        } else {

                            $.ajax({
                                url: '/activityController/saveUpdate',
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
                         }
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

            // 状态格式化
            state: function (d) {
                var html = '';
                if (d.state == 1) {
                    html = '通过';
                } else {
                    html = '不通过';
                }
                return html;
            },
            //员工格式化
            empFmt: function (d) {
                return d.emp ? d.emp.name : "";
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