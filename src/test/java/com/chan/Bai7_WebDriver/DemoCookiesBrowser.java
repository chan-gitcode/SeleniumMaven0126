package com.chan.Bai7_WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DemoCookiesBrowser {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //Wait for page load/ seconds
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        //Wait after page load
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        Thread.sleep(3000);

        Cookie cookie = driver.manage().getCookieNamed("sp_session");
        System.out.println(cookie);

        System.out.println(cookie.getValue());
        System.out.println(cookie.isHttpOnly());
        System.out.println(cookie.getExpiry());

        driver.quit();
    }
}
