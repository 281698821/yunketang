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
				<label class="layui-form-label">账号:</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input type="text" name="rulesname" lay-verify="required"
						value="${rule.rulesname}" autocomplete="off" placeholder="规则名称"
						class="layui-input">
				</div>
			</div>



			<div class="layui-form-item">
				<label class="layui-form-label">打卡次数:</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input type="number" name="clockinnum" lay-verify="required"
						value="${rule.clockinnum}" autocomplete="off" placeholder="4"
						class="layui-input">
				</div>
			</div>


			<div class="layui-form-item">
				<label class="layui-form-label">上午上班打卡时间:</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input id="amstartdate" type="text" name="amstarttime" lay-verify="required"
						value="${rule.amstarttime}" autocomplete="off" placeholder="上午上班时间"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">上午下班打卡时间:</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input id="amenddate" type="text" name="amendtime" lay-verify="required"
						   value="${rule.amendtime}" autocomplete="off" placeholder="上午下班打卡时间"
						   class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">下午上班打卡时间:</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input id="pmstartdate" type="text" name="pmstarttime" lay-verify="required"
						value="${rule.pmstarttime}" autocomplete="off" placeholder="下午上班打卡时间"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">下午下班打卡时间:</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input id="pmenddate" type="text" name="pmendtime" lay-verify="required"
						   value="${rule.pmendtime}" autocomplete="off" placeholder="下午下班打卡时间"
						   class="layui-input">
				</div>
			</div>

			<div class="layui-form-item">
				<label class="layui-form-label">打卡位置:</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input  type="text" name="clockiniocation" lay-verify="required"
						   value="${rule.clockiniocation}" autocomplete="off" placeholder="打卡位置"
						   class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">备注:</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input  type="text" name="instructions" lay-verify="required"
							value="${rule.instructions}" autocomplete="off" placeholder="备注"
							class="layui-input">
				</div>
			</div>

			<button class="layui-btn layui-btn-small bcql-icon icon-save"
				lay-submit lay-filter="save" style="display: none;"></button>

			<!-- 隐藏域 -->
			<input name="id" type="hidden" value="${rule.id}" />


		</form>
	</div>
	<script>
        // 初始化数据
		var data={
		    id:"${rule.id}",
		}
	</script>
	<script type="text/javascript" src="/js/rule/saveUpdatePage.js"></script>



</body>

</html>