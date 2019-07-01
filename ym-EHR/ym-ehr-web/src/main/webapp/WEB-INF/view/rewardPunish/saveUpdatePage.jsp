<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
    <form id="hp-form" class="layui-form ">

        <div class="layui-form-item">
            <label class="layui-form-label">情况说明:</label>
            <div class="layui-input-inline" style="width: 150px;">
                <input type="text" name="situation" lay-verify="required"
                       value="${rewardPunish.situation}" autocomplete="off" placeholder="请输入情况说明"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">金额:</label>
            <div class="layui-input-inline" style="width: 150px;">
                <input type="text" name="money" lay-verify="required"
                       value="${rewardPunish.money}" autocomplete="off" placeholder="请输入金额"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">判断:</label>
            <div class="layui-input-inline" style="width: 150px;">
                <input type="text" name="judge" lay-verify="required"
                       value="${rewardPunish.judge}" autocomplete="off" placeholder="请输入判断"
                       class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">奖惩时间:</label>
            <div class="layui-input-inline" style="width: 150px;">
                <input type="text" name="time" id="date"
                       value='<fmt:formatDate pattern="yyyy-MM-dd" value="${rewardPunish.time}"/>'
                       lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off"
                       class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">员工:</label>
            <div class="layui-input-inline" style="width: 150px;">
                <input type="text" name="empId" lay-verify="required"
                       value="${rewardPunish.empId}" autocomplete="off" placeholder="请输入员工"
                       class="layui-input">
            </div>
        </div>

        <button class="layui-btn layui-btn-small bcql-icon icon-save"
                lay-submit lay-filter="save" style="display: none;"></button>

        <!-- 隐藏域 -->
        <input name="id" type="hidden" value="${rewardPunish.id}" />
    </form>
</div>
<script>
    // 初始化数据
    var data={
        id:"${rewardPunish.id}",
        <%--sex:"${user.sex}"--%>
    }
</script>
<script type="text/javascript" src="/js/rewardPunish/saveUpdatePage.js"></script>
</body>
</html>
