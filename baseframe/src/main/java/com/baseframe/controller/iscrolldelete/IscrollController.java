package com.baseframe.controller.iscrolldelete;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/iscroll")
public class IscrollController {

    /**
     * 引入Zepto插件，其中的touchWipe给JQ新增了一个函数，用来删除用
     * 这个还是比较靠谱的，奈何本人前端基础太差，很多东西都搞不懂
     * 刚开始让写这个功能的时候还一顿抱怨，其实是自己心太急了，慢慢来就可以，
     * 前后加在一起这个功能满打满算实际上也就一天而已，不过是间歇性的写而已
     * 而且，这个功能估计也不重视，所以一直没有催
     * 
     * @return
     *
     * @author zbw
     * @since 2017年10月27日
     */
    @RequestMapping("/delete/one")
    public String iscrollpage() {
        return "wechat/iscroll/iscroll_page";
    }
    
    @RequestMapping("/delete/two")
    public String iscrollPage() {
        return "wechat/iscroll/iscroll_page2";
    }
}
