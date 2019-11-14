package com.hhit.community.community.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hhit.community.community.dto.CommentDTO;
import com.hhit.community.community.mapper.CommentMapper;
import com.hhit.community.community.mapper.UserMapper;
import com.hhit.community.community.model.Comment;
import com.hhit.community.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 作者: 周鸿
 * @version v1.0 创建时间: 2019/10/15 8:45
 * @email 邮箱: 1525261116@qq.com
 * @description 描述:
 */
@Service
public class CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private UserMapper userMapper;
/*
可优化有Map<user,comment>
*/
    public List<CommentDTO> ListComment(Integer parentId) {
        List<Comment> comments = commentMapper.selectList(new QueryWrapper<Comment>().eq("parent_id",parentId));
        List<CommentDTO>commentDTOs=new ArrayList<>();
        CommentDTO commentDTO = new CommentDTO();
        for (Comment comment : comments) {
            User user = userMapper.findById(comment.getCommentator());//发表评论的用户
            BeanUtils.copyProperties(comment,commentDTO);
            commentDTO.setUser(user);
            commentDTOs.add(commentDTO);
        }
        return commentDTOs;
    }
}
