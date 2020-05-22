package com.zhumenghci.springboot.controller;

import com.zhumenghci.springboot.domain.User;
import com.zhumenghci.springboot.service.UserService;
import com.zhumenghci.springboot.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/pub/user")
public class UserController {

//    @PostMapping("login")
//    public JsonData login(String pwd,String username){
//
//        System.out.println("username=" + username + "pwd=" + pwd);
//
//        return JsonData.buildSuccess("");
//    }

    @Autowired
    private UserService userService;

    @PostMapping("login")
    public JsonData login(@RequestBody User user){

        System.out.println("user="+user.toString());

        String token = userService.login(user.getUsername(),user.getPwd());

        return token !=null ? JsonData.buildSuccess(token): JsonData.buildError("账号密码错误");
    }
}
