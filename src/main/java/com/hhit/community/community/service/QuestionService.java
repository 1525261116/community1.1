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


    public PaginationDTO list(Integer page, Integer size) {
        Integer totalCount = questionMapper.count();//查询数据库中数据条数
        if (totalCount == 0) {
            return null;
        }
        Integer totalPage;
        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = (totalCount / size) + 1;
        }
        if (page < 1) {
            page = 1;
        } else if (page > totalPage) {
            page = totalPage;
        }
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
        paginationDTO.setPagination(totalPage, page, size);
        return paginationDTO;
    }

    public PaginationDTO listByUserId(Integer userId, Integer page, Integer size) {
        Integer totalCount = questionMapper.countByUserId(userId);//查询数据库中数据条数
        if (totalCount == 0) {
            return null;
        }
        Integer totalPage;//总页数
        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = (totalCount / size) + 1;
        }
        if (page < 1) {
            page = 1;
        } else if (page > totalPage) {
            page = totalPage;
        }
        Integer offset = size * (page - 1);//分页查询，offset=从那条数据开始，page=页码，size等于每页多少条数据

        List<Question> questions = questionMapper.listByUserId(userId, offset, size);
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
        paginationDTO.setPagination(totalPage, page, size);
        return paginationDTO;


    }

    public QuestionDTO findById(Integer id) {
        Question question = questionMapper.findById(id);
        User user = userMapper.findById(question.getCreatorId());
        QuestionDTO questionDTO = new QuestionDTO();
        BeanUtils.copyProperties(question, questionDTO);
        questionDTO.setUser(user);
        return questionDTO;
    }
}
