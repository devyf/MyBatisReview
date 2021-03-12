package com.fengye.mapper;

import com.fengye.domain.Order;
import com.fengye.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserMapperTest {
    UserMapper userMapper = null;

    @Before
    public void before() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void findAllTest(){
        List<User> userList = userMapper.findAllUserRole();
        System.out.println(userList);
    }

    @Test
    public void manyTomany(){
        List<User> userList = userMapper.findAllUserRole();
        for (User user : userList) {
            System.out.println(user);
        }
    }
}
