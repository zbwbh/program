package com.baseframe.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

/**
 * 
 * 获取网页json数据，其实主要是生成页面里面所有内容的字符串
 * 网址不一定永久有效，但是方法应该记住
 * @author koala
 * @since 2017年8月2日
 */
public class HttpConfigUtil {

    public static String getHttpResponse(String allConfigUrl) {
        BufferedReader in = null;
        StringBuffer result = null;
        try {
            URI uri = new URI(allConfigUrl);
            URL url = uri.toURL();
            URLConnection connection = url.openConnection();
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Charset", "utf-8");
            
            connection.connect();
            result = new StringBuffer();
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while((line = in.readLine())!=null){
                result.append(line);
            }
            return result.toString();
        }
        catch (Exception e) {
            e.printStackTrace();
            return getHttpResponse(allConfigUrl);
            //如果发生异常则进行二次访问
        }finally {
            try {
                if(in!=null){
                    in.close();
                }
            }
            catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args) {
        String url = "http://pub.icaile.com/jlk3kjjg.php?action=chart&date=yesterday&random=0.5557653632363895&id=806&async=true";
        String json = getHttpResponse(url);
        System.out.println(json);
    }
}
