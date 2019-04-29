package com.auto.test;


import com.auto.dao.FindLoginUser;
import com.auto.service.TestBeforeService;
import com.auto.util.GetValues;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LgoinTest extends TestBeforeService {

    /**
     * 用户名和密码正确验证是否可以正确登陆
     * @throws InterruptedException
     */
    @Test
    public void loginTestNormal() throws InterruptedException {
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
        Thread.sleep(5000);
    }

    /**
     * 测试密码错误是否可以正常登陆
     * @throws InterruptedException
     */
    @Test
    public void loginTestPasswordException() throws InterruptedException {
        Thread.sleep(3000);
        TestBeforeService.getDriver().findElement(By.className(GetValues.getValue("teacherloginbutton"))).click();
        Thread.sleep(3000);
        WebElement username = TestBeforeService.getDriver().findElement(By.xpath(GetValues.getValue("usernameinput")));
        username.clear();
        username.sendKeys(FindLoginUser.findUserById(3).getUsername());
        WebElement password = TestBeforeService.getDriver().findElement(By.xpath(GetValues.getValue("passwordinput")));
        password.clear();
        password.sendKeys(FindLoginUser.findUserById(3).getPassword());
        TestBeforeService.getDriver().findElement(By.className(GetValues.getValue("loginbutton"))).click();
        Thread.sleep(3000);
        try {
            TestBeforeService.getDriver().findElement(By.xpath(GetValues.getValue("passwordinput")));
        }catch(NoSuchElementException e){
            throw new NoSuchElementException("密码错误可以登录");
        }

    }

    /**
     * 测试用户名错误是否可以正常登陆
     * @throws InterruptedException
     */
    @Test
    public void loginTestUsernameException() throws InterruptedException {
        Thread.sleep(3000);
        TestBeforeService.getDriver().findElement(By.className(GetValues.getValue("teacherloginbutton"))).click();
        Thread.sleep(3000);
        WebElement username = TestBeforeService.getDriver().findElement(By.xpath(GetValues.getValue("usernameinput")));
        username.clear();
        username.sendKeys(FindLoginUser.findUserById(4).getUsername());
        WebElement password = TestBeforeService.getDriver().findElement(By.xpath(GetValues.getValue("passwordinput")));
        password.clear();
        password.sendKeys(FindLoginUser.findUserById(4).getPassword());
        TestBeforeService.getDriver().findElement(By.className(GetValues.getValue("loginbutton"))).click();
        Thread.sleep(3000);
        try {
            TestBeforeService.getDriver().findElement(By.xpath(GetValues.getValue("usernameinput")));
        }catch(NoSuchElementException e){
            throw new NoSuchElementException("用户名错误可以登录");
        }

    }

}

