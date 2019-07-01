<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>

<style>

</style>

<body>
	<div class="hp-open-list">
		<form id="hp-form" class="layui-form ">

			<div class="layui-form-item">
				<label class="layui-form-label">部门名称:</label>
				<div class="layui-input-inline" style="width: 200px;">
					<input type="text" name="name" lay-verify="required"
						value="${dept.name}" autocomplete="off" placeholder="输入部门名称"
						class="layui-input">
				</div>
			</div>

			<div class="layui-form-item">
				<label class="layui-form-label">公司名称:</label>

				<div class="layui-input-inline" style="width: 200px;">
					<select name="companyName"  lay-verify="" onselect="">
						<option value="">请输入公司名称</option>
						<c:forEach items="${companies}" var="company">
						<option value="${company.name}" <c:if test="${dept.company.name==company.name}">selected="selected"</c:if> >${company.name}</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="layui-form-item">
				<label class="layui-form-label">部门描述:</label>
				<div class="layui-input-inline" style="width: 150px;">
					<div class="layui-input-inline" style="width: 200px;">
						<textarea name="mark" id="mark" placeholder="请输入部门描述" class="layui-textarea">${dept.mark}</textarea>
					</div>
				</div>
			</div>

			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" id="saveForm" lay-submit lay-filter="saveForm">立即提交</button>
					<button type="reset" id="reset" class="layui-btn layui-btn-primary">重置</button>
				</div>
			</div>
		<%--	<button class="layui-btn layui-btn-small bcql-icon icon-save"
				lay-submit lay-filter="save" style="display: none;"></button>--%>


			<!-- 隐藏域 -->
			<input name="id" type="hidden" value="${dept.id}" />


		</form>
	</div>
	<script>
        // 初始化数据
        layui.use(['form', 'laydate', 'upload', 'layer', 'layedit'], function () {
            var form = layui.form;
            var layer = layui.layer;
            var $ = layui.$;
            //重载表单
            $(document).on('click','#reset',function () {
                $("#hp-form")[0].reset();
            });
            form.on('submit(saveForm)', function (data) {
                $.ajax({
                    type: "POST",
                    url: "/deptController/saveUpdate",
                    async: false,
                    data: data.field,
                    success: function(msg){
                        layer.msg( "数据保存" + msg.msg);
                    }
                });
                return true;
            });
            form.render();
        });
        // 初始化数据
		var data={
		    id:"${user.id}",
		}
	</script>

	<%--<script type="text/javascript" src="/js/dept/saveUpdatePage.js"></script>--%>



</body>

</html>