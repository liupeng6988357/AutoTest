package com.auto.test;


import com.auto.dao.FindLoginUser;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestLogin {

    private static String path = "http://test.91chenzhi.cn/";
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(path);
    }
    @AfterMethod(alwaysRun = true)
    public void afterTest(){
        driver.close();
    }

    @Test
    public void loginTestNormal() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.className("loginBtn")).click();
        Thread.sleep(3000);
        WebElement username = driver.findElement(By.xpath("//input[@placeholder='手机号']"));
        username.clear();
        username.sendKeys(FindLoginUser.findUserById(2).getUsername());
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='密码']"));
        password.clear();
        password.sendKeys(FindLoginUser.findUserById(2).getPassword());
        driver.findElement(By.className("t_btn")).click();
        Thread.sleep(5000);
    }

    @Test
    public void loginTestPasswordException() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.className("loginBtn")).click();
        Thread.sleep(3000);
        WebElement username = driver.findElement(By.xpath("//input[@placeholder='手机号']"));
        username.clear();
        username.sendKeys(FindLoginUser.findUserById(3).getUsername());
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='密码']"));
        password.clear();
        password.sendKeys(FindLoginUser.findUserById(3).getPassword());
        driver.findElement(By.className("t_btn")).click();
        Thread.sleep(3000);
        try {
            driver.findElement(By.xpath("//input[@placeholder='手机号']"));
        }catch(NoSuchElementException e){
            throw new NoSuchElementException("密码错误可以登录");
        }

    }


    @Test
    public void loginTestUsernameException() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.className("loginBtn")).click();
        Thread.sleep(3000);
        WebElement username = driver.findElement(By.xpath("//input[@placeholder='手机号']"));
        username.clear();
        username.sendKeys(FindLoginUser.findUserById(4).getUsername());
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='密码']"));
        password.clear();
        password.sendKeys(FindLoginUser.findUserById(4).getPassword());
        driver.findElement(By.className("t_btn")).click();
        Thread.sleep(3000);
        try {
            driver.findElement(By.xpath("//input[@placeholder='手机号']"));
        }catch(NoSuchElementException e){
            throw new NoSuchElementException("用户名错误可以登录");
        }

    }

}

