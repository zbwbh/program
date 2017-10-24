<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" id="viewport" content="width=device-width, initial-scale=1">
<title>html5向左滑动删除特效</title>

<style>
   *{ padding:0; margin:0; list-style: none;}
   header{ background: #f7483b; border-bottom: 1px solid #ccc}
   header h2{ text-align: center; line-height: 54px; font-size: 16px; color: #fff}
   .list-ul{ overflow: hidden}
   .list-li{ line-height: 60px; border-bottom: 1px solid #fcfcfc; position:relative;padding: 0 12px; color: #666;
       background: #f2f2f2;
       -webkit-transform: translateX(0px);
   }
   .btn{ position: absolute; top: 0; right: -80px; text-align: center; background: #ffcb20; color: #fff; width: 80px}
</style>

</head>
<body>
<header>
    <h2>消息列表</h2>
</header>
<section class="list">
    <ul class="list-ul">
        <li id="li" class="list-li">
            <div class="con">
                你的快递到了，请到楼下签收
            </div>
           <div class="btn">删除</div>
        </li>
        <li class="list-li">
            <div class="con">
                网吧五黑，就差你了
            </div>
            <div class="btn">删除</div>
        </li>
    </ul>
</section>

<p>X: <span id="X"></span></p>
<p>objX: <span id="objX"></span></p>
<p>initX: <span id="initX"></span></p>
<p>moveX: <span id="moveX"></span></p>
 
<script type="text/javascript" src="${ctx}/static/js/zepto.min.js"></script>
<script type="text/javascript" src="${ctx}/static/js/zepto.touchWipe.js"></script>
<script type="text/javascript">
    $(function() {//没发现这里没有引入jq，这里的$也可以使用么，因为这个$不是jQuery，而是Zepto
    	$('.list-li').touchWipe({itemDelete: '.btn'});
    });
    
    $("#thelist").on('click','#btn',function(){//这里没有替换成.btn，class不只有一个，而且替换成btn1，样式又变了，所以只能用#btn了
    	console.log("lksjdf");
    })
</script>
 </body>
</html>