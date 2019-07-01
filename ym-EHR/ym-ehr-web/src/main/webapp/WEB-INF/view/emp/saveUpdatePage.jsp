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


					<c:if test="${emp.id!=null}">
						<input  id="hiddenImg"  name="img" type="hidden" value="${emp.img}" />
						<c:if test="${emp.img!=''}">
						<img id="kdImg" class="layui-circle hp-img"
						src="${emp.img}" />
						</c:if>
						<c:if test="${emp.img==''}">
						<img id="kdImg" class="layui-circle hp-img"
						src="/img/1.jpg" />
						</c:if>

					</c:if>

					<c:if test="${emp.id==null}">
						<input id="hiddenImg" name="img" type="hidden"  />
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
				<label class="layui-form-label">名字:</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input type="text" name="name" lay-verify="required"
						value="${emp.name}" autocomplete="off" placeholder="请输入名字"
						class="layui-input">
				</div>
			</div>



			<div class="layui-form-item">
				<label class="layui-form-label">密码:</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input type="text" name="password" lay-verify="required"
						value="${emp.password}" autocomplete="off" placeholder="请输入密码"
						class="layui-input">
				</div>
			</div>


			<%--<div class="layui-form-item">
				<label class="layui-form-label">用户昵称:</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input type="text" name="userName" lay-verify="required"
						value="${emp.userName}" autocomplete="off" placeholder="请输入用户昵称"
						class="layui-input">
				</div>
			</div>
--%>


			<div class="layui-form-item">
				<label class="layui-form-label">性别:</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input type="radio" name="sex" value="男" title="男"
						checked="checked"> <input type="radio" name="sex"
						value="女" title="女">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">生日:</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input type="text" name="birthday" id="date"
						value='<fmt:formatDate pattern="yyyy-MM-dd" value="${emp.birthday}"/>'
						lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off"
						class="layui-input">
				</div>
			</div>

			<div class="layui-form-item">
				<label class="layui-form-label">部门:</label>
				<div class="layui-input-inline" style="width: 150px;">
                    <select name="deptId" lay-verify="" onselect="">
                        <option value="">请输入部门名称</option>
                        <c:forEach items="${deptList}" var="dept">
                            <option value="${dept.id}" <c:if test="${emp.dept.name==dept.name}">selected="selected"</c:if> >${dept.name}</option>
                        </c:forEach>
                    </select>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">职位:</label>
				<div class="layui-input-inline" style="width: 150px;">
                    <select name="positionId" lay-verify="" onselect="">
                        <option value="">请输入职位名称</option>
                        <c:forEach items="${positionList}" var="position">
                            <option value="${position.id}" <c:if test="${emp.position.name==position.name}">selected="selected"</c:if> >${position.name}</option>
                        </c:forEach>
                    </select>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">QQ:</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input type="text" name="qq" lay-verify="required"
						   value="${emp.qq}" autocomplete="off" placeholder="请输入QQ"
						   class="layui-input">
				</div>
			</div>

			<div class="layui-form-item">
				<label class="layui-form-label">邮箱:</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input type="text" name="email" lay-verify="required"
						   value="${emp.email}" autocomplete="off" placeholder="请输入邮箱"
						   class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">手机号:</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input type="text" name="phone" lay-verify="required"
						   value="${emp.phone}" autocomplete="off" placeholder="请输入手机号"
						   class="layui-input">
				</div>
			</div>


			<button class="layui-btn layui-btn-small bcql-icon icon-save"
				lay-submit lay-filter="save" style="display: none;"></button>


			<!-- 隐藏域 -->
			<input name="id" type="hidden" value="${emp.id}" />


		</form>
	</div>
	<script>
        // 初始化数据
		var data={
		    id:"${emp.id}",
            sex:"${emp.sex}"
		}
	</script>
	<script type="text/javascript" src="/js/emp/saveUpdatePage.js"></script>



</body>

</html>