package io.loop.test.day3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Locators {
    public static void main(String[] args) throws InterruptedException {

        //Create an option to avoid google capture
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");

        // create an object of driver

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.google.com");

        //locate the element

        WebElement searchBoxWithID = driver.findElement(By.id("APjFqb"));

        // get a test to search

        String textToSearch = "HELLO";


        //add some wait
        Thread.sleep(3000);

        // send the text to the input
        searchBoxWithID.sendKeys(textToSearch);

        //clear box
        searchBoxWithID.clear();

        // click enter
        searchBoxWithID.sendKeys("new rules" + Keys.ENTER);

        // navigate back
        driver.navigate().back();

        //locate search box with name
        WebElement searchBoxWithName = driver.findElement(By.name("q"));

        // send text to the search box which is spied with name
        searchBoxWithName.sendKeys(textToSearch + Keys.ENTER);

        // navigate back again
        driver.navigate().back();

        // locate about with using linkText
        WebElement aboutLink = driver.findElement(By.linkText("About"));

        //click that link
        aboutLink.click();
    }
}
