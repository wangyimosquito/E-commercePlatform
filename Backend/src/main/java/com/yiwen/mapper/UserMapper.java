package com.yiwen.mapper;

import com.yiwen.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> selectAll();

    User selectById();
}
