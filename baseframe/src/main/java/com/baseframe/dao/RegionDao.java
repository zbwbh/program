package com.baseframe.dao;

import java.util.List;

import com.baseframe.entity.Regions;

public interface RegionDao {

    List<Regions> selectRegionsByPRegionId(Integer pRegionId);
    
    List<Regions> selectAllRegions();
    
}
