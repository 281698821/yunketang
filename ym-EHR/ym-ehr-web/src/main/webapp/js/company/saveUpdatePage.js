// layui 模块
layui.use(['form', 'laydate', 'upload', 'layer', 'layedit'], function () {
    var form = layui.form;
    var laydate = layui.laydate;
    var upload = layui.upload;
    var layer = layui.layer;
    var $ = layui.$;
    var cmd = {
        //  初始化
        init: function () {
            this.initEvent();           // 初始化事件
            this.initDataView();        // 数据渲染
        },
        //  初始化事件
        initEvent: function () {
          /*  // 监听搜索添加按钮点击事件
            form.on('submit(saveForm)', function (data) {
                $.ajax({
                    type: "POST",
                    url: "/companyController/saveUpdate",
                    async: false,
                    data: data.field,
                    success: function(msg){
                        layer.alert( "数据保存" + msg );
                    }
                });
                return true;
            });*/
        },
        // 数据渲染
        initDataView: function () {

            if (data.id > 0) {
                // 渲染表单
                form.render();
            }

        }
    }

    // 执行cmd初始化
    cmd.init();
})