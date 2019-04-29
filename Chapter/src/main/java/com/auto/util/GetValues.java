package com.auto.util;

import java.io.*;
import java.util.Properties;

public class GetValues {

    private static Properties prop;

    public static String getValue(String key){

        prop=new Properties();

        try {
            prop.load(new InputStreamReader(new BufferedInputStream(new FileInputStream("D:\\AutoTestSpace\\AutoTest\\Chapter\\src\\main\\resources\\test.properties")),"utf-8"));
        }catch (Exception e){
            e.fillInStackTrace();
        }

        return prop.getProperty(key);
    }


    public static void main(String[] args) {
        System.out.println(getValue("passwordinput"));
    }
}
