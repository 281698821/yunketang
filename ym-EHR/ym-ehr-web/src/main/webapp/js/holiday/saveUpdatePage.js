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
        },
        //  初始化事件
        initEvent: function () {

            //日期
            laydate.render({
                elem : '#date'
            });

        },

    }

    // 执行cmd初始化
    cmd.init();





})