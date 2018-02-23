package com.httppost;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

public class PostRequest {

    public static void geneQrcode() {
        Map<String,String> params = new HashMap<String,String>();
        params.put("groupNo", "10001");
        String url = "http://localhost:8080/xxxserver/..."; 
        
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        try {
            // 将参数存储起来
            if (null != params && !params.isEmpty()) {
                List<NameValuePair> nvps = new LinkedList<NameValuePair>();
                for (Map.Entry<String, String> m : params.entrySet()) {
                    BasicNameValuePair pair = new BasicNameValuePair(m.getKey(), m.getValue());
                    nvps.add(pair);
                }
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(nvps,Consts.UTF_8);
                post.setEntity(entity);
            }
            
//            post.addHeader("","");...略
            
            CloseableHttpResponse response = client.execute(post);//执行post请求
            System.out.println(response);
        }
        catch (Exception e) {
            
        }
    }
    
    public static void main(String[] args) {
        new PostRequest();
        PostRequest.geneQrcode();
    }
}
