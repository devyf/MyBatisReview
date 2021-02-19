package com.fengye.mapper;

import com.fengye.domain.User;

import java.util.List;

public interface UserMapper {
    List<User> findAll();

    User findUserById(int id);
}
