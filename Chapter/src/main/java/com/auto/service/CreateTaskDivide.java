package com.auto.service;

import com.auto.dao.FindLoginUser;
import com.auto.util.GetValues;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;

public class CreateTaskDivide extends TestBeforeService{

    public static void login() throws InterruptedException {
        Thread.sleep(3000);
        TestBeforeService.getDriver().findElement(By.className(GetValues.getValue("teacherloginbutton"))).click();
        Thread.sleep(3000);
        WebElement username = TestBeforeService.getDriver().findElement(By.xpath(GetValues.getValue("usernameinput")));
        username.clear();
        username.sendKeys(FindLoginUser.findUserById(2).getUsername());
        WebElement password = TestBeforeService.getDriver().findElement(By.xpath(GetValues.getValue("passwordinput")));
        password.clear();
        password.sendKeys(FindLoginUser.findUserById(2).getPassword());
        TestBeforeService.getDriver().findElement(By.className(GetValues.getValue("loginbutton"))).click();
        Thread.sleep(10000);
    }
}
