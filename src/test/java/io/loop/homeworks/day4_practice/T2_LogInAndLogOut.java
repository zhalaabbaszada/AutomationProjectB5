package io.loop.homeworks.day4_practice;

import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
task 2
=============
1. login to docuport application
2. logout from docuport application
3. Validate successful login
4. Validate successful logout
 */
public class T2_LogInAndLogOut {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.CHROME);
        driver.manage().window().maximize();

        driver.get(DocuportConstants.DOCUPORT_TEST);

        WebElement username = driver.findElement(By.cssSelector("input[id=\"input-14\"]"));
        username.sendKeys(DocuportConstants.USERNAME_CLIENT);
        WebElement password = driver.findElement(By.cssSelector("input[id=\"input-15\"]"));
        password.sendKeys(DocuportConstants.PASSWORD_ALL_ROLES);
        WebElement loginButton = driver.findElement(By.cssSelector("span[class=\"v-btn__content\"]"));
        loginButton.click();
        Thread.sleep(3000);
        WebElement continueButton = driver.findElement(By.cssSelector("button[type=\"submit\"]"));
        continueButton.click();

        WebElement b1G1Button = driver.findElement(By.cssSelector("span[class=\"subtitle-2 text-none pl-2 pr-3 gray--text text--darken-3\"]"));
        b1G1Button.click();
        Thread.sleep(3000);

        if (b1G1Button.isDisplayed()){
            System.out.println("Login is successful => TEST PASS");
        }else {
            System.out.println("Login is not successful => TEST FAIL");
        }

        WebElement logOutButton = driver.findElement(By.id("list-item-149"));
        logOutButton.click();

        Thread.sleep(3000);

        WebElement logoDocuport = driver.findElement(By.cssSelector("img[src='/img/logo.d7557277.svg']"));

        if (logoDocuport.isDisplayed()){
            System.out.println("Log out it successful => TEST PASS");
        }else {
            System.out.println("Log out is not successful => TEST FAIL");
        }

    }
}
