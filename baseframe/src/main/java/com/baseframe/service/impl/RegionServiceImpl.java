package com.baseframe.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;


import org.springframework.stereotype.Service;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baseframe.dao.RegionDao;
import com.baseframe.entity.auxiliary.Regions;
import com.baseframe.redis.util.RedisClientTemplate;
import com.baseframe.service.RegionService;
import com.baseframe.util.Constants;

@Service
public class RegionServiceImpl implements RegionService {

    @Resource
    private RegionDao regionDao;
    
    @Resource
    private RedisClientTemplate redisClientTemplate;
    
    //经过登录测试是好使的，接下来该放在缓存里面了,通常情况下多层for循环是不建议的
    public List<Regions> getLinkageRegion() {
        List<Regions> province = regionDao.listRegionsByPRegionId(0);
        List<Regions> all = regionDao.listAllRegions();
        //从all当中根据province逐层往下抽取子集合
        for (Regions p : province) {
            List<Regions> city = new ArrayList<Regions>();
            for (Regions a : all) {
                if (a.getpRegionId() == p.getRegionId()) {
                    city.add(a);
                }
                List<Regions> region = new ArrayList<Regions>();
                for (Regions a2 : all) {
                    if (a2.getpRegionId() == a.getRegionId()) {
                        region.add(a2);
                    }
                }
                a.setChildren(region);
            }
            p.setChildren(city);
        }
        return province;
    }

    public void setRegionsFromRedis() {
        List<Regions> list = getLinkageRegion();
        redisClientTemplate.setCacheSet(Constants.REGIONS, JSON.toJSONString(list));
    }
    
    public List<Regions> getRegionsFromRedis() {
        String listStr = redisClientTemplate.getCacheSetFirst(Constants.REGIONS);
        List<Regions> list = null;
        if (StringUtils.isEmpty(listStr)) {
            list = getLinkageRegion();
            redisClientTemplate.setCacheSet(Constants.REGIONS, JSON.toJSONString(list));
        }else{
            list = JSON.parseArray(listStr,Regions.class);
        }
        return list;
    }
}
