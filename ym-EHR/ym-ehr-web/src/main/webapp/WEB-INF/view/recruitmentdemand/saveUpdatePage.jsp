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
    <form id="hp-form" class="layui-form layui-form-pane ">

        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">技能要求:</label>
            <div class="layui-input-block">
                <textarea placeholder="请输入..." required lay-verify="required" class="layui-textarea" name="skillsrequired">${recruitmentdemand.skillsrequired}</textarea>
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">招聘人数:</label>
            <div class="layui-input-block">
                <input type="text" name="hiring" lay-verify="number"
                       value="${recruitmentdemand.hiring}" autocomplete="off" placeholder="请输入..."
                       class="layui-input">
            </div>
        </div>


        <div class="layui-form-item">
            <label class="layui-form-label">薪资预算</label>
            <div class="layui-input-block">
                <input type="text" name="wagebudget" lay-verify="number"
                       value="${recruitmentdemand.wagebudget}" autocomplete="off" placeholder=""
                       class="layui-input">
            </div>
        </div>


        <div class="layui-form-item">
            <label class="layui-form-label">发起时间:</label>
            <div class="layui-input-block">
                <input type="text" name="initiatetime" id="date"
                       value='<fmt:formatDate pattern="yyyy-MM-dd" value="${recruitmentdemand.initiatetime}"/>'
                       lay-verify="date" placeholder="请选择年-月-日" autocomplete="off"
                       class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">状态</label>
            <div class="layui-input-block">
                <select name="state" lay-filter="aihao">
                    <option value="1">已处理</option>
                    <option value="2"selected >未处理</option>
                </select>
            </div>
        </div>


        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">备注:</label>
            <div class="layui-input-block">
                <textarea placeholder="请输入..." required lay-verify="required" class="layui-textarea" name="mark">${recruitmentdemand.mark}</textarea>
            </div>
        </div>

        <button class="layui-btn layui-btn-small bcql-icon icon-save"
                lay-submit lay-filter="save" style="display: none;"></button>


        <!-- 隐藏域 -->
        <input name="id" type="hidden" value="${recruitmentdemand.id}"/>
        <input name="empId" type="hidden" value="${EMP_IN_SESSION.id}"/>


    </form>
</div>
<script>
    var data = {
        id: "${recruitmentdemand.id}",
        state: "${recruitmentdemand.state}",
        empId:"${recruitmentdemand.empId}"
    }
</script>
<script type="text/javascript" src="/js/recruitmentdemand/saveUpdatePage.js"></script>
</body>

</html>