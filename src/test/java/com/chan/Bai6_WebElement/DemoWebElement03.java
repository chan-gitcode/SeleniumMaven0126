package com.chan.Bai6_WebElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoWebElement03 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        String result = driver.findElement(By
                .xpath("//div[normalize-space()='Invoices Awaiting Payment']/following-sibling::span")).getText();
        driver.findElement(By.xpath("//a[normalize-space()='Projects']")).click();
        driver.findElement(By.xpath("//table[@id = 'projects']/tbody/tr[1]/td[3]")).click();
        System.out.println(result);
        driver.quit();
    }
}
