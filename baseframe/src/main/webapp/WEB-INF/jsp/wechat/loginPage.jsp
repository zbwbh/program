<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
	<%@include file="/common/head.jsp" %>
	<title>登录</title>
	<style>
		html,
		body {
			height: 100%;
			overflow: hidden;
		}
		.mui-bar {
			-webkit-box-shadow: none;
			box-shadow: none;
		}
		#done.mui-disabled{
			color: gray;
		}
		.rfq-icon-position{
			position: absolute; 
			z-index: 1;
    		top: 10px; 
    		right: 0;
    		width: 38px; 
    		height: 38px;
    		text-align: center;
    		color: #999;
    	}
		
	</style>

</head>

<body>
	<header class="mui-bar mui-bar-nav">
		<h1 class="mui-title">登录</h1>
	</header>
	<div class="mui-content">
		<form id='login-form' class="mui-input-group">
			<div class="mui-input-row">
				<label>账号</label>
				<input id='account' type="text" class="mui-input-clear" placeholder="请输入账号" >
			</div>
			<div class="mui-input-row">
				<label>密码</label>
				<input id='password' type="password" class="mui-input-password" placeholder="请输入密码" >
			</div>
		</form>
		<div class="mui-content-padded">
			<button id='login' class="mui-btn mui-btn-block mui-btn-primary">登录</button>
		</div>
		<div class="link-area animated fadeIn" ><a id='reg'>注册账号</a><a id='forgetPassword' style="float: right;">忘记密码?</a>
	</div>
	
</body>
	<script type="text/javascript">
		var ctx = '${ctx}';
		mui.init();
		document.getElementById('reg').addEventListener('tap',function(){
			mui.openWindow({
				url:ctx + '/wechat/toRegisterPage',
				id:'register'
			})
		});
		
		document.getElementById('forgetPassword').addEventListener('tap',function(){
			mui.openWindow({
				url:ctx+'/wechat/toForgetPassword',
				id:'forget'
			})
		});
	</script>
</html>