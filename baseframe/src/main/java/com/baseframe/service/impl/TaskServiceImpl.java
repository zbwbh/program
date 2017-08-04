package com.baseframe.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baseframe.dao.LotteryDao;
import com.baseframe.entity.Kuai3Lottery;
import com.baseframe.entity.Middle;
import com.baseframe.service.TaskService;
import com.baseframe.util.HttpConfigUtil;

/**
 * 定时任务实现
 * 
 *
 * @author koala
 * @since 2017年8月3日
 */
@Service
public class TaskServiceImpl implements TaskService {

    @Resource
    private LotteryDao l;
    
//    @Scheduled(cron = "0 0/1 * * * ?")//先把这个注释掉，如果有需要定时任务的地方在加上
    public void test() {
        System.out.println("开始任务");
        String url = "http://pub.icaile.com/jlk3kjjg.php?action=chart&date=yesterday&random=0.5557653632363895&id=806&async=true";
        String json = HttpConfigUtil.getHttpResponse(url);
        
        /**
         * json串来回转换
         */
        Map<String,Object> map = JSONObject.parseObject(json);
        String mm = JSON.toJSONString(map.get("data"));
        List<Middle> list = JSONObject.parseArray(mm,Middle.class);
        for(Middle m : list){
            Kuai3Lottery k = new Kuai3Lottery();
            k.setIssue(m.getDateNumber());
            k.setLotteryTime(m.getDateTime());
            k.setNumber1(m.getList().get(0));
            k.setNumber2(m.getList().get(1));
            k.setNumber3(m.getList().get(2));
            k.setRemark(m.getTypeByLabel());
            l.insertLottery(k);
        }
        System.out.println("结束任务");
        //原来想用Map的方式来遍历的，可是没用上，不过这个记下来也好
//        Iterator<Map.Entry<String, Object>> it = map2.entrySet().iterator();
//        while(it.hasNext()){
//            Kuai3Lottery k = new Kuai3Lottery();
//            Map.Entry<String, Object> entry = it.next();
//            System.out.println("value= " + entry.getValue());
//        }
    }
}
