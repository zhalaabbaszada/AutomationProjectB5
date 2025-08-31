package io.loop.test.day10;

import io.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

/*
    1. Go to https://loopcamp.vercel.app/index.html
    2. Scroll down to the link
     */
public class T3_JCExecuret_scroll {
    @Test
    public void loopcampScroll(){
        Driver.getDriver().get("https://loopcamp.vercel.app/index.html");
        WebElement link =  Driver.getDriver().findElement(By.xpath("//a[@href='https://www.loopcamp.io/']"));

        // hot ot scroll

        //#1 use the actions class move to element

        //Actions actions = new Actions(Driver.getDriver());
        //actions.moveToElement(link).perform();
        //actions.scrollToElement(link).perform();

        //#2 use key press
        //actions.sendKeys(Keys.PAGE_DOWN, Keys.PAGE_DOWN, Keys.PAGE_DOWN).perform();

        //#3 move horizontally or vertically
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        //jc.executeScript("window.scroll(0, 5000)");

        //#4 move scroll to view
        //jc.executeScript("arguments[0].scrollIntoView(true)", link);
        js.executeScript("arguments[0].scrollIntoView(true)", link);
        js.executeScript("arguments[0].click()", link);
        js.executeScript("window.scroll(0, 500)");



    }
}
