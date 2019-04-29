package com.auto.service;

import com.auto.util.GetValues;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBeforeService{

    private static String path = GetValues.getValue("testchenzhi");
    private static WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(){
        driver = new ChromeDriver();
        System.setProperty(GetValues.getValue("webdriver"),GetValues.getValue("driverpath"));
        driver.get(path);
    }
    @AfterMethod(alwaysRun = true)
    public void afterTest(){
        driver.close();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
