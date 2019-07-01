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
				<label class="layui-form-label">头像:</label>
				<div class="layui-input-inline" style="width: 150px;">

					<c:if test="${user.id!=null}">
						<input  id="hiddenImg"  name="headImg" type="hidden" value="${user.headImg}" />
						<c:if test="${user.headImg!=''}">
						<img id="kdImg" class="layui-circle hp-img"
						src="/${user.headImg}" />						
						</c:if>
						<c:if test="${user.headImg==''}">
						<img id="kdImg" class="layui-circle hp-img"
						src="/img/1.jpg" />						
						</c:if>

					</c:if>
					<c:if test="${user.id==null}">
						<input id="hiddenImg" name="headImg" type="hidden"  />
						<img id="kdImg" class="layui-circle hp-img"
						src="/img/1.jpg" />
					</c:if>


					<button type="button" class="layui-btn layui-btn-normal"
						id="kdUpload">
						<i class="layui-icon">&#xe67c;</i>上传图片
					</button>




				</div>
			</div>

			<div class="layui-form-item">
				<label class="layui-form-label">账号:</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input type="text" name="loginName" lay-verify="required"
						value="${user.loginName}" autocomplete="off" placeholder="请输入账号"
						class="layui-input">
				</div>
			</div>



			<div class="layui-form-item">
				<label class="layui-form-label">密码:</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input type="password" name="loginPwd" lay-verify="required"
						value="${user.loginPwd}" autocomplete="off" placeholder="请输入密码"
						class="layui-input">
				</div>
			</div>

			<div class="layui-form-item">
				<label class="layui-form-label">用户昵称:</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input type="text" name="userName" lay-verify="required"
						value="${user.userName}" autocomplete="off" placeholder="请输入用户昵称"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">性别:</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input type="radio" name="sex" value="1" title="男"
						checked="checked"> <input type="radio" name="sex"
						value="0" title="女">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">生日:</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input type="text" name="birthday" id="date"
						value='<fmt:formatDate pattern="yyyy-MM-dd" value="${user.birthday}"/>'
						lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off"
						class="layui-input">
				</div>
			</div>


			<button class="layui-btn layui-btn-small bcql-icon icon-save"
				lay-submit lay-filter="save" style="display: none;"></button>


			<!-- 隐藏域 -->
			<input name="id" type="hidden" value="${user.id}" />


		</form>
	</div>
	<script>
        // 初始化数据
		var data={
		    id:"${user.id}",
            sex:"${user.sex}"
		}
	</script>
	<script type="text/javascript" src="/js/user/saveUpdatePage.js"></script>



</body>

</html>