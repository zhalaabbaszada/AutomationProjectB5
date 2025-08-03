package io.loop.test.day4;


import io.loop.test.utilisies.DocuportConstants;
import io.loop.test.utilisies.GeneralConstants;
import io.loop.test.utilisies.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T4_forgot_password {
    public static void main(String[] args) {
        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.CHROME);

        driver.manage().window().maximize();

        driver.get(DocuportConstants.DOCUPORT_TEST);

        WebElement forgotPasswordLink = driver.findElement(By.cssSelector("a[href = '/reset-password']"));
        forgotPasswordLink.click();

        //locate forget password heading

        WebElement forgetPasswordHeading = driver.findElement(By.cssSelector("div[class = 'login-layout__form'] > h1"));
        System.out.println("forgetPasswordHeading.getText() = " + forgetPasswordHeading.getText());


    }
}
