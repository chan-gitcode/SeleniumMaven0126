package com.chan.Bai11_Assert;

import com.chan.common.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class demoHardAssert extends BaseTest {
    @Test
    public void testHardAssert() throws InterruptedException {
        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        Thread.sleep(2000);
        Assert.assertEquals(driver.getCurrentUrl(),"https://crm.anhtester.com/admin/","URL error");
        try {
            driver.findElement(By.xpath("//li[@class='icon header-user-profile']")).isDisplayed();
        } catch (Exception e){
            Assert.fail("Profile image not displayed "+ e.getMessage());
        }
    }
}
