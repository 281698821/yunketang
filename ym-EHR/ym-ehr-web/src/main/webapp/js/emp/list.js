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
                url: "/empController/ajaxList",
                cellMinWidth: 80,
                showLoad: true,
                page: true,
                loading:false,
                cols: [[
                    {type: 'checkbox', fixed: 'left'},
                    {field: 'id', align: 'center', title: '工号'},
                    {field: 'img', width: 100, templet: cmd.fmt.headImg,  align: 'center', title: '头像'},
                    {field: 'name', align: 'center', title: '名字'},
                    {field: 'password', align: 'center', title: '密码'},
                    {field: 'birthday', align: 'center', title: '生日'},
                    {field: 'sex', align: 'center',title: '性别'},
                    {field: 'deptId', align: 'center', title: '部门',templet: cmd.fmt.deptFormat},
                    {field: 'positionId', align: 'center', title: '职位',templet: cmd.fmt.positionFormat},
                    {field: 'phone', align: 'center', title: '电话'},
                    {field: 'qq', align: 'center', title: 'QQ'},
                    {field: 'email', align: 'center', title: '邮箱'},
                    {field: 'age', align: 'center', title: '年龄'},
                    {field: 'currentaddress', align: 'center', title: '现在住址'},
                    {field: 'inductiontime', align: 'center', title: '入职时间'},
                    {field: 'state', align: 'center', title: '状态',templet: cmd.fmt.stateFormat},
                    {field: 'specialty', align: 'center', title: '特长'},
                    {field: 'mark', align: 'center', title: '备注'},

                    {field: 'paygradesId', align: 'center', title: '薪资等级',templet: cmd.fmt.paygradesFormat},

                    /*{field: 'logicToDelete', align: 'center', title: '逻辑删除（默认为1，删除后为0）'},*/
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
                            url: '/empController/delete',
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
                    hpWindow.openOne(".updateBtn", "/empController/saveUpdatePage?id=" + data.id, {
                        title: '修改',
                        area: ['550px', '550px'],
                        btn: ['确认', '取消'],
                        anim: 1,
                        success: function (layero, index) {
                            form.render();
                            form.on('submit(save)', function (data) {
                                var data = $('#hp-form').serializeJson();
                                $.ajax({
                                    url: '/empController/saveUpdate',
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
                location.href = '/empController/export';
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
                            url: '/empController/deletes',
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
       /* empName:function (d) {
            var html = '';
            $.ajax({
                url:`/emp/getName?id=${d.empId}`,
                async:false,
                success:function (data) {
                    if (data){
                        html = data.name;
                    }else{
                        html = "坏味道"
                    }
                }
            })
            return html;
        },*/

        // 弹窗
        initOpenWindow: function () {
            // 添加弹窗
            hpWindow.open("#addBtn", "/empController/saveUpdatePage", {
                title: '添加',
                area: ['550px', '550px'],
                btn: ['确认', '取消'],
                anim: 1,
                success: function (layero, index) {
                    form.render();
                    form.on('submit(save)', function (data) {
                        var data = $('#hp-form').serializeJson();
                        $.ajax({
                            url: '/empController/saveUpdate',
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
                if (d.img) {
                    html = '<img class="layui-circle" style="height:30px;width:30px" alt="图片显示异常" src="' + d.img + '" />';
                } else {
                    html = '<img class="layui-circle" style="height:30px;width:30px" src="' + '/img/1.jpg"  />';
                }
                return html;
            },
            deptFormat:function (d) {
                return d.dept?d.dept.name:"";
            },
            positionFormat:function (d) {
                return d.position?d.position.name:"";
            },
            paygradesFormat:function (d) {
                return d.paygrades?d.paygrades.id:"";
            },
            /*在职(1)，出差(2)，离职(3)，休假(4)，请假(5)*/
            stateFormat:function (d) {
              if(d.state==1){
                  return '<font color="green">在职</font>';
              }else if(d.state==2){
                  return '<font color="red">出差</font>';
              }else if(d.state==3){
                  return '<font color="yellow">离职</font>';
              }else if(d.state==4){
                  return '<font color="#ff4500">休假</font>';
              }else{
                  return '<font color="blue">请假</font>';
              }
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