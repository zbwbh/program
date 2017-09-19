package com.baseframe.service.impl;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.baseframe.service.VinDataService;

@Service
public class VinDataServiceImpl implements VinDataService {

    public JSONObject getVinData(String vin) {
        String xmlInput  = "<root><appkey>c38e13ea7aec2abd</appkey>"
                        + "<appsecret>06f0e23d322c4057a9ef139802ed38b9</appsecret>"
                        + "<method>level.vehicle.vin.get</method>"
                        + "<requestformat>json</requestformat>"
                        + "<vin>" + vin + "</vin></root>";
              xmlInput = xmlInput.replace("<", "&lt;");
              xmlInput = xmlInput.replace(">", "&gt;");
        String soapRequestData = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"
                              + "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">" 
                              + "<soap12:Body>" 
                              + "<LevelData xmlns=\"http://www.dat881.com/\">" 
                              + "<xmlInput>" + xmlInput + "</xmlInput>" + "</LevelData>" // 接口传入参数 
                              + "</soap12:Body>" + "</soap12:Envelope>"; 
        HttpPost post = new HttpPost("http://service.vin114.net/req");
        StringEntity entity = new StringEntity(soapRequestData, "UTF-8");
        post.addHeader("Content-type", "text/html;charset=UTF-8");
        post.setEntity(entity);
        
        CloseableHttpClient httpClient = HttpClients.custom().build();
        try {
            HttpResponse response = httpClient.execute(post);
            HttpEntity resEntity = response.getEntity();
            soapRequestData = EntityUtils.toString(resEntity);
        }
        catch (Exception e) {
            // TODO: handle exception
        }
        String jsonStr = soapRequestData.substring(soapRequestData.indexOf("{"), soapRequestData.indexOf("</LevelDataResult>"));
        JSONObject resultJson = new JSONObject();
        JSONObject jo = JSONObject.parseObject(jsonStr);
        
        JSONObject joInfo =  JSONObject.parseObject(jo.get("Info")+"");
        String bool = joInfo.get("Success")+"";
        if ("false".equals(bool)) {
            resultJson.put("code", 0);
            return resultJson;
        }
        if ("true".equals(bool)) {
            ExecutorService executor = Executors.newFixedThreadPool(2);
            CompletableFuture<String> future = CompletableFuture.supplyAsync(new Supplier<String>(){

                public String get() {
                    System.out.println("力洋vin码接口返回数据插入数据库任务开始");
                    try {
                        System.out.println("插入数据省略，只是数据库操作");
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                    return "力洋vin码接口返回数据插入数据库任务结束";
                }
                
            },executor);
            //lambda表达式，之前用的是1.5，版本不对，然后在设置当中修改成1.8之后可以用了
            future.thenAccept(e -> System.out.println(e + "ok"));
            
            resultJson.put("code", 200);
            resultJson.put("data", jo);
            return resultJson;
        }
        return null;
    }

    public static void main(String[] args) {
        String xmlInput  = "<root><appkey>c38e13ea7aec2abd</appkey>"
                        + "<appsecret>06f0e23d322c4057a9ef139802ed38b9</appsecret>"
                        + "<method>level.vehicle.vin.get</method>"
                        + "<requestformat>json</requestformat>"
                        + "<vin>" + "LGWEF4A54GF492634" + "</vin></root>";
              xmlInput = xmlInput.replace("<", "&lt;");
              xmlInput = xmlInput.replace(">", "&gt;");
        String soapRequestData = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"
                              + "<soap12:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap12=\"http://www.w3.org/2003/05/soap-envelope\">" 
                              + "<soap12:Body>" 
                              + "<LevelData xmlns=\"http://www.dat881.com/\">" 
                              + "<xmlInput>" + xmlInput + "</xmlInput>" + "</LevelData>" // 接口传入参数 
                              + "</soap12:Body>" + "</soap12:Envelope>"; 
        HttpPost post = new HttpPost("http://service.vin114.net/req");
        StringEntity entity = new StringEntity(soapRequestData, "UTF-8");
        post.addHeader("Content-type", "text/html;charset=UTF-8");
        post.setEntity(entity);
        
        CloseableHttpClient httpClient = HttpClients.custom().build();
        try {
            HttpResponse response = httpClient.execute(post);
            HttpEntity resEntity = response.getEntity();
            soapRequestData = EntityUtils.toString(resEntity);
        }
        catch (Exception e) {
            // TODO: handle exception
        }
    }
}
