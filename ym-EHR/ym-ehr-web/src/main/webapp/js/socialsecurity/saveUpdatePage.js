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
        //  初始化事件
        initEvent: function () {
            //执行实例
            /*var uploadInst = upload.render({
                elem : '#kdUpload', //绑定元素
                url : '/common/upload/uploadFile', //上传接口
                done : function(json) {
                    if (json.code == 200) {
                        /!*$('#kdImg').attr('src',  "/" + json.data);
                        $('#hiddenImg').val(json.data)*!/
                        layer.msg('上传成功')
                    } else {
                        layer.msg('上传失败')
                    }

                },
                error : function() {
                    //请求异常回调
                    layer.msg('上传失败')
                }
            });*/
        },
    };
    // 执行cmd初始化
    cmd.init();

});