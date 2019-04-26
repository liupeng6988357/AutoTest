package com.auto.util;

import java.io.InputStreamReader;
import java.util.Properties;
import java.util.ResourceBundle;

public class GetValues {

    public static String getValue(String key){

        //test为属性文件名，放在包com.mmq下，如果是放在src下，直接用test即可
        Properties prop=new Properties();
        prop.load(new InputStreamReader(Client.class.getClassLoader().getResourceAsStream("config.properties"), "UTF-8"));
        String value = resource.getString(key);
        return value;
    }


    public static void main(String[] args) {
        System.out.println(getValue("username"));
    }
}
