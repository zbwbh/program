package com.baseframe.controller.brandlist;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.baseframe.service.CarBrandService;

@Controller
@RequestMapping("/frame/brand")
public class BrandListController {

    @Resource
    private CarBrandService carBrandService;
    
    /**
     * car brand list page
     *
     * @author koala
     * @since 2017年9月1日
     */
    @RequestMapping("/page")
    public String brandPage(){
        return "wechat/car_brand/brand";
    }
    
    /**
     * get car brand list use Ajax of the get request
     * Typically, spring returns data in JSON format
     * @author koala
     * @since 2017年9月1日
     */
    @RequestMapping(value = "/getBrandList", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getBrandList(){
        JSONObject jo = new JSONObject();
        JSONObject resultJo = carBrandService.getCarBrandsFromRedis();
        if (null == resultJo) {
            jo.put("code", 0);
            jo.put("msg", "no data");
            return jo;
        }
        return resultJo;
    }
}
