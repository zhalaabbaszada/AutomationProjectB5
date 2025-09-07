package io.loop.homeworks.day10_practice;

import io.loop.test.utilities.ConfigurationReader;
import io.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

/*
task3
1. Open browser
2. Go to website: http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
3. Enter username: “Tester”
4. Enter password: “test”
5. Click to Login button
6. Print out count of all the links on landing page
7. Print out each link text on this page
 */
public class T3_LinkValidation {
    @Test
    public void LinkValidation(){
        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
        WebElement username = Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        username.sendKeys("Tester");
        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        password.sendKeys("test");
        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']"));
        loginButton.click();

        List <WebElement> linksAmount = Driver.getDriver().findElements(By.tagName("a"));
        System.out.println("linksAmount.size() = " + linksAmount.size());

        for (WebElement link : linksAmount) {
            System.out.println("link = " + link.getText());
        }
    }
}
