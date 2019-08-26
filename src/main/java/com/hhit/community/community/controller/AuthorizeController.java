package com.hhit.community.community.controller;

import com.hhit.community.community.dto.AccessTokenTDO;
import com.hhit.community.community.dto.GithubUser;
import com.hhit.community.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @Value("${github.client_id}")
    private String clienId;
    @Value("${github.client_secret}")
    private String clientSecret;
    @Value("${github.redirect_uri}")
    private  String  redirectUri;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state) {
        AccessTokenTDO accessTokenTDO = new AccessTokenTDO();
        accessTokenTDO.setCode(code);
        accessTokenTDO.setClient_id(clienId);
        accessTokenTDO.setClient_secret(clientSecret);
        accessTokenTDO.setRedirect_uri(redirectUri);
        accessTokenTDO.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenTDO);
        GithubUser user = githubProvider.getUser(accessToken);
        System.out.println(user.getName()+user.getId());
        return "index";
    }
}
