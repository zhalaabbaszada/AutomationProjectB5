package io.loop.homeworks.day4_practice;

import io.loop.test.utilisies.DocuportConstants;
import io.loop.test.utilisies.GeneralConstants;
import io.loop.test.utilisies.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
task 3
=============
1. navigate to docuport application
2. validate placeholders for user name and password
3. without sending username and password click login button
4. validate username and password error messages
 */
public class T3_ErrorMessages {
    public static void main(String[] args) {
        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.CHROME);
        driver.manage().window().maximize();

        driver.get(DocuportConstants.DOCUPORT_TEST);
        WebElement placeHolderForUsername = driver.findElement(By.cssSelector("label[for=\"input-14\"]"));
        String actualPlaceHolderForUsername = placeHolderForUsername.getText();
        String expectedPlaceholderForUsername = DocuportConstants.EXPECTED_PLACEHOLDER_FOR_USERNAME;

        if (actualPlaceHolderForUsername.equalsIgnoreCase(expectedPlaceholderForUsername)){
            System.out.println("Actual placeholder for username \"" + actualPlaceHolderForUsername +  "\" matches expected placeholder for username \"" + expectedPlaceholderForUsername + "\" => TEST PASS" );
        }else {
            System.out.println("Actual placeholder for username \"" + actualPlaceHolderForUsername +  "\" does not match expected placeholder for username \"" + expectedPlaceholderForUsername + "\" => TEST FAIL" );
        }

        WebElement placeHolderForPassword = driver.findElement(By.cssSelector("label[for=\"input-15\"]"));
        String actualPlaceHolderForPassword = placeHolderForPassword.getText();
        String expectedPlaceHolderForPassword = DocuportConstants.EXPECTED_PLACEHOLDER_FOR_PASSWORD;
        if (actualPlaceHolderForPassword.equalsIgnoreCase(expectedPlaceHolderForPassword)){
            System.out.println("Actual placeholder for password \"" + actualPlaceHolderForPassword +  "\" matches expected placeholder for password \"" + expectedPlaceHolderForPassword + "\" => TEST PASS" );
        }else {
            System.out.println("Actual placeholder for password \"" + actualPlaceHolderForPassword +  "\" does not match expected placeholder for password \"" + expectedPlaceHolderForPassword + "\" => TEST FAIL" );
        }
        WebElement loginButton = driver.findElement(By.cssSelector("span[class=\"v-btn__content\"]"));
        loginButton.click();

        WebElement usernameErrorMessage = driver.findElement(By.cssSelector(".login-layout__form .mb-4:first-of-type .v-messages__message\n"));
        String actualErrorMessageForUsername = usernameErrorMessage.getText();
        String expectedErrorMessageForUsername = DocuportConstants.EXPECTED_ERROR_MESSAGE_FOR_USERNAME;
        if (actualErrorMessageForUsername.equalsIgnoreCase(expectedErrorMessageForUsername)){
            System.out.println("Actual error message for username \"" + actualErrorMessageForUsername +  "\" matches expected error message for username \"" + expectedErrorMessageForUsername + "\" => TEST PASS" );
        }else {
            System.out.println("Actual error message for username \"" + actualErrorMessageForUsername +  "\" does not match expected error message for username \"" + expectedErrorMessageForUsername + "\" => TEST FAIL" );
        }

        WebElement passwordErrorMessage = driver.findElement(By.cssSelector(".login-layout__form .mb-4:nth-of-type(2) .v-messages__message\n"));
        String actualErrorMessageForPassword = passwordErrorMessage.getText();
        String expectedErrorMessageForPassword = DocuportConstants.EXPECTED_ERROR_MESSAGE_FOR_PASSWORD;
        if (actualErrorMessageForPassword.equalsIgnoreCase(expectedErrorMessageForPassword)){
            System.out.println("Actual error message for password \"" + actualErrorMessageForPassword +  "\" matches expected error message for password \"" + expectedErrorMessageForPassword + "\" => TEST PASS" );
        }else {
            System.out.println("Actual error message for password \"" + actualErrorMessageForPassword +  "\" does not match expected error message for password \"" + expectedErrorMessageForPassword + "\" => TEST FAIL" );
        }




    }
}
