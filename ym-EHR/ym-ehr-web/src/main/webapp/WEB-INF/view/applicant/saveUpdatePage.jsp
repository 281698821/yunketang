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

        <div class="layui-form-item">
            <label class="layui-form-label">名字:</label>
            <div class="layui-input-block">
                <input type="text" name="name" value="${applicant.name}" lay-verify="required" autocomplete="off" placeholder="请输入姓名" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item" pane="">
            <label class="layui-form-label">性别:</label>
            <div class="layui-input-block">
                <input type="radio" name="sex" value="1" title="男" checked="">
                <input type="radio" name="sex" value="0" title="女">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">QQ:</label>
            <div class="layui-input-block">
                <input type="text" name="qq" lay-verify="number"
                       value="${applicant.qq}" autocomplete="off" placeholder="请输入QQ"
                       class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">电话:</label>
            <div class="layui-input-block">
                <input type="text" name="phone" lay-verify="phone"
                       value="${applicant.phone}" autocomplete="off" placeholder="请输入电话"
                       class="layui-input">
            </div>
        </div>



        <div class="layui-form-item">
            <label class="layui-form-label">邮箱:</label>
            <div class="layui-input-block">
                <input type="text" name="email" lay-verify="email"
                       value="${applicant.email}" autocomplete="off" placeholder="请输入邮箱地址"
                       class="layui-input">
            </div>
        </div>

        
        
        <div class="layui-form-item">
            <label class="layui-form-label">年龄:</label>
            <div class="layui-input-block">
                <input type="text" name="age" lay-verify="number"
                       value="${applicant.age}" autocomplete="off" placeholder="请输入年龄"
                       class="layui-input">
            </div>
        </div>
        
        
        <div class="layui-form-item">
            <label class="layui-form-label">应聘时间:</label>
            <div class="layui-input-block">
                <input type="text" name="applicanttime" id="date"
                       value='<fmt:formatDate pattern="yyyy-MM-dd" value="${applicant.applicanttime}"/>'
                       lay-verify="date" placeholder="请选择年-月-日" autocomplete="off"
                       class="layui-input">
            </div>
        </div>

        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">现住址:</label>
            <div class="layui-input-block">
                <textarea placeholder="例如:所在地区+街道+小区/门牌号/楼栋号" required lay-verify="required" class="layui-textarea" name="currentaddress">${applicant.currentaddress}</textarea>
            </div>
        </div>

        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">技术特长:</label>
            <div class="layui-input-block">
                <textarea placeholder="例如:java/php/C#..." required lay-verify="required"  class="layui-textarea" name="specialty">${applicant.specialty}</textarea>
            </div>
        </div>

        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">面试官评价:</label>
            <div class="layui-input-block">
                <textarea placeholder="请输入..." required lay-verify="required" class="layui-textarea" name="comments">${applicant.comments}</textarea>
            </div>
        </div>


        <div class="layui-form-item">
            <label class="layui-form-label">备注</label>
            <div class="layui-input-block">
                <select name="mark" lay-filter="aihao">
                    <option value="最佳">最佳</option>
                    <option value="实力坑">实力坑</option>
                    <option value="厉害了">惹不起</option>
                    <option value="合格" selected>合格</option>
                </select>
            </div>
        </div>


        <button class="layui-btn layui-btn-small bcql-icon icon-save"
                lay-submit lay-filter="save" style="display: none;"></button>


        <!-- 隐藏域 -->
        <input name="id" type="hidden" value="${applicant.id}"/>


    </form>
</div>
<script>
    // 初始化数据
    var data = {
        id: "${applicant.id}",
        sex: "${applicant.sex}"
    }
</script>
<script type="text/javascript" src="/js/applicant/saveUpdatePage.js"></script>
</body>

</html>