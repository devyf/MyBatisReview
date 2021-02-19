package com.fengye.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class DateTypeHandler extends BaseTypeHandler<Date> {

    //将<T>对应的类型Date转换成数据库需要的类型long
    public void setNonNullParameter(PreparedStatement preparedStatement, int index, Date date, JdbcType jdbcType) throws SQLException {
        long dateTime = date.getTime();
        preparedStatement.setLong(index, dateTime);
    }

    //用于将数据库中查询出的数据类型转换成<T>对应的类型Date
    public Date getNullableResult(ResultSet resultSet, String column) throws SQLException {
        long aLong = resultSet.getLong(column);
        return new Date(aLong);
    }

    //用于将数据库中查询出的数据类型转换成<T>对应的类型Date
    public Date getNullableResult(ResultSet resultSet, int i) throws SQLException {
        long aLong = resultSet.getLong(i);
        return new Date(aLong);
    }

    //用于将数据库中查询出的数据类型转换成<T>对应的类型Date
    public Date getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        long aLong = callableStatement.getLong(i);
        return new Date(aLong);
    }
}
