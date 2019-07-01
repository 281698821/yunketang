// layui 模块
layui.use([ 'form', 'laydate', 'upload', 'layer' ], function() {
    var form = layui.form;
    var laydate = layui.laydate;
    var upload = layui.upload;
    var layer = layui.layer;
    var $ = layui.$;
    //
    var cmd={
        //  初始化
        init: function () {
            this.initEvent();           // 初始化事件
            this.initDataView();        // 数据渲染
        },


        // 数据渲染
        initDataView:function () {

            if(data.id>0){

                form.render();
            }

        }
    }

    // 执行cmd初始化
    cmd.init();





})