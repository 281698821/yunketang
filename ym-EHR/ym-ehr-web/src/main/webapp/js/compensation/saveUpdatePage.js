
// layui 模块
layui.use([ 'form', 'laydate', 'upload', 'layer','hpWindow','hpWindowS' ], function() {
    var form = layui.form;
    var laydate = layui.laydate;
    var upload = layui.upload;
    var layer = layui.layer;
    var hpWindow = layui.hpWindow;
    var hpWindowS = layui.hpWindowS;
    var $ = layui.$;
    $.ajaxSettings.async = false;
    hpWindowS.openList("#listBtn2",'/compensation/savePage',{},function(data,index,layer){
        // layer.alert(JSON.stringify(data));
        var json=data[0];
        var paygrades =json.paygrades;
        var salary = paygrades.salary;
        $('#name').val(json.name);
        $('#empId').val(json.id);
        $('#paygrades').val(salary);
    });
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
           /* var uploadInst = upload.render({
                elem : '#kdUpload', //绑定元素
                url : '/common/upload/uploadFile', //上传接口
                done : function(json) {
                    if (json.code == 200) {
                        $('#kdImg').attr('src',  "/" + json.data);
                        $('#hiddenImg').val(json.data)
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
            //日期
            laydate.render({
                elem : '#date'
            });

        },
        // 数据渲染
        initDataView:function () {
            if(data.id){
                // 社保
                var socialsecurity = data.socialsecurity;
                // 渲染表单
                form.render();
            }

        }
    };

    // 执行cmd初始化
    cmd.init();
})