<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>登录</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" href="/lib/layui/css/layui.css">
<link rel="stylesheet" type="text/css"
	href="/css/pageDemo/login/login.css" />
</head>

<body>
	<div class="qiqiu1 qiqiu">
		<img src="/img/login/login1/q2.png" />
		<div class="text">love</div>
	</div>
	<div class="qiqiu2 qiqiu">
		<img src="/img/login/login1/q3.png" />
		<div class="text">love</div>
	</div>
	<div class="qiqiu3 qiqiu">
		<img src="/img/login/login1/q4.png" />
		<div class="text">love</div>
	</div>
	<div class="qiqiu4 qiqiu">
		<img src="/img/login/login1/q5.png" />
		<div class="text">love</div>
	</div>
	<div class="qiqiu5 qiqiu">
		<img src="/img/login/login1/q6.png" />
		<div class="text">love</div>
	</div>
	



	<div class="login">
		<h1>隐世集团-EHR</h1>
		<form class="layui-form">
			<div class="layui-form-item">
				<input id="loginName" class="layui-input" name="id" placeholder="工号"
					lay-verify="required" type="text" autocomplete="off">
			</div>

			<div class="layui-form-item">
				<input id="loginPwd" class="layui-input" name="password" placeholder="密码"
					lay-verify="required" type="password" autocomplete="off">
			</div>

			<button type="button" class="layui-btn login_btn" lay-submit="" lay-filter="login">登录</button>
		</form>
	</div>


<script src="/lib/layui/layui.js"></script>





<script>
	layui.use("layer",function(){
		var $=layui.jquery;
		var layer=layui.layer;
		// 登录判断
		$(".login_btn").click(function(){
			
			var id=$('#loginName').val();
			var password=$('#loginPwd').val();
			
			
			 $.ajax({
					url:"/login/loginCon",
					data:{"id":id,"password":password},
					type:'post',
					dataType:'json',
					success:function(json){
					 if(json.code==200){
						 layer.msg(json.msg);
						 console.log(json)
						 location.href='/index/index';
					 }else{
						 layer.msg(json.msg);
					 }
					 
					},
					error:function(){
						alert('服务器有误,请联系管理员!!!!')
					} 
				});
		});
	});
	

	

	
</script>


</body>
</html>
