package com.fengye.dao;

import com.fengye.domain.User;

import java.util.List;

public interface UserMapper {
    List<User> findAll();
}
