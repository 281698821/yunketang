<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>   
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>异常</h1>
 
<div>

<p>timestamp(时间):<f:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${timestamp}" /></p>
<p>
status(状态码):
<!-- <span th:text="${status==500?'500':'404'}"></span> -->
<span >${status}</span>
</p>
<p>error:${error}</p>
<p>温馨提示:
${status==500?'后台代码有误':''}
${status==400?'传入的参数有误':''}
${status==404?'找不到页面':''}
</p>

</div>
</body>
</html>