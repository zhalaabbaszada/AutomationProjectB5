package io.loop.homeworks.day4_practice;
/*
task 1
=============
1. go to https://loopcamp.vercel.app/forgot-password.html
2. locate 5 elements, forgot password, email, email input, retrieve password, powered by LOOPCAMP
3. use css
4. Validate those elements are displayed
 */

import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.LoopCampConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_LoopcampLocateElements {
    public static void main(String[] args) {
        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.CHROME);
        driver.manage().window().maximize();

        driver.get(LoopCampConstants.FORGOT_PASSWORD_URL);
        // locate elements for forgot password
        WebElement forgotPassword = driver.findElement(By.cssSelector("div[class = \"example\"]>h2"));
        String actualForgotPassword = forgotPassword.getText();
        String expectedForgotPassword = LoopCampConstants.EXPECTED_FORGOT_PASSWORD;
        if (actualForgotPassword.equalsIgnoreCase(expectedForgotPassword)){
            System.out.println("Expected forgot password " + expectedForgotPassword + ", matches actual forgot password " + actualForgotPassword + " => Test pass");
        }else {
            System.err.println("Expected forgot password " + expectedForgotPassword + ", does not matches actual forgot password " + actualForgotPassword + " => Test fail");
        }

        //Locate element for email
        WebElement email = driver.findElement(By.cssSelector("label[ for = \"email\"]"));
        String actualEmail = email.getText();
        String expectedEmail = LoopCampConstants.EXPECTED_EMAIL;
        if (actualEmail.equalsIgnoreCase(expectedEmail)){
            System.out.println("Expected email " + expectedEmail + ", matches actual email " + actualEmail + " => Test pass");
        }else {
            System.err.println("Expected email " + expectedEmail + ", does not match actual email " + actualEmail + " => Test fail");
        }

        // locate element for email input
        WebElement emailInput = driver.findElement(By.cssSelector("input[ type= \"text\"]"));
        String actualEmailInput = emailInput.getDomAttribute("name");
        String expectedEmailInput  =LoopCampConstants.EXPECTED_EMAIL_INPUT;
        if (actualEmailInput.equalsIgnoreCase(expectedEmailInput)){
            System.out.println("Expected email input " + expectedEmailInput + ", matches actual email input " + actualEmailInput + " => Test pass");
        }else {
            System.out.println("Expected email input " + expectedEmailInput + ", does not match actual email input " + actualEmailInput + " => Test fail");
        }

        //locate element for retrieve password
        WebElement retrievePassword = driver.findElement(By.cssSelector("i[ class=\"icon-2x icon-signin\"]"));
        String actualRetrievePassword = retrievePassword.getText();
        String expectedRetrievePassword = LoopCampConstants.EXPECTED_RETRIEVE_PASSWORD;
        if (actualRetrievePassword.equalsIgnoreCase(expectedRetrievePassword)){
            System.out.println("Expected retrieve password  " + expectedRetrievePassword + ", matches actual retrieve password " + actualRetrievePassword + " => Test pass");
        }else {
            System.err.println("Expected retrieve password  " + expectedRetrievePassword + ", does not match actual retrieve password " + actualRetrievePassword + " => Test fail");
        }
        //locate powered by LOOPCAMP
        WebElement poweredByLoopcamp = driver.findElement(By.cssSelector("div[ style=\"text-align: center;\"]"));
        String actualPoweredByLoopcamp = poweredByLoopcamp.getText();
        String expectedPoweredByLoopcamp = LoopCampConstants.EXPECTED_POWERED_BY_LOOPCAMP;
        if (actualPoweredByLoopcamp.equalsIgnoreCase(expectedPoweredByLoopcamp)){
            System.out.println("Expected powered by Loopcamp  " + expectedPoweredByLoopcamp + ", matches actual powered by Loopcamp " + actualPoweredByLoopcamp+ " => Test pass");
        }else {
            System.err.println("Expected powered by Loopcamp  " + expectedPoweredByLoopcamp + ", does not match actual powered by Loopcamp " + actualPoweredByLoopcamp+ " => Test fail");
        }

        driver.quit();

    }
}
