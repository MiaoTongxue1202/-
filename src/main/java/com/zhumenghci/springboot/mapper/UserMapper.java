package com.zhumenghci.springboot.mapper;

import com.zhumenghci.springboot.domain.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserMapper {

    private static Map<String, User> usermap = new HashMap<>();

    static {
        usermap.put("程潇", new User(1, "程潇", "123"));
        usermap.put("成效", new User(2, "成效", "123"));
        usermap.put("承销", new User(3, "承销", "123"));

    }

    public User login(String username, String pwd){
        User user = usermap.get(username);

        if (user == null){
            return null;
        }
        if(user.getPwd().equals(pwd)){
            return user;
        }

        return null;
    }


}