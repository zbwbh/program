package com.baseframe.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baseframe.dao.CarBrandDao;
import com.baseframe.entity.auxiliary.CarBrand;
import com.baseframe.redis.util.RedisClientTemplate;
import com.baseframe.service.CarBrandService;
import com.baseframe.util.Constants;

@Service
public class CarBrandServiceImpl implements CarBrandService {

    @Resource
    private CarBrandDao carBrandDao;
    
    @Resource
    private RedisClientTemplate redisClientTemplate;
    
    /**
     * Direct queries is very slow, so I put this in the redis
     * 
     * @author koala
     * @since 2017年9月1日
     */
    public void setCarBrandByFirstLetterGroup() {
        CarBrand c = new CarBrand();// If I put this in the for loop,it can work,but it will create many times
        c.setCanFindPartShow("1");
        JSONObject jo = new JSONObject();
        Character letter[] = {'A','B','C','D','E','F','G','H','I','J','K','L','M',
                              'N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        for (int i = 0; i < letter.length; i++) {
            c.setCarFirstLetter(letter[i]);
            List<CarBrand> list = carBrandDao.selectCarBrandsByFirstLetter(c);
            if (!list.isEmpty()) {
                jo.put(letter[i].toString(), list);
            }
        }
        String jsonStr = JSON.toJSONString(jo);
        redisClientTemplate.setKey(Constants.BRAND_GROUP_BY_ABC,jsonStr);
    }

    public JSONObject getCarBrandsFromRedis() {
        // I did't create a new method to solve this problem.But it can always work.
        // I mean the force conversion about a redis command
        String result = (String) redisClientTemplate.getKey(Constants.BRAND_GROUP_BY_ABC);
        if (null == result) {
            setCarBrandByFirstLetterGroup();
            result = (String)redisClientTemplate.getKey(Constants.BRAND_GROUP_BY_ABC);
        }
        JSONObject jo = JSON.parseObject(result);
        return jo;
    }

}
