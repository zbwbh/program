<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
	<%@include file="/common/head.jsp" %>
	<title>注册</title>
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
	<!--可能我写的这些以及js部分已经过时了，不过总该是要知道点啊-->
	<header class="mui-bar mui-bar-nav">
			<a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
			<h1 class="mui-title">注册</h1>
		</header>
	<div class="mui-content">
		<div class="mui-content-padded" style="margin: 5px;">
		<form id='regist-form' class="mui-input-group">
			<div class="mui-input-row">
				<label>账号</label>
				<input id='account' name="name" type="text" class="mui-input-clear require" placeholder="请输入账号" maxlength="30">
			</div>
			<div class="mui-input-row">
				<label>密码</label>
				<input id='password' name="password" type="password" class="mui-input-password require" placeholder="请输入密码" maxlength="30">
			</div>
			<div class="mui-input-row">
				<label>电话</label>
				<input id='tel' type="text" name="tel" class="mui-input require" placeholder="请输入电话" maxlength="11">
			</div>
			<div class="mui-input-row">
				<label>地址</label>
				<input id='showProvincePicker' type="text" class="mui-input require" value="" placeholder="省/市/区" readonly="">
				<input id="province" name="province" type="hidden" value=""/>
				<input id="provinceId" name="provinceId" type="hidden" value=""/>
				<input id='city' name="city" type="hidden" value="">
				<input id="cityId" name="cityId" type="hidden" value=""/>
				<input id='region' name="region" type="hidden" value="">
				<input id="regionId" name="regionId" type="hidden" value=""/>
			</div>
			<div class="mui-content-padded" style="margin: 5px;">
				<div class="mui-input-row">
					<textarea maxlength="100" style="margin-bottom:0px;"  name="remark" rows="3" placeholder="请输入备注" ></textarea>
				</div>
			</div>
		</form>
		</div>
		<div class="mui-content-padded">
			<button id='regist' class="mui-btn mui-btn-block mui-btn-primary">注册</button>
		</div>
	</div>
	
	
</body>
	<script type="text/javascript">
		var ctx = '${ctx}';
		var regions = ${regions};
		console.log(regions);
		(function($, doc) {
				$.init();
				$.ready(function() {
					var cityPicker = new $.PopPicker({
						layer: 3
					});
					cityPicker.setData(regions);
					var showProvincePickerDom = doc.getElementById('showProvincePicker');
					showProvincePickerDom.addEventListener('tap', function(event) {
						cityPicker.show(function(items) {
							doc.getElementById('showProvincePicker').value=items[0].text+'-'+items[1].text+'-'+items[2].text;
							doc.getElementById('province').value=items[0].text;
							doc.getElementById('provinceId').value=items[0].regionId;
							doc.getElementById('city').value=items[1].text;
							doc.getElementById('cityId').value=items[1].regionId;
							doc.getElementById('region').value=items[2].text;
							doc.getElementById('regionId').value=items[2].regionId;
						});
					}, false);
				});
				
				doc.getElementById('regist').addEventListener('tap',function(){
					var name = doc.getElementById('account').value;
					if(name==''){
						mui.alert('请输入账号');
						return ;
					}
//					$.ajax(ctx+'/wechat/checkName',{
//						data:{
//							newName:name
//						},
//						dataType:'json',//服务器返回json格式数据
//						type:'post',//HTTP请求类型
//						success:function(data){
//							console.log(data);
//							if(data=="1"){
//								
//							}else{
//								mui.alert("用户已存在请重新输入");
//							}
//						},
//						error:function(xhr,type,errorThrown){
//							mui.alert('发生异常，请稍后重试或联系管理员');
//						}
//					});
					var password = doc.getElementById('password').value;
					if(password==''){
						mui.alert('请输入密码');
						return;
					}
					var tel = doc.getElementById('tel').value;
					if(!/1[35784]\d{9}$/.test(tel)){
						mui.alert('请输入正确的电话号');
						return;
					}
					var region = doc.getElementById('showProvincePicker').value;
					if(region==''){
						mui.alert("请选择地址");
						return;
					}
					
					var params = jQuery("#regist-form").serialize();
					params = decodeURIComponent(params,true);
					$.ajax(ctx+'/wechat/formRegist',{
						data:params,
						dataType:'json',//服务器返回json格式数据
						type:'post',//HTTP请求类型
						success:function(data){
							if(data=="1"){
								mui.alert('注册成功',function(){
									window.location.href = ctx +'/wechat/toIndex'
								});
							}
						},
						error:function(xhr,type,errorThrown){
							mui.alert('发生异常，请稍后重试或联系管理员');
						}
					});
					
				});
				
			})(mui, document);
	</script>
</html>