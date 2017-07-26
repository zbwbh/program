<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript" src="${ctx}/static/js/jquery_1.9.1.min.js"></script>
	
<!doctype html>
<html>
<head>
	<link href="${ctx}/static/mui_3.2.0/css/mui.min.css" media="screen" rel="stylesheet" type="text/css" />
	<link href="${ctx}/static/mui_3.2.0/css/mui.indexedlist.css" rel="stylesheet" />
	<link href="${ctx}/static/mui_3.2.0/css/common.css" rel="stylesheet" />
	<link href="${ctx}/static/mui_3.2.0/css/mui.picker.min.css" rel="stylesheet" >
	<link href="${ctx}/static/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet">
	<script src="${ctx}/static/mui_3.2.0/js/mui.js" type="text/javascript"></script>
	<script src="${ctx}/static/mui_3.2.0/js/mui.indexedlist.js" type="text/javascript"></script>
	<script src="${ctx}/static/mui_3.2.0/js/mui.pullToRefresh.js"></script>
	<script src="${ctx}/static/mui_3.2.0/js/mui.pullToRefresh.material.js"></script>
	<script src="${ctx}/static/mui_3.2.0/js/mui.picker.min.js"></script>
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
	
	</div>
	
	
</body>
	<script type="text/javascript">
		var regions = '${region}';
		console.log(regions);
	</script>
</html>