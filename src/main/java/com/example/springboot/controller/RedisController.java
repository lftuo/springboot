package com.example.springboot.controller;

import com.example.springboot.pojo.IMoocJSONResult;
import com.example.springboot.pojo.SysUser;
import com.example.springboot.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/test")
    public IMoocJSONResult test(){

        //stringRedisTemplate.opsForValue().set("hello-mybatis","hello-tuotuo");

        SysUser user = new SysUser();
        user.setId("100001");
        user.setUserName("tuotuo");
        user.setNickname("tuotuo");
        user.setPassword("123456");
        user.setIsDelete(0);
        user.setRegistTime(new Date());
        stringRedisTemplate.opsForValue().set("json:user",JsonUtils.objectToJson(user));

        SysUser sysUser = JsonUtils.jsonToPojo(stringRedisTemplate.opsForValue().get("json:user"),SysUser.class);

        return IMoocJSONResult.ok(sysUser);
    }

}
