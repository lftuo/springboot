package com.example.springboot.controller;

import com.example.springboot.pojo.IMoocJSONResult;
import com.example.springboot.pojo.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private Resource resource;

    @RequestMapping("/hello")
    private String index(){
        return "Hello World!";
    }

    @RequestMapping("/getResource")
    public IMoocJSONResult getResource(){
        Resource bean = new Resource();
        BeanUtils.copyProperties(resource, bean);
        return IMoocJSONResult.ok(bean);
    }
}