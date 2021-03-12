package com.fengye.domain;

import lombok.Data;

@Data
public class Orders {
    private int id;

    private String orderTime;

    private int total;

    private double price;

    private Customer customer; //一个订单从属于一个用户
}
