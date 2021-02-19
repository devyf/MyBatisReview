package com.fengye.mapper;

import com.fengye.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class UserMapperTest {

    /**
     * 测试Mapper.xml中配置动态sql的if语句
     */
    @Test
    public void test01() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User condition = new User();
        //condition.setId(2);
        //condition.setUsername("俊杰");
        condition.setPassword("232");
        List<User> userList = userMapper.findByCondition(condition);
        System.out.println(userList);
    }

    /**
     * 测试Mapper.xml中配置动态sql的foreach语句1
     * 集合List查询
     */
    @Test
    public void test02() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<Integer> list = Arrays.asList(1, 2, 4);
        List<User> userList = userMapper.findByIdList(list);
        System.out.println(userList);
    }

    /**
     * 测试Mapper.xml中配置动态sql的foreach语句2
     * 数组Arrays查询
     */
    @Test
    public void test03() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int[] arr = new int[]{1, 3, 4};
        List<User> userList = userMapper.findByIdArrays(arr);
        System.out.println(userList);
    }
}
