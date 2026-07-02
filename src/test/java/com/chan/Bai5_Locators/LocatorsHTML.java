package com.chan.Bai5_Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LocatorsHTML {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        Thread.sleep(2000);
        driver.get("https://crm.anhtester.com/authentication/login");

        driver.findElement(By.id("email")).sendKeys("admin@example.com");
        driver.findElement(By.name("password")).sendKeys("123456");

//        driver.findElement(By.tagName("button")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

        driver.quit();
    }
}
