package com.fengye.mapper;

import com.fengye.domain.Order;

import java.util.List;

public interface OrderMapper {
    //查询出所有订单，并一并查询出订单对应的用户
    List<Order> findAll();
}
