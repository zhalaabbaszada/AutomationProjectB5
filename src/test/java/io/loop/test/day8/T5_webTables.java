package io.loop.test.day8;

import io.loop.test.base.TestBase;
import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.DocuportUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

/*
   1. login as an advisor
   2. go to users
   3. validate that full name for alex.de.souza@gmail.com is AAlex De Souza
   4. validate that user name for alex.de.souza@gmail.com is alexdesouze
   5. validate that phone number for alex.de.souza@gmail.com is +994512060042
   6. validate that role for alex.de.souza@gmail.com is client
   7. validate that advisor for alex.de.souza@gmail.com is  Batch1 Group1
    */
public class T5_webTables extends TestBase {

    @Test
    public void test_WebTables() throws InterruptedException {
        DocuportUtils.login( driver,DocuportConstants.ADVISOR);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement users = driver.findElement(By.xpath("//span[contains(text(),'Users')]"));
        users.click();
        String expectedFullName = "AAlex De Souza";
        String actualFullName = DocuportUtils.returnAnyFieldFromTable(driver, "alex.de.souza@gmail.com", "full name");
        assertEquals(actualFullName, expectedFullName, "Actual does not match expected");
        System.out.println("actualFullName = " + actualFullName);

        String expectedUserName = "alexdesouze";
        String actualUserName = DocuportUtils.returnAnyFieldFromTable(driver, "alex.de.souza@gmail.com", "username");
        assertEquals(actualUserName, expectedUserName, "Actual does not match expected");
        System.out.println("actualUserName = " + actualUserName);

        String expectedPhoneNumber = "+994512060042";
        String actualPhoneNumber = DocuportUtils.returnAnyFieldFromTable(driver, "alex.de.souza@gmail.com", "phone number");
        assertEquals(actualPhoneNumber, expectedPhoneNumber, "Actual does not match expected");
        System.out.println("actualPhoneNumber = " + actualPhoneNumber);

        String expectedRole = "Client";
        String actualRole = DocuportUtils.returnAnyFieldFromTable(driver, "alex.de.souza@gmail.com", "role");
        assertEquals(actualRole, expectedRole, "Actual does not match expected");
        System.out.println("actualRole = " + actualRole);

        String expectedAdvisor = "advisor advisor";
        String actualAdvisor = DocuportUtils.returnAnyFieldFromTable(driver, "alex.de.souza@gmail.com", "advisor");
        assertEquals(actualAdvisor, expectedAdvisor, "Actual does not match expected");
        System.out.println("actualAdvisor = " + actualAdvisor);


    }

}
