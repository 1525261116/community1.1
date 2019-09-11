package com.hhit.community.community.dto;

import lombok.Data;

/**
 * @author 作者: 周鸿
 * @version v1.0 创建时间: 2019/8/25 16:04
 * @email 邮箱: 1525261116@qq.com
 * @description 描述:
 */
@Data
public class GithubUser {
    private String name;
    private  Long id;
    private  String bio;
    private  String avatarUrl;

}
