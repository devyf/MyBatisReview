package com.fengye.mapper;

import com.fengye.domain.Role;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper {
    @Select("select * from sys_role r, sys_user_role ur where r.id = ur.roleId and ur.userId = #{uid}")
    List<Role> findRoleListByUid(@Param("uid") int uid);
}
