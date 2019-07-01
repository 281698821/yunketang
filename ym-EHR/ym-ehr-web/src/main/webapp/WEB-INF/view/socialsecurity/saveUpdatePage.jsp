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


<body>
	<div class="hp-open-list">
		<form id="hp-form" class="layui-form ">

			<div class="layui-form-item">
				<label class="layui-form-label">社保比率:</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input type="number" name="purchaserate" lay-verify="required"
						value="${socialsecurity.purchaserate}" autocomplete="off" placeholder="请添加新福利"
						class="layui-input">
				</div>
			</div>

			<button class="layui-btn layui-btn-small bcql-icon icon-save"
				lay-submit lay-filter="save" style="display: none;"></button>
			<!-- 隐藏域 -->
			<input name="id" type="hidden" value="${socialsecurity.id}" />


		</form>
	</div>
	<script>
        // 初始化数据
		var data={
		    id:"${socialsecurity.id}",
            purchaserate:"${socialsecurity.purchaserate}"
		}
	</script>
	<script type="text/javascript" src="/js/socialsecurity/saveUpdatePage.js"></script>



</body>

</html>