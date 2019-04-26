package com.auto.dao;

import com.auto.domain.LoginUser;
import com.auto.util.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class FindLoginUser {

    public static LoginUser findUserById(int id) {
        QueryRunner queryRunner = new QueryRunner();
        try {
            return queryRunner.query(C3P0Utils.getConnection(),"select * from logintest where caseid = ?", new BeanHandler<LoginUser>(LoginUser.class), id);
        } catch (Exception e) {
            e.printStackTrace();
            }
            return null;
        }
}

