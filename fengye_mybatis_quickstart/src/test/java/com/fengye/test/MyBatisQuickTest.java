package com.fengye.test;

import com.fengye.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisQuickTest {
    /**
     * MyBatis环境搭建测试：测试查询语句
     * @throws IOException
     */
    @Test
    public void test1() throws IOException {
        //加载核心配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        //获得sqlSession工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获得sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行sql语句
        List<User> users = sqlSession.selectList("com.fengye.domain.UserMapper.findAll");
        //打印结果
        System.out.println(users);
        //释放资源
        sqlSession.close();
    }
}
