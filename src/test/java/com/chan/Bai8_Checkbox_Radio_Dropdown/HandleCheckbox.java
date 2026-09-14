package com.chan.Bai8_Checkbox_Radio_Dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HandleCheckbox {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        Thread.sleep(3000);

        driver.findElement(By.xpath("//a[normalize-space()='Tasks']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='New Task']")).click();
        //Public checkbox
        boolean checkboxPublic = driver.findElement(By.xpath("//input[@id='task_is_public']")).isSelected();
        System.out.println(checkboxPublic);

        //Handle multi checkbox
        List<WebElement> multicheckboxes = driver.findElements(By
                .xpath("//form[@id='task-form']//div[contains(@class,'task-add-edit')]//input"));
        System.out.println("Total multi checkbox = " + multicheckboxes.size());

        for (int i = 0; i<multicheckboxes.size();i++){
            System.out.println(multicheckboxes.get(i).isSelected());
        }

        driver.quit();
    }
}
