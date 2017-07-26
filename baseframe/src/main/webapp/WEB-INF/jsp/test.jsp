<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<html>
<head>
</head>
<body>
	我就是想确认一下这个页面能不能进来，没有别的意思
	<script type="text/javascript">
		var ctx = '${ctx}';
		//jsp内置对象request，用el表达式可以获取内置对象的值，根据所使用的对象决定
		console.log(ctx);//  输出/baseframe
		var title = '${title}';
		console.log(title);
		
	</script>
</body>
</html>
