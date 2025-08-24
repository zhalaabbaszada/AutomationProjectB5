package io.loop.test.day7;

import io.loop.test.base.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/*
   Information alert practice
   1. Open browser
   2. Go to website: https://loopcamp.vercel.app/javascript-alerts.html
   3. Click to “Click for JS Alert” button
   4. Click to OK button from the alert
   5. Validate “You successfully clicked an alert” text is displayed

   Confirmation alert practice
   1. Click to “Click for JS Confirm” button
   2. Click to OK button from the alert
   3. Verify “You clicked: Ok” text is displayed.
   4. Click to “Click for JS Confirm” button
   5. Click to Cancel button from the alert
   6. Validate “You clicked: Cancel” text is displayed.

   Prompt alert practice
   1. Click to “Click for JS Prompt” button
   2. Send "Loop Academy"
   3. Click Ok
   4. Validate "You entered: Loop Academy" text is displayed
    */
public class T1_Alerts extends TestBase {

 @Test
    public void informationAlert(){
     driver.get("https://loopcamp.vercel.app/javascript-alerts.html");

     WebElement clickForJCAlert = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
     clickForJCAlert.click();

     Alert alert = driver.switchTo().alert();
     alert.accept();

     WebElement successMessageForInformationAlert = driver.findElement(By.xpath("//p[@id='result']"));
     String expected = "You successfully clicked an alert";
     String actual = successMessageForInformationAlert.getText();
     assertEquals(actual, expected, "Actual does not match the expected");

 }

    @Test
    public void confirmationAlert() {
        driver.get("https://loopcamp.vercel.app/javascript-alerts.html");
        WebElement clickForJSConfirm = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        clickForJSConfirm.click();

        // click and accept the alert
        driver.switchTo().alert().accept();
        WebElement successMessageForConfirmationAlert = driver.findElement(By.xpath("//p[@id='result']"));
        String expected = "You clicked: Ok";
        String actual = successMessageForConfirmationAlert.getText();
        assertEquals(actual, expected, "Actual does not match the expected");

        // click and dismiss the alert
        clickForJSConfirm.click();
        driver.switchTo().alert().dismiss();
        expected = "You clicked: Cancel";
        actual = successMessageForConfirmationAlert.getText();
        assertEquals(actual, expected, "Actual does not match expected");

    }


    @Test
    public void promptAlert() {
        driver.get("https://loopcamp.vercel.app/javascript-alerts.html");
        WebElement clickJSPrompt = driver.findElement(By.xpath("//button[.='Click for JS Prompt']"));
        clickJSPrompt.click();

        String text = "Loopcamp";
/*
        driver.switchTo().alert().sendKeys(text);
        driver.switchTo().alert().accept();

 */
        Alert alert =  driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();
        WebElement successMessageForPromptAlert = driver.findElement(By.xpath("//p[@id='result']"));
        String actual = successMessageForPromptAlert.getText();
        String expected = "You entered: " + text;
        assertEquals(actual, expected, "Actual does not match expected");

        clickJSPrompt.click();
        alert.sendKeys(text);
        alert.dismiss();
        actual = successMessageForPromptAlert.getText();
        expected = "You entered: " + null;
        assertEquals(actual, expected, "Actual does not match expected");

    }

}
