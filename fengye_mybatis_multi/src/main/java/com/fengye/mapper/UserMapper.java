package com.fengye.mapper;

import com.fengye.domain.User;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    /**
     * 查询出所有用户及其对应的角色
     * @return
     */
    @Select("select * from sys_user")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "birthday", column = "birthday"),
            @Result(property = "roleList", many = @Many(select = "com.fengye.mapper.RoleMapper.findRoleListByUid"),
            column = "id", javaType = List.class)
    })
    List<User> findAllUserRole();
}
