package com.chan.Bai8_Checkbox_Radio_Dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class HandleRadio {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.id("email")).sendKeys("admin@example.com");
        driver.findElement(By.name("password")).sendKeys("123456");
        driver.findElement(By.tagName("button")).click();

        driver.findElement(By.xpath("//span[@class='menu-text'][normalize-space()='Sales']")).click();
        driver.findElement(By.xpath("//span[normalize-space()='Proposals']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='New Proposal']")).click();
        Thread.sleep(2000);

        //Cuon chuot den cuoi trang
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        //Select Radio
        driver.findElement(By.xpath("//label[normalize-space()='Hours']")).click();
        //Check radiobutton is selected
        boolean radioIsSelect = driver.findElement(By
                .xpath("//label[normalize-space()='Hours']/preceding-sibling::input")).isSelected();
        System.out.println("Radio Hours AFTER is selected: " + radioIsSelect);

        //Select Multiple Radio
        List<WebElement> multiRadioSelect = driver
                .findElements(By.xpath("//div[contains(@class,'radio-primary')]//input"));
        int count = 0;
        for (int i = 0; i < multiRadioSelect.size(); i++) {
            System.out.println("Radio value "+(i)+": "+ multiRadioSelect.get(i).isSelected());
            boolean radioSelectedCheck = multiRadioSelect.get(i).isSelected();
            if (radioSelectedCheck) {
                count++;
            }
        }
        if (count == 1) {
            System.out.println("Pass");
        } else {
            System.out.println("Fail");
        }

        driver.quit();
    }
}
