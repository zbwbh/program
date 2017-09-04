<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>品牌列表页</title>
		<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		<link rel="stylesheet" href="${ctx}/static/mui_3.2.0/css/mui.min.css" />
		<script src="${ctx}/static/mui_3.2.0/js/mui.min.js"></script>
		<script src="${ctx}/static/js/jquery_1.9.1.min.js"></script>
	</head>

	<body>
		<header class="mui-bar mui-bar-nav">
		    <a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
		    <h1 class="mui-title">品牌列表</h1>
		</header>
		<div class="mui-content">
			<div id='list' class="mui-indexed-list">
				<div class="mui-indexed-list-alert"></div>
				<div class="mui-indexed-list-inner">
					<ul class="mui-table-view brandlist">
						<!--<li data-group="A" class="mui-table-view-divider mui-indexed-list-group">A</li>
						<li data-value="AKU" data-tags="AKeSu" class="mui-table-view-cell mui-indexed-list-item">阿克苏机场</li>-->
					</ul>
				</div>
			</div>
		</div>
	</body>
	<script>
		var ctx = '${ctx}';
		mui.init({
			swipeBack:true //启用右滑关闭功能
		});
		// show the list of car brand,use Ajax of the get request
		mui.ajax(ctx+'/frame/brand/getBrandList',{
			type:'get',
			dataType:'json',
			timeout:10000,
			success:function(data){
				// there is no problem of the json data
				// use an array to group the brand according to the first letter
				var html='';
				for (var key in data) {
					html+='<li data-group="'+key+'" class="mui-table-view-divider mui-indexed-list-group">'+key+'</li>';
					var sunlist = data[key];
					for (var i = 0; i < sunlist.length; i++) {
						html+='<li data-value="" data-tags="" class="mui-table-view-cell mui-indexed-list-item">'+sunlist[i].carBrandName+'</li>';
					}
				}
				$(".brandlist").html(html);
			},
			error:function(e){
				console.log(e);
			}
		});
	</script>
</html>