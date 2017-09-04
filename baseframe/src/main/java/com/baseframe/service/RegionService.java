package com.baseframe.service;

import java.util.List;

import com.baseframe.entity.auxiliary.Regions;

public interface RegionService {

    public void setRegionsFromRedis();
    
    public List<Regions> getRegionsFromRedis();
    
    /**
     * 获取区域联动
     *
     * @author koala
     * @since 2017年7月26日
     */
    public List<Regions> getLinkageRegion();
}
