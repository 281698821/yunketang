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

			<div class="layui-inline hp-form-inline">
				<label class="layui-form-label hp-form-label">处理：</label>
				<div class="layui-input-inline" style="width: 150px;">
					<select name="tag" value="${attendance.tag}" lay-verify="">
						<option value="">请选择</option>
						<option value="3">旷工</option>
						<option value="2">迟到</option>
					</select>
				</div>
			</div>

			<button class="layui-btn layui-btn-small bcql-icon icon-save"
				lay-submit lay-filter="save" style="display: none;"></button>

			<!-- 隐藏域 -->
			<input name="id" type="hidden" value="${attendance.id}" />


		</form>
	</div>
	<script>
        // 初始化数据
		var data={
		    id:"${attendance.id}",
		}
	</script>
	<script type="text/javascript" src="/js/attendance/saveUpdatePage.js"></script>



</body>

</html>