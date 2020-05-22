package com.zhumenghci.springboot;


import com.zhumenghci.springboot.controller.UserController;
import com.zhumenghci.springboot.domain.User;
import com.zhumenghci.springboot.utils.JsonData;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)  //底层用junit  SpringJUnit4ClassRunner
@SpringBootTest(classes={SpringbootApplication.class})//启动整个springboot工程

public class UserTest {


    @Autowired
    private UserController userController;

    @Test
    public void loginTest(){

        User user = new User();

        user.setUsername("程潇");
        user.setPwd("123");

        JsonData jsonData = userController.login(user);

        System.out.println(jsonData.toString());

        TestCase.assertEquals(0,jsonData.getCode());



    }
















}
