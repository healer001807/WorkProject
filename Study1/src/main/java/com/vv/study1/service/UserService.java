package com.vv.study1.service;

import com.vv.study1.mapper.UserMapper;
import com.vv.study1.pojo.dto.UserDto;

import java.util.List;

/**
 * @author kw
 * @program WorkProject
 * @description
 * @create 2024 - 03 - 24 22:19
 **/
public class UserService {

    private UserMapper userMapper;

    public List<UserDto> getListUser() {
        return userMapper.selectListByExample(null);
    }
}
