package io.loop.homeworks.day7_practice;

import io.loop.test.base.TestBase;
import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.DocuportUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

/*
=============
go to https://demoqa.com/alerts
1 -> click - click button to see alert
handle alert

2 -> click - On button click, alert will appear after 5 seconds
handle alert

3 -> click - On button click, confirm box will appear
click ok and validate - You selected Ok
after that do it again this time cancel and validate - You selected Cancel

4 -> click - On button click, prompt box will appear
enter "Loop Academy" and validate You entered Loop Academy
 */
public class T2_Alerts extends TestBase {
    @Test
    public void alertInformation(){
    driver.get("https://demoqa.com/alerts");
        WebElement alertButton = driver.findElement(By.xpath("//button[@id='alertButton']"));
        alertButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    @Test
    public void lateAlert() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        WebElement clickMe = driver.findElement(By.xpath("//button[@id='timerAlertButton']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", clickMe);
        clickMe.click();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(7000);
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @Test
    public void alertConfirmation(){
        driver.get("https://demoqa.com/alerts");
        WebElement clickMe = driver.findElement(By.xpath("//button[@id='confirmButton']"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", clickMe);
        clickMe.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        WebElement successMessage = driver.findElement(By.xpath("//span[@id='confirmResult']"));
        String expected = "You selected Ok";
        String actual = successMessage.getText();
        assertEquals(actual, expected, " Actual does not match expected");

        clickMe.click();
        driver.switchTo().alert().dismiss();
        expected = "You selected Cancel";
        actual = successMessage.getText();
        assertEquals(actual, expected, " Actual does not match expected");

    }

    @Test
    public void alertPrompt(){
        driver.get("https://demoqa.com/alerts");
        WebElement clickMe = driver.findElement(By.xpath("//button[@id='promtButton']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", clickMe);
        clickMe.click();

        String text = "Loop Academy";

        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();
        WebElement successMessage = driver.findElement(By.xpath("//span [@id='promptResult']"));
        String expected = "You entered " + text;
        String actual = successMessage.getText();
        assertEquals(actual, expected, "Actual does ot match expected");
    }
}
