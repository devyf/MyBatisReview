package com.fengye.mapper;

import com.fengye.domain.User;

import java.util.List;

public interface UserMapper {
    //模拟自定义类型转换器向数据库中插入一条Date转换成毫秒值存入数据库
    public void insertData(User user);

    //分页数据查询
    public List<User> findAll();

}
