package com.chan.Bai12_Action_Robot_Class.ActionsClass;

import com.chan.common.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class TestActionsClass extends BaseTest {
    @Test
    public void testSendKeys() throws InterruptedException {
        driver.get("https://cms.anhtester.com/");

        driver.findElement(By.xpath("//i[@class='la la-close fs-20']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='Ok. I Understood']")).click();

        //Input search
        WebElement element = driver.findElement(By.xpath("//input[@id='search']"));

        //Tạo đối tượng của Actions class và để driver vào
        Actions action = new Actions(driver);

        //Dùng action để gọi hàm sendKeys điền dữ liệu. Không dùng sendKeys của WebElement
        action.click(element).perform();
        Thread.sleep(2000);
        action.sendKeys(element, "Giày nam").perform();
        action.sendKeys(Keys.ENTER).perform();

        Thread.sleep(2000);
    }

    @Test
    public void moveToElement() throws InterruptedException {
        driver.get("https://anhtester.com/");
        Thread.sleep(2000);
        WebElement element = driver.findElement(By
                .xpath("//h1[normalize-space()='Anh TesterAutomation Testing']"));

        Actions action = new Actions(driver);

        //Move to element (di chuyển tới title Kiến thức Automation Testing)
        action.moveToElement(element).perform();
        Thread.sleep(2000);
        action.moveToElement(driver.findElement(By
                .xpath("//a[normalize-space()='Đăng nhập']"))).perform();

        Thread.sleep(2000);
    }

    @Test
    public void demoDragAndDropWithActionClass() throws InterruptedException {
        driver.get("https://www.lambdatest.com/selenium-playground/drag-and-drop-demo");
        Thread.sleep(1000);

        // Bắt element cần kéo
        WebElement elementFrom1 = driver.findElement(By.xpath("//span[normalize-space()='Draggable 1']"));
        WebElement elementFrom2 = driver.findElement(By.xpath("//span[normalize-space()='Draggable 2']"));
        // Bắt element cần thả đến
        WebElement elementTo = driver.findElement(By.xpath("//div[@id='mydropzone']"));

        Thread.sleep(1000);
        Actions action = new Actions(driver);
        // Kéo và thả
        action.dragAndDrop(elementFrom1, elementTo).perform();
        Thread.sleep(1000);
        action.dragAndDrop(elementFrom2, elementTo).perform();

        Thread.sleep(2000);
    }
}
