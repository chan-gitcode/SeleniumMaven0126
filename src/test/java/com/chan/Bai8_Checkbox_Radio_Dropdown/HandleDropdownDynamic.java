package com.chan.Bai8_Checkbox_Radio_Dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleDropdownDynamic {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://techydevs.com/demos/themes/html/listhub-demo/listhub/index.html");
        Thread.sleep(7000);
        driver.findElement(By.xpath("//span[normalize-space()='Select a Country']")).click();
        Thread.sleep(3000);

        //Freeze Dynamic Dropdown
        //setTimeout(() => { debugger; }, 5000);

        //Click Dropdown dynamic
        driver.findElement(By
                .xpath("//span[normalize-space()='Select a Country']/parent::a/following-sibling::div//input")).sendKeys("An");
        driver.findElement(By.xpath("//li[normalize-space()='Angola']")).click();
        Thread.sleep(2000);

        driver.quit();
    }
}
