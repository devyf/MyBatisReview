package com.fengye.mapper;

import com.fengye.domain.Orders;
import com.fengye.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class OrdersMapperTest {
    OrderMapper mapper = null;
    SqlSession sqlSession = null;
    @Before
    public void before(){
        sqlSession = MyBatisUtil.getSqlSession();
        mapper = sqlSession.getMapper(OrderMapper.class);
    }

    @After
    public void after(){
        sqlSession.commit(true);
    }

    @Test
    public void oneToOne(){
        List<Orders> orders = mapper.selectAll();
        for (Orders order : orders) {
            System.out.println(order);
        }
    }
}
