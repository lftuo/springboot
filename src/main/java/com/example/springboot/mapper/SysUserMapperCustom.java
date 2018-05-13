package com.example.springboot.mapper;

import com.example.springboot.pojo.SysUser;
import com.example.springboot.utils.MyMapper;

import java.util.List;

public interface SysUserMapperCustom extends MyMapper<SysUser> {
    List<SysUser> queryUserSimpleInfoById(String id);
}