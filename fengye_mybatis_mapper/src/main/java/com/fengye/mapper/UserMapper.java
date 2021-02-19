package com.fengye.mapper;

import com.fengye.domain.User;

import java.util.List;

public interface UserMapper {

    public List<User> findByCondition(User user);

    public List<User> findByIdList(List<Integer> idList);

    public List<User> findByIdArrays(int[] arr);
}
