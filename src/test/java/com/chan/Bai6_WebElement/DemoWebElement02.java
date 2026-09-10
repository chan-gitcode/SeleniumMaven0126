package com.chan.Bai6_WebElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DemoWebElement02 {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();

        //Specify the path to the Chromium binary
//        options.setBinary("'/Users/chan/chrome/mac_arm-153.0.8010.36/chrome-mac-arm64/Google Chrome for Testing.app'");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://angular-reactive-forms-zvzqvd.stackblitz.io/");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='Run this project']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("mickey@gmail.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123");
        //Submit Button
        boolean checkSubmit = driver.findElement(By
                .xpath("//body/my-app/div/div/div/form/button[1]")).isEnabled();
        System.out.println(checkSubmit);
        driver.quit();
    }
}
