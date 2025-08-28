package io.loop.homeworks.day8_practice;

import io.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Set;

import static org.testng.Assert.assertEquals;

/*
task3
=============
    1. go to https://loopcamp.vercel.app/
    2. click "Multiple Windows" link
    3. Validate "Powered by Loopcamp" is displayed
    4. Validate title is "Windows"
    5. Click - click here
    6. Switch to new window and validate title
 */
public class T3_Multiple_Windows extends TestBase {

    @Test
    public void windowHandles(){
        driver.get("https://loopcamp.vercel.app/");

        //    2. click "Multiple Windows" link
        WebElement multipleWindow = driver.findElement(By.xpath("//a[text()='Multiple Windows']"));
        multipleWindow.click();

        //    3. Validate "Powered by Loopcamp" is displayed
        WebElement powerByLoopcamp = driver.findElement(By.xpath("//div[@style='text-align: center;']"));
       if (powerByLoopcamp.isDisplayed()) {
           System.out.println("Powered by Loopcamp is visible");
       }else {
           System.out.println("Powered by Loopcamp is not visible");
       };
       //     4. Validate title is "Windows"
        assertEquals(driver.getTitle(), "Windows", "Actual does not match expected");

        //    5. Click - click here
        WebElement clickHereButton = driver.findElement(By.xpath("//a[text()='Click Here']"));
        clickHereButton.click();

        //    6. Switch to new window and validate title
        Set<String> windowHandles = driver.getWindowHandles();
        for (String each : windowHandles){
            driver.switchTo().window(each);
        }
        assertEquals(driver.getTitle(), "New Window", "Actual does not match expected");

    }
}
