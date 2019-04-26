package com.auto.test;

import com.auto.dao.FindLoginUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateDivideClassTaskTest {

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
    public void CDCTaskNormalTest() throws InterruptedException {
        login();
        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/ul/li[2]/a[2]")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("#taskList > div.content > div > div.cardContent > div > div.tableOptions > button:nth-child(1)")).click();
        driver.findElement(By.xpath("//*[@id=\"taskList\"]/div[2]/div/" +
                "div[2]/div/div/div[1]/div/div/input")).sendKeys("123456");
        driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/ul/li[1]")).click();
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/ul/li[1]/span")).click();
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[1]/ul/li[1]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"taskList\"]/div[2]/div/div[2]/div/button")).click();
    }

    private void login() throws InterruptedException {
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
        Thread.sleep(10000);
    }

}
