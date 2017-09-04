<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<title>上传图片测试</title>
		<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1,user-scalable=no">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="apple-mobile-web-app-status-bar-style" content="black">
		<link rel="stylesheet" href="${ctx}/static/mui_3.2.0/css/mui.css">
		<script src="${ctx}/static/mui_3.2.0/js/mui.js"></script>
		<!-- I know localResizeIMG_plus.js is work, but whether the other based on this  -->
		<script src="${ctx}/static/js/localResizeIMG/lrz.all.bundle.js"></script>
		<script src="${ctx}/static/js/localResizeIMG_plus.js"></script>
		<script src="${ctx}/static/js/jquery_1.9.1.min.js"></script>
	</head>

	<body>
		<header class="mui-bar mui-bar-nav">
			<a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>
			<h1 class="mui-title">上传图片测试</h1>
		</header>
		<div class="mui-content">
			<div class="mui-content-padded" style="margin: 5px;">
				<form class="mui-input-group">
					<div class="mui-input-row">
						<label>姓名</label>
						<input type="text" placeholder="普通输入框">
					</div>
					<div class="mui-input-row">
						<label>地址</label>
						<input type="text" class="mui-input-clear" placeholder="带清除按钮的输入框">
					</div>
					<div class="mui-content-padded" style="margin: 5px;">
						<ul class="mui-table-view mui-grid-view mui-grid-9">
							<li class="mui-table-view-cell mui-media mui-col-xs-4 mui-col-sm-3">
								<label for="recPic">
									<img class="" name="1" id="test1" style="width:40px;" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACUAAAAhCAYAAABeD2IVAAACg0lEQVRYheWYMWjbQBSG/xgHHHChhnjwYEMDDaRDvbljRg8pJIOHDOmeDlkKWbpkCDSDBw8uyFBDCtKgQgMJxINGDSnE0EAzSJCAAzZEgwwpRCCBBe0JO6ll62xJjmRDP/AgvTv4/O7dk05zfwiYMaKAjqtjBly9DXPKKou5LbzfWEYEjRr4qQtZmGjXedQaRE9tNWE8BqKIx2Oh6xia1kuKgWZLtZbvgThy2x+xkQndCWge41OlDq13GfkXiSGxMAUhi4UE+tcnSh34ZHRwe86Dr8lokzWKxlJ4vb6F9WwC85QZEcr9J0MVK/h80hWyMA0FF9+KqIgqdU6wUvfn+C4ojiFFOMWvjvO0YKVaV2hRg9eQb5wjgS+fH4KVSi8jTQ2+xMoL54g/qY6O20YDKqUmHnn2BoV8yjGUyr9FlrL9fLSEJk5LFfz4bc1OIb+zg9UkfXRydRu7z09weHRhawkF0hJoeJTSIbFfu0IWpgKBYZHcfYdX1MY7j0S2gA/k5xZPy6eKVXCyYb9pyOCqIuhdxzuupXSJBUPpOaTpgGElksdhOvo99HG150tKFVHlZBgjhhgyh+pAl777eYiD/QPs75UxooH7kNIlsIwASo5sKEIZX87uyNOOPO/EMkpH170/Qmqv5F5sTKGrEKscBsuIjombWhF7NUdlF5uiy8hMqSIPWhn5wtoURRaSU/G5kRpZ2JPgYrc6S7ko7Ikgu7VcposNS3ko7EkwR7SRASmvhT0ZVhsp8cNifbvPwCXPQAk6RQNol6S/dVZsR7w+KS10oQcUWbZd/4cveT6ZTalkOoPwD+o0YsikkyRTS2vYzC2GcSodg/XVZRNrS8DcLH6f+gtALv4LQt5n4AAAAABJRU5ErkJggg==" >
									<div class="mui-media-body">
										<input style="display: none" type="file" accept="image/*" id="recPic" capture="camera" suffix="jpg,jpeg,png">测试图片
										<input id="test1Url" name="test1Url" type="hidden" value=""><!--this can save property which you want -->
									</div>
								</label>
							</li>
							<li class="mui-table-view-cell mui-media mui-col-xs-4 mui-col-sm-3">
								<label for="recPic1">
									<img class="" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACUAAAAhCAYAAABeD2IVAAACg0lEQVRYheWYMWjbQBSG/xgHHHChhnjwYEMDDaRDvbljRg8pJIOHDOmeDlkKWbpkCDSDBw8uyFBDCtKgQgMJxINGDSnE0EAzSJCAAzZEgwwpRCCBBe0JO6ll62xJjmRDP/AgvTv4/O7dk05zfwiYMaKAjqtjBly9DXPKKou5LbzfWEYEjRr4qQtZmGjXedQaRE9tNWE8BqKIx2Oh6xia1kuKgWZLtZbvgThy2x+xkQndCWge41OlDq13GfkXiSGxMAUhi4UE+tcnSh34ZHRwe86Dr8lokzWKxlJ4vb6F9WwC85QZEcr9J0MVK/h80hWyMA0FF9+KqIgqdU6wUvfn+C4ojiFFOMWvjvO0YKVaV2hRg9eQb5wjgS+fH4KVSi8jTQ2+xMoL54g/qY6O20YDKqUmHnn2BoV8yjGUyr9FlrL9fLSEJk5LFfz4bc1OIb+zg9UkfXRydRu7z09weHRhawkF0hJoeJTSIbFfu0IWpgKBYZHcfYdX1MY7j0S2gA/k5xZPy6eKVXCyYb9pyOCqIuhdxzuupXSJBUPpOaTpgGElksdhOvo99HG150tKFVHlZBgjhhgyh+pAl777eYiD/QPs75UxooH7kNIlsIwASo5sKEIZX87uyNOOPO/EMkpH170/Qmqv5F5sTKGrEKscBsuIjombWhF7NUdlF5uiy8hMqSIPWhn5wtoURRaSU/G5kRpZ2JPgYrc6S7ko7Ikgu7VcposNS3ko7EkwR7SRASmvhT0ZVhsp8cNifbvPwCXPQAk6RQNol6S/dVZsR7w+KS10oQcUWbZd/4cveT6ZTalkOoPwD+o0YsikkyRTS2vYzC2GcSodg/XVZRNrS8DcLH6f+gtALv4LQt5n4AAAAABJRU5ErkJggg==" name="1" id="test2" style="width:40px;">
									<div class="mui-media-body">
										<input style="display: none" type="file" accept="image/*" id="recPic1" capture="camera" suffix="jpg,jpeg,png">测试图片
										<input id="test2Url" type="hidden" name="test2Url" value="">
									</div>
								</label>
							</li>
							<li class="mui-table-view-cell mui-media mui-col-xs-4 mui-col-sm-3">
								<label for="recPic2">
									<img class="mui-icon mui-icon-image" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACUAAAAhCAYAAABeD2IVAAACg0lEQVRYheWYMWjbQBSG/xgHHHChhnjwYEMDDaRDvbljRg8pJIOHDOmeDlkKWbpkCDSDBw8uyFBDCtKgQgMJxINGDSnE0EAzSJCAAzZEgwwpRCCBBe0JO6ll62xJjmRDP/AgvTv4/O7dk05zfwiYMaKAjqtjBly9DXPKKou5LbzfWEYEjRr4qQtZmGjXedQaRE9tNWE8BqKIx2Oh6xia1kuKgWZLtZbvgThy2x+xkQndCWge41OlDq13GfkXiSGxMAUhi4UE+tcnSh34ZHRwe86Dr8lokzWKxlJ4vb6F9WwC85QZEcr9J0MVK/h80hWyMA0FF9+KqIgqdU6wUvfn+C4ojiFFOMWvjvO0YKVaV2hRg9eQb5wjgS+fH4KVSi8jTQ2+xMoL54g/qY6O20YDKqUmHnn2BoV8yjGUyr9FlrL9fLSEJk5LFfz4bc1OIb+zg9UkfXRydRu7z09weHRhawkF0hJoeJTSIbFfu0IWpgKBYZHcfYdX1MY7j0S2gA/k5xZPy6eKVXCyYb9pyOCqIuhdxzuupXSJBUPpOaTpgGElksdhOvo99HG150tKFVHlZBgjhhgyh+pAl777eYiD/QPs75UxooH7kNIlsIwASo5sKEIZX87uyNOOPO/EMkpH170/Qmqv5F5sTKGrEKscBsuIjombWhF7NUdlF5uiy8hMqSIPWhn5wtoURRaSU/G5kRpZ2JPgYrc6S7ko7Ikgu7VcposNS3ko7EkwR7SRASmvhT0ZVhsp8cNifbvPwCXPQAk6RQNol6S/dVZsR7w+KS10oQcUWbZd/4cveT6ZTalkOoPwD+o0YsikkyRTS2vYzC2GcSodg/XVZRNrS8DcLH6f+gtALv4LQt5n4AAAAABJRU5ErkJggg==" name="1" id="test3" style="width:40px;">
									<div class="mui-media-body">
										<input style="display: none" type="file" accept="image/*" id="recPic2" capture="camera" suffix="jpg,jpeg,png">测试图片
										<input id="test3Url" type="hidden" name="test3Url" value="">
									</div>
								</label>
							</li>
							<li class="mui-table-view-cell mui-media mui-col-xs-4 mui-col-sm-3">
								<label for="recPic3">
									<img class="mui-icon mui-icon-image" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACUAAAAhCAYAAABeD2IVAAACg0lEQVRYheWYMWjbQBSG/xgHHHChhnjwYEMDDaRDvbljRg8pJIOHDOmeDlkKWbpkCDSDBw8uyFBDCtKgQgMJxINGDSnE0EAzSJCAAzZEgwwpRCCBBe0JO6ll62xJjmRDP/AgvTv4/O7dk05zfwiYMaKAjqtjBly9DXPKKou5LbzfWEYEjRr4qQtZmGjXedQaRE9tNWE8BqKIx2Oh6xia1kuKgWZLtZbvgThy2x+xkQndCWge41OlDq13GfkXiSGxMAUhi4UE+tcnSh34ZHRwe86Dr8lokzWKxlJ4vb6F9WwC85QZEcr9J0MVK/h80hWyMA0FF9+KqIgqdU6wUvfn+C4ojiFFOMWvjvO0YKVaV2hRg9eQb5wjgS+fH4KVSi8jTQ2+xMoL54g/qY6O20YDKqUmHnn2BoV8yjGUyr9FlrL9fLSEJk5LFfz4bc1OIb+zg9UkfXRydRu7z09weHRhawkF0hJoeJTSIbFfu0IWpgKBYZHcfYdX1MY7j0S2gA/k5xZPy6eKVXCyYb9pyOCqIuhdxzuupXSJBUPpOaTpgGElksdhOvo99HG150tKFVHlZBgjhhgyh+pAl777eYiD/QPs75UxooH7kNIlsIwASo5sKEIZX87uyNOOPO/EMkpH170/Qmqv5F5sTKGrEKscBsuIjombWhF7NUdlF5uiy8hMqSIPWhn5wtoURRaSU/G5kRpZ2JPgYrc6S7ko7Ikgu7VcposNS3ko7EkwR7SRASmvhT0ZVhsp8cNifbvPwCXPQAk6RQNol6S/dVZsR7w+KS10oQcUWbZd/4cveT6ZTalkOoPwD+o0YsikkyRTS2vYzC2GcSodg/XVZRNrS8DcLH6f+gtALv4LQt5n4AAAAABJRU5ErkJggg==" name="1" id="test4" style="width:40px;">
									<div class="mui-media-body">
										<input style="display: none" type="file" accept="image/*" id="recPic3" capture="camera" suffix="jpg,jpeg,png">测试图片
										<input id="test4Url" type="hidden" name="test4Url" value="">
									</div>
								</label>
							</li>
							<li class="mui-table-view-cell mui-media mui-col-xs-4 mui-col-sm-3">
								<label for="recPic4">
									<img class="mui-icon mui-icon-image" src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAACUAAAAhCAYAAABeD2IVAAACg0lEQVRYheWYMWjbQBSG/xgHHHChhnjwYEMDDaRDvbljRg8pJIOHDOmeDlkKWbpkCDSDBw8uyFBDCtKgQgMJxINGDSnE0EAzSJCAAzZEgwwpRCCBBe0JO6ll62xJjmRDP/AgvTv4/O7dk05zfwiYMaKAjqtjBly9DXPKKou5LbzfWEYEjRr4qQtZmGjXedQaRE9tNWE8BqKIx2Oh6xia1kuKgWZLtZbvgThy2x+xkQndCWge41OlDq13GfkXiSGxMAUhi4UE+tcnSh34ZHRwe86Dr8lokzWKxlJ4vb6F9WwC85QZEcr9J0MVK/h80hWyMA0FF9+KqIgqdU6wUvfn+C4ojiFFOMWvjvO0YKVaV2hRg9eQb5wjgS+fH4KVSi8jTQ2+xMoL54g/qY6O20YDKqUmHnn2BoV8yjGUyr9FlrL9fLSEJk5LFfz4bc1OIb+zg9UkfXRydRu7z09weHRhawkF0hJoeJTSIbFfu0IWpgKBYZHcfYdX1MY7j0S2gA/k5xZPy6eKVXCyYb9pyOCqIuhdxzuupXSJBUPpOaTpgGElksdhOvo99HG150tKFVHlZBgjhhgyh+pAl777eYiD/QPs75UxooH7kNIlsIwASo5sKEIZX87uyNOOPO/EMkpH170/Qmqv5F5sTKGrEKscBsuIjombWhF7NUdlF5uiy8hMqSIPWhn5wtoURRaSU/G5kRpZ2JPgYrc6S7ko7Ikgu7VcposNS3ko7EkwR7SRASmvhT0ZVhsp8cNifbvPwCXPQAk6RQNol6S/dVZsR7w+KS10oQcUWbZd/4cveT6ZTalkOoPwD+o0YsikkyRTS2vYzC2GcSodg/XVZRNrS8DcLH6f+gtALv4LQt5n4AAAAABJRU5ErkJggg==" name="1" id="test5" style="width:40px;">
									<div class="mui-media-body">
										<input style="display: none" type="file" accept="image/*" id="recPic4" capture="camera" suffix="jpg,jpeg,png">测试图片
										<input id="test5Url" type="hidden" name="test5Url" value="">
									</div>
								</label>
							</li>
						</ul>
					</div>
					<div class="mui-button-row">
						<button type="button" class="mui-btn mui-btn-primary" onclick="return false;">确认</button>&nbsp;&nbsp;
						<button type="button" class="mui-btn mui-btn-danger" onclick="return false;">取消</button>
					</div>
				</form>
				<div class="mui-input-row" style="margin: 10px 5px;">
					<textarea id="textarea" rows="5" placeholder="多行文本框"></textarea>
				</div>
			</div>
		</div>
		<script>
			var ctx = '${ctx}';
			mui.init({
				swipeBack: true //启用右滑关闭功能
			});
			// I only use the first
			document.getElementById('recPic').addEventListener('change',function(){
				console.log(this);//If you do not know what is change ,just show it and determine how to handle
				var imgUrl = ctx + '/upload/picture';
				var data={
					"id":1
				}
				MyAutoUpload(this,'test1',imgUrl,data,function(result){
					console.log(result);
				})
			})
		</script>
	</body>

</html>