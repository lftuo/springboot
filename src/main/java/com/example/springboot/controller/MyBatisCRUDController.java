package com.example.springboot.controller;

import com.example.springboot.pojo.IMoocJSONResult;
import com.example.springboot.pojo.SysUser;
import com.example.springboot.service.UserService;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("mybatis")
public class MyBatisCRUDController {

    @Autowired
    private UserService userService;

    @Autowired
    private Sid sid;

    @RequestMapping("/saveUser")
    public IMoocJSONResult saveUser() throws Exception {

        SysUser user = new SysUser();
        String userID = sid.nextShort();
        user.setId(userID);
        user.setUserName("tuotuo" + new Date());
        user.setNickname("tuotuo" + new Date());
        user.setPassword("123456");
        user.setIsDelete(0);
        user.setRegistTime(new Date());

        userService.saveUser(user);
        return IMoocJSONResult.ok("保存成功");
    }

    @RequestMapping("/updateUser")
    public IMoocJSONResult updateUser(){
        SysUser user = new SysUser();
        user.setId("10011001");
        user.setUserName("10011001-updated" + new Date());
        user.setNickname("10011001-updated" + new Date());
        user.setPassword("10011001-updated");
        user.setIsDelete(0);
        user.setRegistTime(new Date());

        userService.updateUser(user);
        return IMoocJSONResult.ok("修改成功");
    }

    @RequestMapping("/deleteUser")
    public IMoocJSONResult deleteUser(String userId){
        userService.deleteUser(userId);
        return IMoocJSONResult.ok("删除成功");
    }

    @RequestMapping("/queryUserById")
    public IMoocJSONResult queryUserById(String userId){
        return IMoocJSONResult.ok(userService.queryUserById(userId));
    }

    @RequestMapping("/queryUserList")
    public IMoocJSONResult queryUserList(){
        SysUser user = new SysUser();
        user.setUserName("imooc");
        user.setNickname("lee");

        List<SysUser> userList = userService.queryUserList(user);
        return IMoocJSONResult.ok(userList);

    }

    @RequestMapping("/queryUserListPaged")
    public IMoocJSONResult queryUserListPaged(Integer page){

        if (page == null){
            page = 1;
        }

        int pageSize = 10;
        SysUser user = new SysUser();
        List<SysUser> users = userService.queryUserListPaged(user,page,pageSize);
        return IMoocJSONResult.ok(users);

    }

    @RequestMapping("/queryUserByIdCustom")
    public IMoocJSONResult queryUserByIdCustom(String id){
        SysUser user = userService.queryUserByIdCustom(id);
        return IMoocJSONResult.ok(user);
    }

    @RequestMapping("/saveUserTransactional")
    public IMoocJSONResult saveUserTransactional(){
        String userId = sid.nextShort();

        SysUser user = new SysUser();
        user.setId(userId);
        user.setUserName("tuo " + new Date());
        user.setNickname("tuo " + new Date());
        user.setPassword("abc123");
        user.setIsDelete(0);
        user.setRegistTime(new Date());

        userService.saveUserTransactional(user);

        return IMoocJSONResult.ok("保存成功");
    }
}
