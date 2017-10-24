package com.baseframe.controller.downloadexcel;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baseframe.service.PoiService;

@Controller
@RequestMapping("/poi")
public class PoiController {

    @Resource
    private PoiService poiService;
    
    @RequestMapping("/download/page")
    public String toDownloadPage() {
        return "wechat/poi/excel_page";
    }
    
    //没有传任何参数，当然，如果你想导出数据到excel表格当中，可以传入需要的查询条件
    @RequestMapping("/excel/download")
    @ResponseBody
    public String downloadExcel() {
        return poiService.downloadExcel();
    }
}
