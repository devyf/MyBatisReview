package com.fengye.mapper;

import com.fengye.domain.Customer;
import com.fengye.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class CustomerMappperTest {
    CustomerMapper mapper = null;
    SqlSession sqlSession = null;
    @Before
    public void before(){
        sqlSession = MyBatisUtil.getSqlSession();
        mapper = sqlSession.getMapper(CustomerMapper.class);
    }

    @After
    public void after(){
        sqlSession.commit(true);
    }

    @Test
    public void test01(){
        List<Customer> customerList = mapper.selectCustomers();
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
    }

    @Test
    public void test02(){
        Customer customer = new Customer();
        customer.setId(7);
        customer.setName("测试");
        customer.setBirthday(new Date());
        customer.setAge(10);
        customer.setPassword("33324");
        mapper.insert(customer);
    }

    @Test
    public void test03(){
        Customer customer = new Customer();
        customer.setId(7);
        customer.setName("修改数据");
        customer.setBirthday(new Date());
        customer.setPassword("1111");
        mapper.update(customer);
    }

    @Test
    public void test04(){
        mapper.delete(7);
    }

    @Test
    public void test05(){
        List<Customer> customers = mapper.selectAllList();
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

}
