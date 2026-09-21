package com.chan.Bai11_Assert;

import com.chan.common.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DemoSoftAssert extends BaseTest {
    @BeforeClass
    public void setUp(){
        softAssert = new SoftAssert();
    }
    @AfterClass
    public void tearDown(){
        softAssert.assertAll();
    }

    @Test
    public void testSoftAssert() throws InterruptedException {
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

        driver.findElement(By.xpath("//span[normalize-space()='Customers']")).click();

        try {
            driver.findElement(By.xpath("//span[normalize-space()='Customers Summary']")).isDisplayed();
        }catch (Exception e){
            Assert.fail("No Customers Summary text found " + e.getMessage());
        }
    }
}
