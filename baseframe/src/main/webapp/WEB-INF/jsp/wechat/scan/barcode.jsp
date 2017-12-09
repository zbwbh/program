<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>  
<html>  
   <head>  
    <meta charset="UTF-8">  
    <title></title>  
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1,maximum-scale=1,user-scalable=no" />  
    <link rel="stylesheet" href="${ctx}/static/mui_3.2.0/css/mui.min.css">
    <script src="${ctx}/static/mui_3.2.0/js/mui.min.js"></script>
    <style type="text/css">  
        #bcid{  
            width: 100%;  
            height: 100%;  
            position: absolute;  
            background: #000000;  
        }  
        html, body ,div{  
            height:100%;  
            width: 100%;  
        }  
        .fbt{  
            color: #0E76E1;  
            width: 50%;  
            background-color: #ffffff;  
            float: left;   
            line-height: 44px;  
            text-align: center;  
        }  
    </style>  
   </head>  
  <body>  
    <header class="mui-bar mui-bar-nav" style="background-color: #ffffff;">  
      <a class="mui-action-back mui-icon mui-icon-left-nav mui-pull-left"></a>  
      <h1 class="mui-title" style="color: #0E76E1;">物品二维码扫描</h1>  
      <span class="mui-icon mui-icon-spinner-cycle mui-spin mui-pull-right" id="turnTheLight"></span>  
    </header>  
          
    <div id="bcid">     
         <!--盛放扫描控件的div-->          
    </div>  
          
    <div class="mui-bar mui-bar-footer" style="padding: 0px;">  
        <div class="fbt" onclick="scanPicture();">从相册选择二维码</div>  
        <div class="fbt mui-action-back">取　 消</div>  
    </div>  
          
    <script type="text/javascript">  
           scan = ;//扫描对象  
        mui.plusReady(function () {  
              mui.init();  
          startRecognize();  
           });  
              
        function startRecognize(){  
           try{  
              var filter;  
             //自定义的扫描控件样式  
             var styles = {frameColor: "#29E52C",scanbarColor: "#29E52C",background: ""}  
            //扫描控件构造  
            scan = new plus.barcode.Barcode('bcid',filter,styles);  
            scan.onmarked = onmarked;   
            scan.onerror = onerror;  
            scan.start();  
            //打开关闭闪光灯处理  
            var flag = false;  
            document.getElementById("turnTheLight").addEventListener('tap',function(){  
               if(flag == false){  
                  scan.setFlash(true);  
                  flag = true;  
               }else{  
                 scan.setFlash(false);  
                 flag = false;  
               }  
            });  
          }catch(e){  
            alert("出现错误啦:\n"+e);  
             }  
          };  
            function onerror(e){  
                    alert(e);  
            };  
            function onmarked( type, result ) {  
                    var text = '';  
                    switch(type){  
                        case plus.barcode.QR:  
                        text = 'QR: ';  
                        break;  
                        case plus.barcode.EAN13:  
                        text = 'EAN13: ';  
                        break;  
                        case plus.barcode.EAN8:  
                        text = 'EAN8: ';  
                        break;  
                    }  
                    alert( text + " : "+ result );  
                      
            };    
                  
        // 从相册中选择二维码图片   
        function scanPicture() {  
            plus.gallery.pick(function(path){  
                plus.barcode.scan(path,onmarked,function(error){  
                    plus.nativeUI.alert( "无法识别此图片" );  
                });  
            },function(err){  
                plus.nativeUI.alert("Failed: "+err.message);  
            });  
        }         
                  
        </script>  
    </body>  
</html>  