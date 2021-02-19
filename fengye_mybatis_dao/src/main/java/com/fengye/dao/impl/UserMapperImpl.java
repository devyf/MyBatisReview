package com.fengye.dao.impl;

import com.fengye.dao.UserMapper;
import com.fengye.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserMapperImpl implements UserMapper {
    public List<User> findAll() {
        //加载核心配置文件
        InputStream inputStream = null;
        SqlSession sqlSession = null;
        try {
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            //获得sqlSession工厂对象
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //获得sqlSession对象
             sqlSession = sqlSessionFactory.openSession();
            //执行sql语句
            List<User> users = sqlSession.selectList("com.fengye.domain.UserMapper.findAll");
            //打印结果
            System.out.println(users);
            return users;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //释放资源
            if(sqlSession != null){
                sqlSession.close();
            }
        }
        return null;
    }
}
