package com.hhit.community.community.dto;

/**
 * @author 作者: 周鸿
 * @version v1.0 创建时间: 2019/8/25 16:04
 * @email 邮箱: 1525261116@qq.com
 * @description 描述:
 */
public class GithubUser {
    private String name;
    private  Long id;
    private  String bio;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
