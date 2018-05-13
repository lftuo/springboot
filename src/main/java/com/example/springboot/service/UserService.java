package com.example.springboot.service;

import com.example.springboot.pojo.SysUser;

import java.util.List;

public interface UserService {

    public void saveUser(SysUser user) throws Exception;

    public void updateUser(SysUser user);

    public void deleteUser(String userId);

    public SysUser queryUserById(String userId);

    public List<SysUser> queryUserList(SysUser user);

    List<SysUser> queryUserListPaged(SysUser user, Integer page, int pageSize);

    /*public List<SysUser> queryUserListPaged(SysUser user, Integer page, Integer pageSize);

    public SysUser queryUserByIdCustom(String userId);

    public void saveUserTransactional(SysUser user);*/
}
