package com.hhit.community.community.model;

import lombok.Data;

/**
 * @author 作者: 周鸿
 * @version v1.0 创建时间: 2019/9/7 15:51
 * @email 邮箱: 1525261116@qq.com
 * @description 描述:
 */
@Data
public class Question {
    private Integer id;
    private  String title;
    private String description;
    private  Long gmtCreate;
    private Long gmtModified;
    private Integer creatorId;
    private Integer commentCount;
    private Integer viewCount;
    private Integer likeCount;
    private String tag;
}
