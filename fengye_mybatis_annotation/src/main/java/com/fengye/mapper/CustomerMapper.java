package com.fengye.mapper;

import com.fengye.domain.Customer;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CustomerMapper {
    @Select("select id, name, age, password, birthday from customer")
    List<Customer> selectCustomers();

    @Insert("insert into customer values (#{id}, #{name}, #{age}, #{password}, #{birthday})")
    int insert(Customer customer);

    @Update("update customer set name = #{name}, password = #{password} where id = #{id}")
    int update(Customer customer);

    @Delete("delete from customer where id = #{id}")
    int delete(int id);

    @Select("select * from customer where id = #{id}")
    Customer findOneById(int id);

    @Select("select * from customer")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age"),
            @Result(property = "password", column = "password"),
            @Result(property = "birthday", column = "birthday"),
            @Result(property = "ordersList", many = @Many(select = "com.fengye.mapper.OrderMapper.findByUid"),
                    column = "id", javaType = List.class)
    })
    List<Customer> selectAllList();
}
