package com.fengye.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MyBatisUtil {
    private static SqlSessionFactory sqlSessionFactory = null;
    private static Reader reader = null;

    // 因为sqlSessionFactory是线程安全的，每次初始化只需要创建一个SqlSessionFactory实例
    static {
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // SqlSession是线程不安全的类，每个线程内单独去获取当前线程的SqlSession
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }

    // 关闭SqlSession
    public static void closeSqlSession(SqlSession sqlSession){
        if(sqlSession != null){
            sqlSession.close();
        }
    }
}
