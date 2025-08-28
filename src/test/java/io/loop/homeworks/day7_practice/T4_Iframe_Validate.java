package io.loop.homeworks.day7_practice;

import io.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

/*
task4
=============
go to https://loopcamp.vercel.app/nested-frames.html
validate "LEFT", "MIDDLE", "RIGHT", "BOTTOM"
 */
public class T4_Iframe_Validate extends TestBase {
    @Test
    public void leftIframes(){
        driver.get("https://loopcamp.vercel.app/nested-frames.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //LEFT
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        WebElement left = driver.findElement(By.xpath("//body[contains(text(), 'LEFT')]"));
        String actual = left.getText();
        String expected = "LEFT";
        assertEquals(actual, expected, "Actual does not match expected");

    }
    @Test
    public void middleIframe(){
        driver.get("https://loopcamp.vercel.app/nested-frames.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        WebElement middle = driver.findElement(By.xpath("//body[contains(.,'MIDDLE')]"));
        String actual = middle.getText();
        String expected = "MIDDLE";
        assertEquals(actual, expected, "Actual does not match expected");

    }
    @Test
    public void rightIframe(){
        driver.get("https://loopcamp.vercel.app/nested-frames.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-right");
        WebElement right = driver.findElement(By.xpath("//body[contains(.,'RIGHT')]"));
        String actual = right.getText();
        String expected = "RIGHT";
        assertEquals(actual, expected, "Actual does not match expected");

    }
    @Test
    public void bottomIframe(){
        driver.get("https://loopcamp.vercel.app/nested-frames.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.switchTo().frame("frame-bottom");
        WebElement button = driver.findElement(By.xpath("//body[contains(.,'BOTTOM')]"));
        String actual = button.getText();
        String expected = "BOTTOM";
        assertEquals(actual, expected, "Actual does not match expected");

    }
}
