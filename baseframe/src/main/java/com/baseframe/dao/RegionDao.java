package com.baseframe.dao;

import java.util.List;

import com.baseframe.entity.Regions;

public interface RegionDao {

    /**
     * 根据父级id获取子集元素
     *
     * @author koala
     * @since 2017年6月23日
     */
    List<Regions> selectRegionsByPRegionId(Integer pRegionId);
    
    List<Regions> selectAllRegions();
    
}
