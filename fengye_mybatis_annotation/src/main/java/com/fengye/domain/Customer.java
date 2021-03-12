package com.fengye.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Customer {
    private int id;
    private String name;
    private int age;
    private String password;
    private Date birthday;
    /**
     * 查询顾客及其所有订单
     */
    private List<Orders> ordersList;
}
