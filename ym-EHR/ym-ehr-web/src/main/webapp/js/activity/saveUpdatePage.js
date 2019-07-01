// layui  配置
layui.config({
    base: '/modules/' // 扩展模块目录
}).extend({ // 模块别名
    hpWindowS: 'hpComponent/hpWindowS',
});
// layui 模块
layui.use([ 'form', 'laydate', 'upload', 'layer','layedit' , 'hpWindowS'], function() {
    var form = layui.form;
    var laydate = layui.laydate;
    var upload = layui.upload;
    var layer = layui.layer;
    var layedit = layui.layedit;
    var hpWindowS = layui.hpWindowS;
    var $ = layui.$;
    hpWindowS.openList("#listBtn",'/activityController/empList',{},function(data,index,layro){
        //layer.alert(JSON.stringify(data))
        var json=data[0];
        $('#empName').val(json.name);
        $('#empId').val(json.id);
       // console.debug(json)
    })
    var cmd={
        //  初始化
        init: function () {
            this.initEvent();           // 初始化事件
            this.initDataView();        // 数据渲染
        },
        //  初始化事件
        initEvent: function () {
            //执行实例
            var uploadInst = upload.render({
                elem : '#kdUpload', //绑定元素
                url : '/common/upload/uploadFile', //上传接口

            });
            //日期
            laydate.render({
                elem : '#date'
            });


            //自定义验证规则
            form.verify({
                   content: function(value){
                    layedit.sync(demo1);
                }
            });

            layedit.set({
                uploadImage: {
                    url: '/common/upload/uploadLayedit' //接口url
                }
            });
            //构建一个默认的编辑器
            var demo1 = layedit.build('LAY_demo1');



        },
        // 数据渲染
        initDataView:function () {

            if(data.id>0){
                // 状态
                var state = data.state;
                // 选中
                $(':radio[name="sex"][value=' + state + ']').prop("checked",
                    "checked");
                // 渲染表单
                form.render();
            }

        }
    }

    // 执行cmd初始化
    cmd.init();

})