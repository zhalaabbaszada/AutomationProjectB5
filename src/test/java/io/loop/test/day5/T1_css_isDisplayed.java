package io.loop.test.day5;

import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
        1- Open a chrome browser
        2- Go to: https://www.nba.com
        3- Locate all the links in the page.

    https://the-internet.herokuapp.com/forgot_password

 */
public class T1_css_isDisplayed{
    public static void main(String[] args) {

        // setup driver and navigate thw page
        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.CHROME);
        driver.manage().window().maximize();
        driver.get(GeneralConstants.HEROKUAPP_URL);

        WebElement forgotPasswordHeading = driver.findElement(By.cssSelector("div[class='example']>h2"));

        //print out the text of the element
        System.out.println("forgotPasswordHeading.getText() = " + forgotPasswordHeading.getText());

        //isDisplayed() - will return true or false depending the element is displayed at html
        System.out.println("forgotPasswordHeading.isDisplayed() = " + forgotPasswordHeading.isDisplayed());

        if (forgotPasswordHeading.isDisplayed()){
            System.out.println("Test pass");
        }else {
            System.out.println("Test fail");
        }
    }
}