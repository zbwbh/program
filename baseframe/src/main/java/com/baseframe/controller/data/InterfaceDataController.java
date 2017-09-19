package com.baseframe.controller.data;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.baseframe.service.VinDataService;
import com.baseframe.util.ResultType;
import com.baseframe.util.ResultVO;

/**
 * 如果再没有活就很危险了
 * 
 *
 * @author koala
 * @since 2017年9月12日
 */
@Controller
@RequestMapping("/data")
public class InterfaceDataController {

    @Resource
    private VinDataService vinDataService;
    
    @RequestMapping("/vin/data")
    @ResponseBody
    public ResultVO getvinData(String vin){
        if (StringUtils.isEmpty(vin)) {
            return new ResultVO(ResultType.NULL_OBJ);
        }
        JSONObject resultJo = vinDataService.getVinData(vin);
        if (resultJo.getIntValue("code") == 0) {
            return new ResultVO(ResultType.NO_DATA);
        }
        if (resultJo.getIntValue("code") == 200) {
            return new ResultVO(ResultType.SUCCESS,resultJo.get("data"));
        }
        return new ResultVO(ResultType.FAIL);
    }
}
