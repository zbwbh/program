package com.baseframe.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.baseframe.entity.Regions;
import com.baseframe.service.RegionService;

@Controller
@RequestMapping("/wechat")
public class WechatLogin {

    @Resource
    private RegionService regionService;
    
    @RequestMapping("/login")
    public String toLogin(Model model){
        List<Regions> region = regionService.getLinkageRegion();
        model.addAttribute("regions",region);
        return "wechat/login";
    }
}
