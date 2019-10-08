package com.hhit.community.community.controller;

import com.hhit.community.community.dto.AccessTokenTDO;
import com.hhit.community.community.dto.GithubUser;
import com.hhit.community.community.mapper.UserMapper;
import com.hhit.community.community.model.User;
import com.hhit.community.community.provider.GithubProvider;
import com.hhit.community.community.service.UserService;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author 作者: 周鸿
 * @version v1.0 创建时间: 2019/8/25 14:55
 * @email 邮箱: 1525261116@qq.com
 * @description 描述:
 */
@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;

    @Autowired
    private UserService userService;

    @Value("${github.client_id}")
    private String clienId;
    @Value("${github.client_secret}")
    private String clientSecret;
    @Value("${github.redirect_uri}")
    private String redirectUri;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletRequest request
            , HttpServletResponse response) {
        AccessTokenTDO accessTokenTDO = new AccessTokenTDO();
        accessTokenTDO.setCode(code);
        accessTokenTDO.setClient_id(clienId);
        accessTokenTDO.setClient_secret(clientSecret);
        accessTokenTDO.setRedirect_uri(redirectUri);
        accessTokenTDO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenTDO);
        GithubUser githubUser = githubProvider.getUser(accessToken);
        if (githubUser != null) {
            //登录成功，写cookie和session
            User user = new User();
            String token = UUID.randomUUID().toString();
            user.setToken(token);
            user.setAccountId(String.valueOf(githubUser.getId()));
            user.setName(githubUser.getName());
            user.setAvatarUrl(githubUser.getAvatarUrl());
            userService.insertOrUpdate(user);
            response.addCookie(new Cookie("token",token));
            return "redirect:/";
        } else {
            //登录失败
            return "index";
        }
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request,
                         HttpServletResponse response){
        request.getSession().removeAttribute("user");
        Cookie cookie = new Cookie("token",null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return  "redirect:/";
    }
}
