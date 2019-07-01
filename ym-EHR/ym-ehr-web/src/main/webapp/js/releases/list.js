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
                url: "/releasesController/ajaxList",
                cellMinWidth: 80,
                showLoad: true,
                page: true,
                loading:false,
                cols: [[
                    {type: 'checkbox', fixed: 'left'},
                    {field: 'skillsrequired', align: 'center', title: '技能要求'},
                    {field: 'hiring', align: 'center', title: '招聘人数'},
                    {field: 'wagebudget', align: 'center', title: '薪资预算'},
                    {field: 'initiatetime', align: 'center', title: '发起时间'},
                    {field: 'state', align: 'center',templet:cmd.fmt.stateFmt,title: '状态'},
                    {field: 'mark', align: 'center', title: '备注'},
                    {field: 'empId',align: 'center', templet: cmd.fmt.empFmt, title: '发布人'},//外键
                    {field: 'channelId', align: 'center', templet:cmd.fmt.channelFmt, title: '渠道'},//外键
                    {field: 'logictodelete', align: 'center',templet:cmd.fmt.delFmt,title: '逻辑删除'},//假删除
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
                            url: '/releasesController/delete',
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
                }
                //工具栏的编辑方法
                else if (obj.event === 'edit') {
                    //提交修改
                    hpWindow.openOne(".updateBtn", "/releasesController/saveUpdatePage?id=" + data.id, {
                        title: '修改',
                        area: ['400px', '550px'],
                        btn: ['确认', '取消'],
                        anim: 1,
                        success: function (layero, index) {
                            form.render();
                            form.on('submit(save)', function (data) {
                                var data = $('#hp-form').serializeJson();
                                $.ajax({
                                    url: '/releasesController/saveUpdate',
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
                location.href = '/releasesController/export';
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
                            url: '/releasesController/deletes',
                            data: {"ids": ids},
                            type: 'post',
                            dataType: 'json',
                            //返回后台返回来的json数据
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
        // 弹窗--添加的方法
        initOpenWindow: function () {
            // 添加弹窗--点击添加按钮时弹出的表单
            hpWindow.open("#addBtn", "/releasesController/saveUpdatePage", {
                title: '添加',
                area: ['400px', '550px'],
                btn: ['确认', '取消'],
                anim: 1,
                success: function (layero, index) {
                    form.render();

                    //用户填写完表单后，监听隐藏的添加按钮
                    form.on('submit(save)', function (data) {
                        var data = $('#hp-form').serializeJson();
                        $.ajax({
                            url: '/releasesController/saveUpdate',
                            data: data,
                            type: 'post',
                            dataType: 'json',
                            //返回成功的数据
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
            stateFmt: function (d) {
                var html = '';
                if (d.state == 1) {
                    html = '<font color="#489a34">已处理</font>';
                } else {
                    html = '<font color="#FF0000">未处理</font>';
                }
                return html;
            },
            //员工格式化
            empFmt:function (d) {
                var a = '';
                $.ajax({
                    //提交员工表的id到对应的Controller,用飘提交get请求
                    url:`/releasesController/getEmpName?id=${d.empId}`,
                    async:false,
                    success:function (data) {
                        if (data){
                            a = data.name;
                        }else{
                            a = "数据有误"
                        }
                    }
                })
                return a;
            },
            //渠道格式化,获取flied中的id
            channelFmt:function (d) {
                var a = '';
                $.ajax({
                    //提交员工表的id到对应的Controller,用飘提交get请求
                    url:`/releasesController/getchannelName?id=${d.channelId}`,
                    async:false,
                    success:function (data) {
                        if (data){
                            a = data.name;
                        }else{
                            a = "数据有误"
                        }
                    }
                })
                return a;
            },
            //假删除格式化
            delFmt:function(d){
                var html = '';
                if (d.logictodelete == 1) {
                    html = '<font color="#489a34">未删除</font>';
                }if(d.logictodelete == 0) {
                    html = '<font color="#FF0000">已删除</font>';
                }
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
    // 执行cmd初始化
    cmd.init();

})