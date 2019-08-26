package com.hhit.community.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 作者: 周鸿
 * @version v1.0 创建时间: 2019/8/25 10:15
 * @email 邮箱: 1525261116@qq.com
 * @description 描述:
 */
@Controller
public class HelloController {
    @GetMapping("/hello")
    public String  hello(@RequestParam(name = "name") String name , Model model){
        model.addAttribute("name",name);
        return "hello";
    }
}
