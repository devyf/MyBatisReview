package com.fengye.service;

import com.fengye.dao.impl.UserMapperImpl;

public class ServiceDemo {
    /**
     * 传统方式实现Dao层调用
     * @param args
     */
    public static void main(String[] args) {
        //创建dao层对象，调用手动编写的dao层方法
        UserMapperImpl userMapper = new UserMapperImpl();
        userMapper.findAll();
    }
}
