// layui  配置
layui.config({
    base: '/modules/' // 扩展模块目录
}).extend({ // 模块别名
    hpWindow: 'hpComponent/hpWindow',
    hpConfig: 'hpComponent/hpConfig',
    utils: 'admin/utils',
});
// layui初始化模块使用
layui.use(['table', 'hpWindow','utils','laydate'], function () {
    var table = layui.table;
    var $ = layui.$;
    var hpWindow = layui.hpWindow;
    var form = layui.form;
    var utils = layui.utils;
    var dataTable;//解决表格查询会保留上次的参数
    var laydate = layui.laydate;
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
                url: "/departureController/ajaxList",
                cellMinWidth: 80,
                showLoad: true,
                page: true,
                toolbar:"#toolbarDemo",
                loading: false,
                cols: [[
                    {type: 'checkbox', fixed: 'left'},
                    {field: 'id', align: 'center', title: '编号'},
                    {field: 'instructions', align: 'center', title: '离职说明'},
                    {field: 'departuretime' ,align: 'center', title: '离职时间'},
                    {field: 'empId', align: 'center', templet:cmd.fmt.empName,title: '离职员工'},

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
                            url: '/departureController/delete',
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
                    hpWindow.openOne(".updateBtn", "/departureController/saveUpdatePage?id=" + data.id, {
                        title: '修改',
                        area: ['400px', '400px'],
                        btn: ['确认', '取消'],
                        anim: 1,
                        success: function (layero, index) {
                            form.render();
                            form.on('submit(save)', function (data) {
                                var data = $('#hp-form').serializeJson();
                                $.ajax({
                                    url: '/departureController/saveUpdate',
                                    data: data,
                                    type: 'post',
                                    dataType: 'json',
                                    success: function (json) {
                                        if (json && json.code == 200) {
                                            //执行重载
                                            //layer.msg(JSON.stringify(data.field));
                                            var datas=utils.removeNull(data.field)
                                            console.debug(datas)
                                            // 重新加载表格数据
                                            cmd.reload('dataTable',datas);
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
                var start = document.getElementById("start_date").value;
                var end = document.getElementById("end_date").value;
                $.ajax({
                    url: '/departureController/queryDate2',
                    data: {"start": start,"end":end,"page":page,"limit":limit},
                    type: 'post',
                    dataType: 'json',
                    success: function (json) {
                        console.debug(json)
                        if (json && json.code == 200) {
                            //执行重载
                            //layer.msg(JSON.stringify(data.field));
                            var datas=utils.removeNull(data.field)
                            // 重新加载表格数据
                            cmd.reload('dataTable',datas);
                        }else {
                            layer.msg('数据有误');
                        }
                    },
                    error: function () {
                        layer.msg('系统出错,请联系管理员');
                    }
                })
                //layer.msg(JSON.string9ify(data.field));
                // var datas=utils.removeNull(data.field)
                // var datas=utils.removeNull(data.form)
                // 重新加载表格数据
                // cmd.reload('dataTable',datas);

                return false;
            });

        },
        // 绑定事件
        bindEvent: function () {
            //导出
            $("#export").click(function () {
                location.href = '/departureController/export';
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
                            url: '/departureController/deletes',
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
            hpWindow.open("#addBtn", "/departureController/saveUpdatePage", {
                title: '添加',
                area: ['400px', '400px'],
                btn: ['确认', '取消'],
                anim: 1,
                success: function (layero, index) {
                    form.render();
                    form.on('submit(save)', function (data) {
                        var data = $('#hp-form').serializeJson();
                        $.ajax({
                            url: '/departureController/saveUpdate',
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
        fmt: {
            empName: function (d) {
                var html = '';
                $.ajax({
                    url: "/departureController/getName?id="+d.empId,
                    async: false,
                    success: function (data) {
                        if (data) {
                            html = data.name;
                        } else {
                            html = "用户名不存在"
                        }
                    }
                })
                return html;
            },
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
    // laydate.render({
    //     elem: '#start_date'
    // });
    // laydate.render({
    //     elem: '#end_date'
    // });

    // 执行cmd初始化
    cmd.init();
})