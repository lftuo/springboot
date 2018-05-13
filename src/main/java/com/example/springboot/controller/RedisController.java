package com.example.springboot.controller;

import com.example.springboot.pojo.IMoocJSONResult;
import com.example.springboot.pojo.SysUser;
import com.example.springboot.pojo.User;
import com.example.springboot.utils.JsonUtils;
import com.example.springboot.utils.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisOperator redisOperator;

    @RequestMapping("test")
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

    @RequestMapping("getJsonList")
    public IMoocJSONResult getJsonList(){
        User user1 = new User();
        user1.setAge(10);
        user1.setName("zhangsan");
        user1.setPassword("123456");
        user1.setBirthday(new Date());

        User user2 = new User();
        user2.setAge(16);
        user2.setName("lisi");
        user2.setPassword("123476");
        user2.setBirthday(new Date());

        List<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);

        redisOperator.set("json:info:userlist", JsonUtils.objectToJson(users),2000);
        String userListJson = redisOperator.get("json:info:userlist");
        List<User> userListJsonBorn = JsonUtils.jsonToList(userListJson,User.class);

        return IMoocJSONResult.ok(userListJsonBorn);

    }
}
