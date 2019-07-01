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
				<label class="layui-form-label">等级名称:</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input type="text" name="name" lay-verify="required"
						value="${paygrades.name}" autocomplete="off" placeholder="请输入名称"
						class="layui-input">
				</div>
			</div>



			<div class="layui-form-item">
				<label class="layui-form-label">对应工资:</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input type="number" name="salary" lay-verify="required"
						value="${paygrades.salary}" autocomplete="off" placeholder="请输入对应工资"
						class="layui-input">
				</div>
			</div>


			<div class="layui-form-item">
				<label class="layui-form-label">备注:</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input type="text" name="mark" lay-verify="required"
						value="${paygrades.mark}" autocomplete="off" placeholder="请输入备注"
						class="layui-input">
				</div>
			</div>






			<button class="layui-btn layui-btn-small bcql-icon icon-save"
				lay-submit lay-filter="save" style="display: none;"></button>


			<!-- 隐藏域 -->
			<input name="id" type="hidden" value="${paygrades.id}" />


		</form>
	</div>
	<script>
        /*// 初始化数据
		var data={
		    id:"${paygrades.id}",
            sex:"${user.sex}"
		}*/
	</script>
	<script type="text/javascript" src="/js/paygrades/saveUpdatePage.js"></script>



</body>

</html>