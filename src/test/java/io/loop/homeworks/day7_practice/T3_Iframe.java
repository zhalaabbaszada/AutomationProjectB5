package io.loop.homeworks.day7_practice;

import io.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertEquals;

/*
task3
=============
go to https://demoqa.com/nestedframes
Validate "Child Iframe" text
Validate "Parent Iframe" text
Validate the "Sample Nested Iframe page. There are nested iframes in this page. Use browser inspecter or firebug to check out the HTML source. In total you can switch between the parent frame and the nested child frame."
 */
public class T3_Iframe extends TestBase {
    @Test
    public void iframe(){
        driver.get("https://demoqa.com/nestedframes");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Validate text
        WebElement textElement = driver.findElement(By.xpath("//div[@id='framesWrapper']/div[1]"));
        String actual =  textElement.getText();
        String expected = "Sample Nested Iframe page. There are nested iframes in this page. Use browser inspecter or firebug to check out the HTML source. In total you can switch between the parent frame and the nested child frame.";
        assertEquals(actual, expected, "Actual does not match expected");

    }

    @Test
    public void parentFrame(){
        driver.get("https://demoqa.com/nestedframes");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.switchTo().frame("frame1");
        String actual = driver.findElement(By.tagName("body")).getText();
        String expected = "Parent frame";
        assertEquals(actual, expected, "Actual does not match expected");


    }

    @Test
    public void childFrame(){
        driver.get("https://demoqa.com/nestedframes");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.switchTo().frame("frame1");
        driver.switchTo().frame(0);
        String actual = driver.findElement(By.tagName("p")).getText();
        String expected = "Child Iframe";
        assertEquals(actual, expected, "Actual does not match expected");


    }
}
