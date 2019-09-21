package com.hhit.community.community.service;

import com.hhit.community.community.dto.PaginationDTO;
import com.hhit.community.community.dto.QuestionDTO;
import com.hhit.community.community.mapper.QuestionMapper;
import com.hhit.community.community.mapper.UserMapper;
import com.hhit.community.community.model.Question;
import com.hhit.community.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private QuestionMapper questionMapper;
    @Autowired
    private UserMapper userMapper;


    public  PaginationDTO list(Integer page, Integer size) {
        Integer offset = size * (page - 1);//分页查询，offset=从那条数据开始，page=页码，size等于每页多少条数据
        List<Question> questions = questionMapper.list(offset, size);
        List<QuestionDTO> questionDTOList = new ArrayList<QuestionDTO>();
        PaginationDTO paginationDTO = new PaginationDTO();
        for (Question question : questions) {
            User user = userMapper.findById(question.getCreatorId());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestionDTOs(questionDTOList);
        Integer totalCount = questionMapper.count();
        paginationDTO.setPagination(totalCount,page,size);
        return paginationDTO;
    }
}
