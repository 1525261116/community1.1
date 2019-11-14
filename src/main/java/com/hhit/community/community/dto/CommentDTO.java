package com.hhit.community.community.dto;

import com.hhit.community.community.model.User;
import lombok.Data;

/**
 * @author 作者: 周鸿
 * @version v1.0 创建时间: 2019/10/8 20:08
 * @email 邮箱: 1525261116@qq.com
 * @description 描述:
 */
@Data
public class CommentDTO {
    private Long id;
    private Integer parentId;
    private Integer parentType;//0表示问题1表示评论
    private Integer commentator;
    private String content;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer likeCount;
    private Integer commentCount;
    private User user;
}
