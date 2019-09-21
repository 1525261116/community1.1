package com.hhit.community.community.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 作者: 周鸿
 * @version v1.0 创建时间: 2019/9/21 17:16
 * @email 邮箱: 1525261116@qq.com
 * @description 描述:
 */
@Controller()
public class ProfilesController {
    @GetMapping("/profiles/{action}")
    public String profiles(@PathVariable(name = "action") String action,
                           Model model) {
        if ("questions".equals(action)){
            model.addAttribute("section","questions");
            model.addAttribute("sectionName","我的提问");
        }
        return "profiles";
    }

}
