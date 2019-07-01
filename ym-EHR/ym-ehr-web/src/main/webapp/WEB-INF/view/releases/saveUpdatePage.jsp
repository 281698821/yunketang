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
		<%--这张表单是添加修改操作弹出的表单--%>
		<form id="hp-form" class="layui-form ">

			<div class="layui-form-item">
				<label class="layui-form-label">技能要求:</label>
				<div class="layui-input-inline" style="width: 200px;">
					<%--这里的name是把输入框的值赋值给对象的字段--%>
					<input type="text" name="skillsrequired" lay-verify="required"
						   <%--这里的value是用于编辑的时候回显--%>
						   value="${releases.skillsrequired}" autocomplete="off" placeholder="技能要求"
						   class="layui-input">
				</div>
			</div>

			<div class="layui-form-item">
				<label class="layui-form-label">招聘人数:</label>
				<div class="layui-input-inline" style="width: 200px;">
					<input type="text" name="hiring" lay-verify="number"
						   value="${releases.hiring}" autocomplete="off" placeholder="招聘人数" class="layui-input">
				</div>
			</div>

			<div class="layui-form-item">
				<label class="layui-form-label">薪资预算:</label>
				<div class="layui-input-inline" style="width: 200px;">
					<input type="text" name="wagebudget" lay-verify="number"
						   value="${releases.wagebudget}" autocomplete="off" placeholder="薪资预算" class="layui-input">
				</div>
			</div>

			<div class="layui-form-item">
				<label class="layui-form-label">发起时间:</label>
				<div class="layui-input-inline" style="width: 200px;">
					<input type="text" name="initiatetime" id="date"
						   value='<fmt:formatDate pattern="yyyy-MM-dd" value="${releases.initiatetime}"/>'
						   lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
				</div>
			</div>

			<div class="layui-form-item"  hidden="hidden">
				<label class="layui-form-label">状态:</label>
				<input type="radio" name="state" value="${releases.state}" checked="">
			</div>

			<div class="layui-form-item">
				<label class="layui-form-label">备注</label>
				<div class="layui-input-block" style="width: 200px;">
					<%--文本域的备注信息，回显写在文本域标签里面写值--%>
					<textarea placeholder="请输入备注信息"  name="mark" class="layui-textarea">${releases.mark}</textarea>
				</div>
			</div>

			<div class="layui-form-item">
				<label class="layui-form-label">发布人:</label>
				<div class="layui-input-inline" style="width: 200px;">
						<select id="empId" name="empId">
							<option value="" <c:if test="${releases.id==null}">selected="selected"</c:if>>--请选择--</option>
							<c:forEach items="${emps}" var="emp">
								<option value="${emp.id}" <c:if test="${releases.empId == emp.id}">selected</c:if>>${emp.name}</option>
							</c:forEach>
						</select
				</div>
			</div>


			<div class="layui-form-item">
				<label class="layui-form-label">渠道:</label>
				<div class="layui-input-inline" style="width: 200px;">
						<%--这里做回显操作的时候需要做判断--%>
						<select id="channelId" name="channelId">
							<option value="" <c:if test="${releases.id==null}">selected="selected"</c:if>>--请选择--</option>
							<c:forEach items="${channels}" var="channel">
								<option value="${channel.id}" <c:if test="${releases.channelId==channel.id}">selected</c:if>>${channel.name}</option>
							</c:forEach>
						</select>
				</div>
			</div>

			<div class="layui-form-item" hidden="hidden">
				<label class="layui-form-label">逻辑删除:</label>
					<input type="radio" name="logictodelete" value="${releases.logictodelete}" checked="">
			</div>

			<%--隐藏不显示在页面上的提交按钮--%>
			<button class="layui-btn layui-btn-small bcql-icon icon-save"
				lay-submit lay-filter="save" style="display: none;"></button>

			<!-- 隐藏域，回显操作的时候 -->
			<input name="id" type="hidden" value="${releases.id}" />
		</form>
	</div>
	<script>
        // 初始化数据
		var data={
		    id:"${releases.id}"
        }
	</script>
	<script type="text/javascript" src="/js/releases/saveUpdatePage.js"></script>
</body>

</html>