<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

	<head>
		<title>excel练习</title>
		<%@include file="/common/head.jsp"%>
	</head>

	<body>
		<header class="mui-bar mui-bar-nav">
			<h1 class="mui-title">excel练习模板</h1>
		</header>
	</br></br></br></br></br></br>
		<div class="mui-content">
			<button type="button" id="export" class="mui-btn mui-btn-primary mui-btn-block">excel模板</button>
			<br>
		</div>
		<script type="text/javascript">
			mui.init({
				swipeBack: false,
			});
			
   			document.getElementById('export').addEventListener('tap',function(){
				mui.ajax(ctx+"/poi/excel/download",{
   					dataType:'json',//服务器返回json格式数据
					type:'post',//HTTP请求类型
					timeout:90000,//超时时间设置为10秒；      
					success:function(data){
						console.log(data);
						if(data){
							mui.openWindow({
								url:data,
								id:'u'
							});
						}else{
							mui.alert("下载失败,请重试或联系管理员")
						}
					},
					error:function(xhr,type,errorThrown){
						mui.alert("系统异常");
					}
   				})
			})
		</script>
		
	</body>

</html>