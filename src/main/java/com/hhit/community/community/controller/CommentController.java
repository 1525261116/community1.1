package com.hhit.community.community.controller;

import com.hhit.community.community.dto.CommentDTO;
import com.hhit.community.community.dto.ResultObject;
import com.hhit.community.community.mapper.CommentMapper;
import com.hhit.community.community.model.Comment;
import com.hhit.community.community.service.CommentService;
import com.hhit.community.community.service.QuestionService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author 作者: 周鸿
 * @version v1.0 创建时间: 2019/10/8 20:03
 * @email 邮箱: 1525261116@qq.com
 * @description 描述:
 */
@Controller
public class CommentController {
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private CommentService commentService;
    @Autowired
    private QuestionService questionService;

    @Transactional
    @RequestMapping("/comment")//method = RequestMethod.POST
    @ResponseBody
    public ResultObject post(CommentDTO commentDTO) {
        Comment comment = new Comment();
        System.out.println(commentDTO);
        comment.setParentId(commentDTO.getParentId());
        comment.setParentType(commentDTO.getParentType());
        comment.setContent(commentDTO.getContent());
        comment.setCommentator(commentDTO.getCommentator());
        comment.setGmtCreate(System.currentTimeMillis());
        comment.setGmtModified(System.currentTimeMillis());
        commentMapper.insert(comment);
        questionService.incComment(comment.getParentId());
        return new ResultObject("ok");
    }
    @RequestMapping("/listComment")
    public String doListComment(@Param("parentId")Integer parentId,
            Model model){
        List<CommentDTO> commentDTOs = commentService.ListComment(parentId);
        model.addAttribute("comments",commentDTOs);
        System.out.println(commentDTOs);
        return "comment";
    }

}
