<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title></title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<link rel="stylesheet" href="//res.layui.com/lay/v1/build/css/layui.css"  media="all">
	<!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>


<body>
	<div class="hp-open-list">
		<form id="hp-form" class="layui-form ">

			<div class="layui-form-item">
				<label class="layui-form-label">活动主题:</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input type="text" name="theme" lay-verify="required"
						value="${activity.theme}" autocomplete="off" placeholder="请输入活动主题"
						class="layui-input">
				</div>
			</div>



			<div class="layui-form-item">
				<label class="layui-form-label">活动地址:</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input type="text" name="activityaddress" lay-verify="required"
						value="${activity.activityaddress}" autocomplete="off" placeholder="请输入活动地址 "
						class="layui-input">
				</div>
			</div>


			<div class="layui-form-item">
				<label class="layui-form-label">活动简介:</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input type="text" name="introduce" lay-verify="required"
						   value="${activity.introduce}" autocomplete="off" placeholder="请输入活动简介 "
						   class="layui-input">
				</div>
			</div>

			<div class="layui-form-item">
				<label class="layui-form-label">活动时间:</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input type="text" name="initatetime" id="date"
						   value='<fmt:formatDate pattern="yyyy-MM-dd" value="${activity.initatetime}"/>'
						   lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off"
						   class="layui-input">
				</div>
			</div>

			<div class="layui-form-item">
				<label class="layui-form-label">活动消费:</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input type="text" name="spending" lay-verify="required"
						   value="${activity.spending}" autocomplete="off" placeholder=""
						   class="layui-input">
				</div>
			</div>

			<div class="layui-form-item">
				<label class="layui-form-label">组织人:</label>
				<div class="layui-input-inline">
					<input id="empName" type="text" name="empName" value="${activity.emp.name}" lay-verify="title" autocomplete="off" placeholder="请输入用户名" class="layui-input">
				</div>
				<div class="" style="margin-left: -8px;">
					<button type="button" id="listBtn" class="layui-btn layui-btn-normal">选择组织人</button>
				</div>
			</div>


			<div class="layui-form-item">
				<label class="layui-form-label">活动状态:</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input type="radio" name="state" value="1" title="通过"
						checked="checked"> <input type="radio" name="state"
						value="0" title="不通过">
				</div>
			</div>



			<div class="layui-form-item">
				<label class="layui-form-label">活动详情:</label>
				<div class="layui-input-inline" style="width: 250px;">
					<textarea class="layui-textarea layui-hide" name="activitythedetail" lay-verify="content" id="LAY_demo1">
						${activity.activitythedetail}
					</textarea>
				</div>
			</div>

			<!-- 隐藏域 -->
			<input name="id" type="hidden" value="${activity.id}" />
			<input id="empId" name="empId" type="hidden"  />



			<button class="layui-btn layui-btn-small bcql-icon icon-save"
				lay-submit lay-filter="save" style="display: none;"></button>




		</form>
	</div>
	<script>
        // 初始化数据
		var data={
		    id:"${activity.id}",
            sex:"${activity.state}"
		}
	</script>
	<script type="text/javascript" src="/js/activity/saveUpdatePage.js"></script>
</body>

</html>