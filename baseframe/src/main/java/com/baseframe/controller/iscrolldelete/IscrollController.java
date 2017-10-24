package com.baseframe.controller.iscrolldelete;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/iscroll")
public class IscrollController {

    @RequestMapping("/delete/one")
    public String iscrollpage() {
        return "wechat/iscroll/iscroll_page";
    }
}
