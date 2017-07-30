package com.baseframe.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.baseframe.entity.Member;
import com.baseframe.entity.Regions;
import com.baseframe.service.MemberService;
import com.baseframe.service.RegionService;

/**
 * 登录、注册、注销、忘记密码
 * 
 *
 * @author koala
 * @since 2017年7月27日
 */
@Controller
@RequestMapping("/wechat")
public class WechatMain {

    @Resource
    private RegionService regionService;
    
    @Resource
    private MemberService memberService;
    /**
     * 登录页面
     *
     * @author koala
     * @since 2017年7月27日
     */
    @RequestMapping("/toLoginPage")
    public String toLogin(Model model){
        return "wechat/loginPage";
    }
    
    /**
     * 注册页面
     *
     * @author koala
     * @since 2017年7月27日
     */
    @RequestMapping("/toRegisterPage")
    public String toRegister(Model model) {
        List<Regions> regions = regionService.getRegionsFromRedis();
        model.addAttribute("regions",JSON.toJSONString(regions));
        return "wechat/registerPage";
    }
    
    @RequestMapping("/checkName")
    @ResponseBody
    public String checkName(String newName) {
        return memberService.checkName(newName);
    }
    
    @RequestMapping("/formRegist")
    @ResponseBody
    public String formRegist(Member member){
        if(null==member){
            return "0";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String password = DigestUtils.md5Hex(member.getPassword());
        member.setCreateTime(sdf.format(new Date()));
        member.setPassword(password);
        memberService.insertMember(member);
        return "1";
    }
    
    @RequestMapping("/toIndex")
    public String toIndex() {
        return "";
    }
}
