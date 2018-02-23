package com.baseframe.controller;


import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 测试类，验证是否能走通springmvc
 * 
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
    
    public static void main(String[] args) {
//        Random ran = new Random();
//        Integer rand1 = ran.nextInt();
//        int rand = rand1 & 0x7FFFFFFF;
//        System.out.println(rand1);
//        System.out.println(rand);
        String str = "a";
        StringBuffer num = new StringBuffer();
        for (byte b : str.getBytes()) {
            num.append(Math.abs(b - 96));
        }
    }
}
