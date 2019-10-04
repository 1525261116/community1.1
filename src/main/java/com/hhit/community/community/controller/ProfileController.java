package com.hhit.community.community.controller;

import com.hhit.community.community.dto.PaginationDTO;
import com.hhit.community.community.mapper.UserMapper;
import com.hhit.community.community.model.User;
import com.hhit.community.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author 作者: 周鸿
 * @version v1.0 创建时间: 2019/9/21 17:16
 * @email 邮箱: 1525261116@qq.com
 * @description 描述:
 */
@Controller()
public class ProfileController {
    @Autowired
    private QuestionService questionService;
    @GetMapping("/profile/{action}")
    public String profile(HttpServletRequest request,
                          Model model,
            @PathVariable(name = "action") String action,
                          @RequestParam(name = "page", defaultValue = "1") Integer page,
                          @RequestParam(name = "size", defaultValue = "2") Integer size
    ) {
        User user = (User) request.getSession().getAttribute("user");
        if (user==null){
            return "redirect:/";
        }
        if ("questions".equals(action)) {
            model.addAttribute("section", "questions");
            model.addAttribute("sectionName", "我的问提");
        } else if ("replies".equals(action)) {
            model.addAttribute("section", "replies");
            model.addAttribute("sectionName", "最新回复");
        }
        PaginationDTO paginationDTO = questionService.listByUserId(user.getId(),page,size);
        model.addAttribute("paginationDTO", paginationDTO);
        return "profile";
    }
}