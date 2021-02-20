package com.fengye.mapper;

import com.fengye.domain.User;

import java.util.List;

public interface UserMapper {
    /**
     * 查询出所有用户及其对应的角色
     * @return
     */
    List<User> findAllUserRole();
}
