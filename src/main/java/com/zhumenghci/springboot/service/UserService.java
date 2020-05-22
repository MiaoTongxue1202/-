package com.zhumenghci.springboot.service;

import com.zhumenghci.springboot.domain.User;

import java.util.List;

public interface UserService {

    String login(String username, String pwd);

    List<User> USER_LIST();
}
