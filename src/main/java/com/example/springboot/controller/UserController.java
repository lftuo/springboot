package com.example.springboot.controller;

import com.example.springboot.pojo.IMoocJSONResult;
import com.example.springboot.pojo.User;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * SpringBoot构建并返回一个json对象
 */

@RestController // @RestController= @Controller + @ResponseBody(SpringMVC方式)
//@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/getUser")
    // @ResponseBody
    private User getUser(){
        User user = new User();
        user.setName("tuotuo");
        user.setAge(26);
        user.setBirthday(new Date());
        user.setPassword("123456");
        user.setDesc("spring boot json test");
        return user;
    }

    @RequestMapping("/getUserJson")
    // @ResponseBody
    private IMoocJSONResult getUserJson(){
        User user = new User();
        user.setName("tuotuo");
        user.setAge(26);
        user.setBirthday(new Date());
        user.setPassword("123456");
        user.setDesc("spring boot json test");
        return IMoocJSONResult.ok(user);
    }
}