package io.loop.test.day5;

import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.*;

/*
 1. open chrome
 2. go to docuport
 3. click on forgot password
 4. validate url contains: reset-password
 5. validate - Enter the email address associated with your account
 6. enter forgotpasswordg1@gmail.com to email box
 7. validate send button is displayed
 8. validate cancel button is displayed
 9. click send button
 10. validate - We've sent you an email with a link to reset your password. Please check your email
  */
public class T2_xpath_getText {
    public static void main(String[] args) throws InterruptedException {
        // 1, open chrome and naviagte docuport
        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.CHROME);
        driver.manage().window().maximize();
        driver.get(DocuportConstants.DOCUPORT_TEST);

        //click on forget password link
        WebElement forgotPassword = driver.findElement(By.xpath("//a[@href= '/reset-password']"));
        forgotPassword.click();

        // 4. validate url contains: reset-password
        String actualUrl = driver.getCurrentUrl();


        if (actualUrl.equalsIgnoreCase(DocuportConstants.FORGOT_PASSWORD_URL)){
            System.out.println("TEST PASS");
        }else {
            System.out.println("TEST FAIL");
        }

        // 5. validate - Enter the email address associated with your account
        WebElement validateMessage = driver.findElement(By.xpath("//div[contains(text(),'Enter')]"));
        String actualValidateMessage = validateMessage.getText();

        if (actualValidateMessage.equals(DocuportConstants.RESET_PASSWORD_MESSAGE)){
            System.out.println("TEST PASS");
        }else {
            System.out.println("TEST FAIL");
        }

        // 6. enter forgotpasswordg1@gmail.com to email box
        WebElement emailInputBox = driver.findElement(By.xpath("//input[contains(@id,'input')]"));
        emailInputBox.sendKeys(DocuportConstants.EMAIL_FOR_RESET_PASSWORD);

      //  7. validate send button is displayed
      //  8. validate cancel button is displayed

        WebElement sendButton = driver.findElement(By.xpath("//span[normalize-space()='Send']"));

        WebElement cancelButton = driver.findElement(By.xpath("//span[contains(text(),'Cancel')]"));

        if (cancelButton.isDisplayed()){
            System.out.println("TEST PASS");
        }else {
            System.out.println("TEST FAIL");
        }
        if (sendButton.isDisplayed()){
            System.out.println("TEST PASS");
        }else {
            System.out.println("TEST FAIL");
        }

        // 9. click send button
        sendButton.click();
        //Thread.sleep(5000);


        // 10. validate - We've sent you an email with a link to reset your password. Please check your email
        WebElement successMessage;
        try {
            successMessage = driver.findElement(By.xpath("//span[@class='body-1']"));
        }catch (NoSuchElementException mse){
            mse.printStackTrace();
            Thread.sleep(5000);
            successMessage = driver.findElement(By.xpath("//span[@class='body-1']"));
        }

        System.out.println(successMessage.getText());

        Thread.sleep(10000);


        try {
            System.out.println(successMessage.getText());
        }catch (StaleElementReferenceException e){
            e.printStackTrace();
            System.out.println("Element is not here anymore");
        }


    }
}
