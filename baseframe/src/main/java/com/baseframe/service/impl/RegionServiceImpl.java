package com.baseframe.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.baseframe.dao.RegionDao;
import com.baseframe.entity.Regions;
import com.baseframe.service.RegionService;

@Service
public class RegionServiceImpl implements RegionService {

    @Resource
    private RegionDao regionDao;
    
//    @Resource
//    private RedisClientTemplate redisClientTemplate;
    
    public void setRegionsFromRedis() {
        
    }

    //经过登录测试是好使的，接下来该放在缓存里面了
    public List<Regions> getLinkageRegion() {
        List<Regions> provinceList = regionDao.selectRegionsByPRegionId(0);
        List<Regions> allList = regionDao.selectAllRegions();
        
        //每个创建新的集合和添加新的子元素都将内层循环包裹在内
        for(Regions province : provinceList) {
            List<Regions> city = new ArrayList<Regions>();//创建新的集合
            for(Regions middle1 : allList) {
                if(province.getRegionId()==middle1.getpRegionId()){
                    city.add(middle1);
                }
                
                List<Regions> region = new ArrayList<Regions>();
                for(Regions middle2:allList){
                    if(middle2.getpRegionId()==middle1.getRegionId()) {
                        region.add(middle2);
                    }
                }
                middle1.setChildren(region);
            }
            province.setChildren(city);//添加新的子元素，将内层循环包裹在内，内从嵌套同理
        }
        return provinceList;
    }
    
}
