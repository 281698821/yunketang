<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
</head>

<style>
</style>

<body>
<div class="hp-open-list">

    <form id="hp-form" class="layui-form ">

        <div class="layui-form-item">
            <label class="layui-form-label">公司名称:</label>
            <div class="layui-input-inline" style="width: 200px;">
                <input type="text" name="name" lay-verify="required"
                       value="${company.name}" autocomplete="off" placeholder="请输入公司名称"
                       class="layui-input">
            </div>
        </div>



        <div class="layui-form-item">
            <label class="layui-form-label">公司地址:</label>
            <div class="layui-input-inline" style="width: 200px;">
                <input type="text" name="address" lay-verify="required"
                       value="${company.address}" autocomplete="off" placeholder="请输入公司地址"
                       class="layui-input">
            </div>
        </div>


        <div class="layui-form-item">
            <label class="layui-form-label">公司描述:</label>
            <div class="layui-input-inline" style="width: 200px;">
                <textarea name="mark" id="mark" placeholder="请输入公司描述" class="layui-textarea">${company.mark}</textarea>
            </div>
        </div>


        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" id="saveForm" lay-submit lay-filter="saveForm">立即提交</button>
                <button type="reset" id="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>

       <%-- <button class="layui-btn layui-btn-small bcql-icon icon-save"
                lay-submit lay-filter="save" style="display: none;"></button>--%>

        <!-- 隐藏域 -->
        <input name="id" type="hidden" value="${company.id}" />

    </form>

</div>

<script>
    // 初始化数据
    layui.use(['form', 'upload', 'layer', 'layedit'], function () {
        var form = layui.form;
        var layer = layui.layer;
        var $ = layui.$;
        //重载表单
       /* $(document).on('click','#reset',function () {
            $("#hp-form")[0].reset();
        });*/
        form.on('submit(saveForm)', function (data) {
            $.ajax({
                type: "POST",
                url: "/companyController/saveUpdate",
                async: false,
                data: data.field,
                success: function(msg){
                    layer.msg( "数据保存" + msg.msg);
                }
            });
            return true;
        });
        form.render();
    });
    //重载保存表单
    var data={
        id:"${company.id}",
    }
</script>

<%--<script type="text/javascript" src="/js/company/saveUpdatePage.js"></script>--%>

</body>

</html>