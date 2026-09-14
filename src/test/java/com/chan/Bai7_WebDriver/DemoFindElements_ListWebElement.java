package com.chan.Bai7_WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class DemoFindElements_ListWebElement {
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

        //List menu
        List<WebElement> listMenu = driver.findElements(By
                .xpath("//ul[@id='side-menu']/li[contains(@class,'menu-item')]"));

        int i = 0;
        for (WebElement menu : listMenu) {
            i++;
            System.out.println(i + ": " + menu.getText());
        }

        //List Sub menu Sale
        driver.findElement(By.xpath("//span[normalize-space()='Sales']")).click();
        Thread.sleep(2000);

        List<WebElement> listSubMenu = driver.findElements(By
                .xpath("//span[normalize-space()='Sales' and @class='menu-text']/parent::a/following-sibling::ul"));

        for (WebElement submenu : listSubMenu) {
            System.out.println(submenu.getText());
        }
        driver.quit();
    }
}
