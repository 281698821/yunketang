// layui 模块
layui.use([ 'form', 'laydate', 'upload', 'layer' ], function() {
    var form = layui.form;
    var laydate = layui.laydate;
    var upload = layui.upload;
    var layer = layui.layer;
    //定义jquery的变量
    var $ = layui.$;

    var cmd={
        // 初始化
        init: function () {
            this.initEvent();// 初始化事件
            this.initDataView();// 数据渲染
        },
        //  初始化事件
        initEvent: function () {
            //日期
            laydate.render({
                //用latui的date组件渲染出date数据
                elem : '#date'
            });

        },
        // 数据渲染
        initDataView:function () {

        }
    }

    // 执行cmd初始化
    cmd.init();


})