<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
</head>

<style>
    .hp-img {
        height: 60px;
        width: 60px;
        margin-left: 30px;
        margin-bottom: 3px;
    }

</style>

<body>
<div class="hp-open-list">
    <form id="hp-form" class="layui-form layui-form-pane">
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">渠道名称或地址:</label>
            <div class="layui-input-block">
                <textarea placeholder="渠道名称或地址" required lay-verify="required" class="layui-textarea"
                          name="name">${channel.name}</textarea>
            </div>
        </div>

        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">备注:</label>
            <div class="layui-input-block">
                <textarea placeholder="请输入..." required lay-verify="required" class="layui-textarea"
                          name="mark">${channel.mark}</textarea>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">渠道上传时间:</label>
            <div class="layui-input-block">
                <input type="text" name="addtime" id="date"
                       value='<fmt:formatDate pattern="yyyy-MM-dd" value="${channel.addtime}"/>'
                       lay-verify="date" placeholder="请选择年-月-日" autocomplete="off"
                       class="layui-input">
            </div>
        </div>



        <button class="layui-btn layui-btn-small bcql-icon icon-save"
                lay-submit lay-filter="save" style="display: none;"></button>


        <!-- 隐藏域 -->
        <input name="id" type="hidden" value="${channel.id}"/>


    </form>
</div>
<script>
    // 初始化数据
    var data = {
        id: "${channel.id}",
    }
</script>
<script type="text/javascript" src="/js/channel/saveUpdatePage.js"></script>
</body>

</html>