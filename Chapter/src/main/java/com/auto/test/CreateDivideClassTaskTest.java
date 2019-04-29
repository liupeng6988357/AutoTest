package com.auto.test;


import com.auto.dao.FindTaskParams;
import com.auto.service.CreateTaskDivide;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class CreateDivideClassTaskTest extends CreateTaskDivide {
  //  private WebDriver driver = CreateTaskDivide.getDriver();

    /**
     *
     * @throws InterruptedException
     */
    @Test
    public void CDCTaskNormalTest() throws InterruptedException {

        CreateTaskDivide.login();
        WebDriver driver = CreateTaskDivide.getDriver();
        driver.findElement(By.linkText("分班")).click();
        Thread.sleep(5000);
        driver.switchTo().frame("iframe");
        List<WebElement> elementes = driver.findElements(By.className("mainBtn"));
        elementes.get(0).click();
        Thread.sleep(5000);
        WebElement taskname = driver.findElement(By.className("el-input__inner"));
        taskname.clear();
        Thread.sleep(3000);
        taskname.sendKeys(FindTaskParams.findTaskParamsById(1).getTaskname());
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id='select1']")).click();
        driver.findElement(By.xpath("//div[3]/div/div/ul/li/span")).click();
        driver.findElement(By.id("select1")).click();
        driver.findElement(By.xpath("(//input[@type='text'])[3]")).click();
        Thread.sleep(50000);
    }



}
