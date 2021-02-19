package com.fengye.test;

import com.fengye.domain.User;
import com.fengye.mapper.UserMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class UserMapperTest {

    @Test
    public void test01() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(5);
        user.setUsername("李强");
        user.setPassword("18632");
        user.setBirthday(new Date());
        userMapper.insertData(user);
    }

    /**
     * 测试分页代码实现
     * @throws IOException
     */
    @Test
    public void test02() throws IOException {
        //设置分页参数
        PageHelper.startPage(2, 3);

        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = userMapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
        //获取分页相关其它参数:需要传入查询到的List数据
        PageInfo<User> pageInfo = new PageInfo<User>(userList);
        System.out.println("总条数："+pageInfo.getTotal());
        System.out.println("总页数："+pageInfo.getPages());
        System.out.println("当前页："+pageInfo.getPageNum());
        System.out.println("每页显示长度："+pageInfo.getPageSize());
        System.out.println("是否第一页："+pageInfo.isIsFirstPage());
        System.out.println("是否最后一页："+pageInfo.isIsLastPage());
    }
}
