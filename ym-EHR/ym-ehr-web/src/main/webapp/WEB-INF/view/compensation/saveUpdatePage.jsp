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
            <form id="hp-form" class="layui-form" onsubmit="return false">
                <div class="layui-form-item">
                    <label class="layui-form-label">员工名:</label>
                    <div class="layui-input-inline">
                        <input id="name" type="text"  value="${compensation.emp.name}"   placeholder="请输入员工名" class="layui-input">
                    </div>
                    <c:if test="${compensation.id==null}">
                    <div class="" style="margin-left: -8px;">
                        <button  type="button" id="listBtn2" class="layui-btn layui-btn-normal">单选选择</button>
                    </div>
                    </c:if>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">基本工资:</label>
                    <div class="layui-input-inline">
                        <input id="paygrades" type="text" name="basicsalary" value="${compensation.basicsalary}" <c:if test="${compensation.id!=null}">readonly="readonly"</c:if> lay-verify="required" placeholder="请输入基本工资" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">补贴:</label>
                    <div class="layui-input-inline">
                        <input id="subsidies" type="text" name="subsidies" value="${compensation.subsidies}" lay-verify="required" placeholder="请输入总金额" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">社保率：</label>
                    <div class="layui-input-block" >
                        <select id="socialsecurityId" name="socialsecurityId">
                            <option value="" <c:if test="${compensation.id==null}">selected="selected"</c:if>>--请选择--</option>
                            <c:forEach items="${socialsecurities}"  var="socialsecurity">
                                <option value="${socialsecurity.id}" <c:if test="${compensation.socialsecurityId==socialsecurity.id}">selected="selected"</c:if>>${socialsecurity.purchaserate}%</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <button class="layui-btn layui-btn-small bcql-icon icon-save"
                        lay-submit lay-filter="save" style="display: none;"></button>
			<!-- 隐藏域 -->
			<input name="id" type="hidden" value="${compensation.id}" />
             <input id="empId" name="empId" type="hidden" />
		</form>
	</div>
	<script>
        layui.use([ 'form' ], function() {
            var form = layui.form;

            form.render();
        });
        // 初始化数据
		var data={
		    id:"${compensation.id}",
            socialsecurity:"${compensation.socialsecurity}",
		};
	</script>
	<script type="text/javascript" src="/js/compensation/saveUpdatePage.js"></script>
</body>

</html>