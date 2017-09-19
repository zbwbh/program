package com.baseframe.controller.upload;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.baseframe.service.UploadPicService;

/**
 * Some basic operation.</br>
 * If have others operation later, please create new controller</br>
 * 
 * @author koala
 * @since 2017年9月1日
 */
@Controller
@RequestMapping("/upload")
public class UploadPicController {

    @Resource
    private UploadPicService uploadPicService;
    
    @RequestMapping("/formPage")
    public String fromPage(){
        return "wechat/upload_picture/form_page";
    }
    
    @RequestMapping("/picture")
    @ResponseBody
    public JSONObject uploadPicture(HttpServletRequest request){
        // you can direct write here.or you can write it in service
        // I choose the second.
        JSONObject jo = new JSONObject();
        String result = uploadPicService.uploadPic4(request);
        if (null == result) {
            jo.put("code", 0);
            jo.put("msg", "no data");
            return jo;
        }
        jo.put("code", 200);
        jo.put("data", result);
        return jo;
    }
}
