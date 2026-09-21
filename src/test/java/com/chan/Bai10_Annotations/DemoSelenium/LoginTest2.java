package com.chan.Bai10_Annotations.DemoSelenium;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTest2 extends BaseTest{
    @Test
    public void testLoginSuccess() {

        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
    }
}
