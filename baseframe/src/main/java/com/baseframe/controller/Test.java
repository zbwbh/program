package com.baseframe.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 测试类，验证是否能走通springmvc
 * 该类只负责能不能走通，其他的交给别人测试
 *
 * @author koala
 * @since 2017年7月26日
 */
@Controller
@RequestMapping("/test1")
public class Test {
    
    @RequestMapping("/test2")
    public String test(Model model){
        return "test";
    }
}
