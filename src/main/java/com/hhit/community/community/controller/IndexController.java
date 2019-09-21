package com.hhit.community.community.controller;

import com.hhit.community.community.dto.PaginationDTO;
import com.hhit.community.community.dto.QuestionDTO;
import com.hhit.community.community.mapper.QuestionMapper;
import com.hhit.community.community.mapper.UserMapper;
import com.hhit.community.community.model.Question;
import com.hhit.community.community.model.User;
import com.hhit.community.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author 作者: 周鸿
 * @version v1.0 创建时间: 2019/8/25 10:15
 * @email 邮箱: 1525261116@qq.com
 * @description 描述:
 */
@Controller
public class IndexController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionService questionService;

    @GetMapping("/")
    public String index(HttpServletRequest request,
                        Model model,
                        @RequestParam(name = "page", defaultValue = "1") Integer page,
                        @RequestParam(name = "size", defaultValue = "2") Integer size) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("token".equals(cookie.getName())) {
                    String token = cookie.getValue();
                    User user = userMapper.findByToken(token);
                    if (user != null) {
                        request.getSession().setAttribute("user", user);
                    }
                    break;
                }
            }
        }
        PaginationDTO paginationDTO = questionService.list(page, size);
        model.addAttribute("paginationDTO", paginationDTO);

        return "index";
    }
}
