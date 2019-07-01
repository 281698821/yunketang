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
				<label class="layui-form-label">姓名:</label>
				<div class="layui-input-inline" style="width: 200px;">
					<input type="text" name="name" lay-verify="required"
						value="${talentpool.name}" autocomplete="off" placeholder="请输入姓名"
						class="layui-input">
				</div>

			<div class="layui-form-item">
				<label class="layui-form-label">性别:</label>
				<div class="layui-input-inline" style="width: 200px;">
					<input type="radio" name="sex" value="1" title="男"
						   checked="checked"> <input type="radio" name="sex" value="0" title="女">
				</div>
			</div>

			<div class="layui-form-item">
				<label class="layui-form-label">电话:</label>
				<div class="layui-input-inline" style="width: 200px;">
					<input type="text" name="phone" lay-verify="phone"
						   value="${talentpool.phone}" autocomplete="off" placeholder="请输入电话"
						   class="layui-input">
				</div>
			</div>

			<div class="layui-form-item">
				<label class="layui-form-label">QQ:</label>
				<div class="layui-input-inline" style="width: 200px;">
					<input type="text" name="qq" lay-verify="number"
						   value="${talentpool.qq}" autocomplete="off" placeholder="请输入QQ" class="layui-input">
				</div>
			</div>

			<div class="layui-form-item">
				<label class="layui-form-label">邮箱:</label>
				<div class="layui-input-inline" style="width: 200px;">
					<input type="text" name="email" lay-verify="email"
						   value="${talentpool.email}" autocomplete="off" placeholder="请输入邮箱地址"
						   class="layui-input">
				</div>
			</div>

			<div class="layui-form-item">
				<label class="layui-form-label">年龄:</label>
				<div class="layui-input-inline" style="width: 200px;">
					<input type="text" name="age" lay-verify="number"
						   value="${talentpool.age}" autocomplete="off" placeholder="请输入年龄"
						   class="layui-input">
				</div>
			</div>

			<%--省级地址--%>
			<div class="layui-form-item">
				<label class="layui-form-label">现住址:</label>
				<div class="layui-input-inline" style="width: 200px;">
					<input type="text" name="currentaddress" lay-verify="required"
						   value="${talentpool.currentaddress}" autocomplete="off" placeholder="请输入..."
						   class="layui-input">
				</div>
			</div>

			<div class="layui-form-item layui-form-text">
				<label class="layui-form-label">技术特长:</label>
				<div class="layui-input-inline" style="width: 200px;">
					<input type="text" name="specialty" lay-verify="required"
						   value="${talentpool.specialty}" autocomplete="off" placeholder="请输入..."
						   class="layui-input">
				</div>
			</div>

			<div class="layui-form-item layui-form-text">
				<label class="layui-form-label">圈内评价:</label>
				<div class="layui-input-inline" style="width: 200px;">
					<input type="text" name="comments"
						   value="${talentpool.comments}" autocomplete="off" placeholder="请输入..."
						   class="layui-input">
				</div>
			</div>

			<div class="layui-form-item layui-form-text">
				<label class="layui-form-label">现所在公司:</label>
				<div class="layui-input-inline" style="width: 200px;">
					<input type="text" name="asthecompany"
						   value="${talentpool.asthecompany}" autocomplete="off" placeholder="请输入..."
						   class="layui-input">
				</div>
			</div>

			<div class="layui-form-item layui-form-text">
				<label class="layui-form-label">备注:</label>
					<div class="layui-input-block" style="width: 200px;">
					<%--文本域的备注信息，回显写在文本域标签里面写值--%>
					<textarea placeholder="请输入备注信息"  name="mark" class="layui-textarea">${talentpool.mark}</textarea>
				</div>
			</div>

			<button class="layui-btn layui-btn-small bcql-icon icon-save"
				lay-submit lay-filter="save" style="display: none;"></button>

			<!-- 隐藏域，回显操作的时候 -->
			<input name="id" type="hidden" value="${talentpool.id}" />
		</form>
	</div>
	<script>
        // 初始化数据
		var data={
		    id:"${talentpool.id}"
		}
	</script>
	<script type="text/javascript" src="/js/talentpool/saveUpdatePage.js"></script>
</body>

</html>