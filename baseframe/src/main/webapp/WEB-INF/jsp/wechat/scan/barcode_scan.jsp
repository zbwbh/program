<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
        <meta name="HandheldFriendly" content="true" />
        <meta name="MobileOptimized" content="320" />
        <title>扫码界面</title>
        <!--<script type="text/javascript" src="../js/commonSelf.js"></script>-->
        <script type="text/javascript">
            (function(w) {
                var waiting = null;
                /**
                 * 关闭等待框
                 */
                w.closeWaiting = function() {
                    waiting && waiting.close();
                    waiting = null;
                };
                // 处理返回事件
                w.back = function(hide) {
                    if(w.plus) {
                        ws || (ws = plus.webview.currentWebview());
                        if(hide || ws.preate) {
                            ws.hide('auto');
                        } else {
                            ws.close('auto');
                        }
                    } else if(history.length > 1) {
                        history.back();
                    } else {
                        w.close();
                    }
                };
            })(window);
        </script>
        <script type="text/javascript">
            var ws = null,
                wo = null;
            var scan = null,
                domready = false;
            // H5 plus事件处理
            function plusReady() {
                if(ws || !window.plus || !domready) {
                    return;
                }
                // 获取窗口对象
                ws = plus.webview.currentWebview();
                wo = ws.opener();
                // 开始扫描
                ws.addEventListener('show', function() {
                    scan = new plus.barcode.Barcode('bcid');
                    scan.onmarked = onmarked;
                    scan.start({
                        conserve: true,
                        filename: "_doc/barcode/"
                    });
                });
                // 显示页面并关闭等待框
                ws.show("pop-in");
                wo.evalJS("closeWaiting()");
            }
            if(window.plus) {
                plusReady();
            } else {
                document.addEventListener("plusready", plusReady, false);
            }
            // 监听DOMContentLoaded事件
            document.addEventListener("DOMContentLoaded", function() {
                domready = true;
                plusReady();
            }, false);
            // 二维码扫描成功
            function onmarked(type, result, file) {
                switch(type) {
                    case plus.barcode.QR:
                        type = "QR";
                        break;
                    case plus.barcode.EAN13:
                        type = "EAN13";
                        break;
                    case plus.barcode.EAN8:
                        type = "EAN8";
                        break;
                    default:
                        type = "其它" + type;
                        break;
                }
                result = result.replace(/\n/g, '');
                wo.evalJS("scaned('" + type + "','" + result + "','" + file + "');");
                back();
            }
        </script>
        <style type="text/css">
            html {
                width: 100%;
                height: 100%;
            }
            
            body {
                margin: 0;
                padding: 0;
                width: 100%;
                height: 100%;
                font-family: Arial;
                font-size: 16px;
                color: #6c6c6c;
                -webkit-touch-callout: none;
                -webkit-tap-highlight-color: rgba(0, 0, 0, 0);
                -webkit-text-size-adjust: none;
            }
            
            #bcid {
                width: 100%;
                position: absolute;
                top: 0px;
                bottom: 44px;
                text-align: center;
            }
            
            .tip {
                color: #FFFFFF;
                font-weight: bold;
                text-shadow: 0px -1px #103E5C;
            }
            
            footer {
                width: 100%;
                height: 44px;
                position: absolute;
                bottom: 0px;
                line-height: 44px;
                text-align: center;
                color: #FFF;
            }
            
            .fbt {
                width: 100%;
                height: 100%;
                background-color: #FFCC33;
                float: left;
            }
            
            .fbt:active {
                -webkit-box-shadow: inset 0 3px 5px rgba(0, 0, 0, 0.5);
                box-shadow: inset 0 3px 5px rgba(0, 0, 0, 0.5);
            }
        </style>
    </head>

    <body style="background-color: #000000;">
        <div id="bcid">
            <div style="height:40%"></div>
            <p class="tip">...载入中...</p>
        </div>
        <footer>
            <div class="fbt" onclick="back();">取　 消</div>
        </footer>
    </body>

</html>