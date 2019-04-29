package com.auto.dao;

import com.auto.domain.LoginUser;
import com.auto.domain.TaskParams;
import com.auto.util.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

public class FindTaskParams {


    public static TaskParams findTaskParamsById(int id) {
        QueryRunner queryRunner = new QueryRunner();
        try {
            return queryRunner.query(C3P0Utils.getConnection(),"select * from testtask where id = ?", new BeanHandler<TaskParams>(TaskParams.class), id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
