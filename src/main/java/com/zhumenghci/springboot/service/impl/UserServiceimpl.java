package com.zhumenghci.springboot.service.impl;

import com.zhumenghci.springboot.domain.User;
import com.zhumenghci.springboot.mapper.UserMapper;
import com.zhumenghci.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class UserServiceimpl implements UserService {

    private static Map<String,User> stringUserMap = new HashMap<>();

    @Autowired
    private UserMapper userMapper;

    @Override
    public String login(String username, String pwd) {

        User user = userMapper.login(username,pwd);

        if(user==null){
            return null;
        }else {
            String token =  UUID.randomUUID().toString();
            System.out.println(token);
            stringUserMap.put(token,user);
            return token;
        }
    }

    @Override
    public List<User> USER_LIST() {
        return userMapper.userList();
    }
}
