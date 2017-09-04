package com.baseframe.service;

import com.alibaba.fastjson.JSONObject;

public interface CarBrandService {

    /**
     * use an array to group the brand accroding to the first letter
     * @author koala
     * @since 2017年9月1日
     */
    public void setCarBrandByFirstLetterGroup();
    
    public JSONObject getCarBrandsFromRedis();
}
