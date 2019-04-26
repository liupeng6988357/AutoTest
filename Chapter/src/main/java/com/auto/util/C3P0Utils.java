package com.auto.util;

import com.auto.exception.MyError;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.sql.*;

public class C3P0Utils {

    //static org.apache.log4j.Logger logger=org.apache.log4j.Logger.getLogger(C3P0Utils.class.getName());

    //通过标识名来创建相应连接池
    static ComboPooledDataSource dataSource=new ComboPooledDataSource("c3p0-config");
    //从连接池中取用一个连接
    public static Connection getConnection() throws MyError {
        try {
            return dataSource.getConnection();

        } catch (Exception e) {
           // logger.error("Exception in C3p0Utils!", e);
            throw new MyError("数据库连接出错!", e);
        }
    }
}
