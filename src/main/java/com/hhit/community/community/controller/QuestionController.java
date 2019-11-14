package com.hhit.community.community.controller;

import com.hhit.community.community.dto.QuestionDTO;
import com.hhit.community.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping("/question/{id}")
    public String question(@PathVariable(name = "id") Integer id,
                           Model model) {
        QuestionDTO questionDTO = questionService.findById(id);
        int viewCount= questionDTO.getViewCount() + 1;
        questionService.incView(id,viewCount);
        questionDTO.setViewCount(viewCount);
        model.addAttribute("question",questionDTO);
        return "question";
    }
}
