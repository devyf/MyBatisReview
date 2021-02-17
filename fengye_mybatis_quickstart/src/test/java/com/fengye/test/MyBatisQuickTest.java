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

    /**
     * MyBatis CRUD测试：测试查询一条数据
     * @throws IOException
     */
    @Test
    public void testQueryOne() throws IOException {
        //加载核心配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        //获得sqlSession工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获得sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行sql语句
        User user = sqlSession.selectOne("com.fengye.domain.UserMapper.findOneById", 2);
        //打印结果
        System.out.println(user);
        //释放资源
        sqlSession.close();
    }

    /**
     * MyBatis CRUD测试：测试插入一条数据
     * @throws IOException
     */
    @Test
    public void testInsert() throws IOException {
        //加载核心配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        //获得sqlSession工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获得sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行sql语句
        User user = new User();
        user.setId(6);
        user.setUsername("lily");
        user.setPassword("7652");
        int insertId = sqlSession.insert("com.fengye.domain.UserMapper.insert", user);
        //增删改需要提交事务
        sqlSession.commit();
        //打印结果
        System.out.println(insertId);
        //释放资源
        sqlSession.close();
    }

    /**
     * MyBatis CRUD测试：测试修改一条数据
     * @throws IOException
     */
    @Test
    public void testUpdate() throws IOException {
        //加载核心配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        //获得sqlSession工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获得sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行sql语句
        User user = new User();
        user.setId(6);
        user.setUsername("mike");
        user.setPassword("1110");
        int updateId = sqlSession.update("com.fengye.domain.UserMapper.update", user);
        //增删改需要提交事务
        sqlSession.commit();
        //打印结果
        System.out.println(updateId);
        //释放资源
        sqlSession.close();
    }

    /**
     * MyBatis CRUD测试：测试删除一条数据
     * @throws IOException
     */
    @Test
    public void testdelete() throws IOException {
        //加载核心配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        //获得sqlSession工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获得sqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行sql语句
        int deleteId = sqlSession.delete("com.fengye.domain.UserMapper.deleteById", 6);
        //增删改需要提交事务
        sqlSession.commit();
        //打印结果
        System.out.println(deleteId);
        //释放资源
        sqlSession.close();
    }
}
