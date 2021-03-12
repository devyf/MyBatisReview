package com.fengye.mapper;

import com.fengye.domain.Customer;
import com.fengye.domain.Orders;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OrderMapper {
    /**
     * 一对一：订单对应一个客户
     * @return
     */
    @Select("select * from orders")
    @Results(value = {
            @Result(column = "id", property = "id", id = true),
            @Result(column = "ordertime", property = "orderTime"),
            @Result(column = "total", property = "total"),
            @Result(column = "price", property = "price"),
            @Result(property = "customer", one = @One(select = "com.fengye.mapper.CustomerMapper.findOneById"), column = "uid")
    })
    List<Orders> selectAll();

    @Select("select * from orders where uid = #{uid}")
    List<Orders> findByUid(@Param("uid") int id);
}
