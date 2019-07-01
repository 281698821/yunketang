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
				<label class="layui-form-label">节日名称:</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input type="text" name="name" lay-verify="required"
						value="${holiday.name}" autocomplete="off" placeholder="请输入节日名称"
						class="layui-input">
				</div>
			</div>



			<div class="layui-form-item">
				<label class="layui-form-label">日期:</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input type="text" name="time" id="date"
						value='<fmt:formatDate pattern="yyyy-MM-dd" value="${holiday.time}"/>'
						lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off"
						class="layui-input">
				</div>
			</div>

			<div class="layui-form-item">
				<label class="layui-form-label">节日祝福语:</label>
				<div class="layui-input-inline" style="width: 150px;">
					<textarea name="content" placeholder="请输入内容" class="layui-textarea">${holiday.content}</textarea>
				</div>
			</div>


			<button class="layui-btn layui-btn-small bcql-icon icon-save"
				lay-submit lay-filter="save" style="display: none;"></button>


			<!-- 隐藏域 -->
			<input name="id" type="hidden" value="${holiday.id}" />


		</form>
	</div>
	<script>
        // 初始化数据
		var data={
		    id:"${holiday.id}",
		}
	</script>
	<script type="text/javascript" src="/js/holiday/saveUpdatePage.js"></script>



</body>

</html>