package com.hhit.community.community.service;

import com.hhit.community.community.mapper.UserMapper;
import com.hhit.community.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public void insertOrUpdate(User user) {
        User dbUser = userMapper.findByAccountId(user.getAccountId());
        if (dbUser==null){
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insert(user);
        }else{
            user.setGmtModified(System.currentTimeMillis());
            userMapper.update(user);
        }
    }
}
