package com.baseframe.dao;

import java.util.List;

import com.baseframe.entity.auxiliary.Regions;

public interface RegionDao {

    List<Regions> listRegionsByPRegionId(Integer pRegionId);
    
    List<Regions> listAllRegions();
    
}
