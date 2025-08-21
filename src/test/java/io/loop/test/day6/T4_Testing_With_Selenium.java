package io.loop.test.day6;

import io.loop.test.utilisies.DocuportConstants;
import io.loop.test.utilisies.GeneralConstants;
import io.loop.test.utilisies.WebDriverUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class T4_Testing_With_Selenium {
    WebDriver driver;
    String actual;
    String expected;

    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverUtil.getDriver(GeneralConstants.CHROME);
        driver.manage().window().maximize();
    }

    @Test
    public void googleTitle(){
        driver.get("https://www.google.com");
        System.out.println("((RemoteWebDriver) driver).getSessionId() = " + ((RemoteWebDriver) driver).getSessionId());
        expected = "Google";
        actual = driver.getTitle();
        assertEquals(actual, expected, "Actual: " + actual + " does not match expected: " + expected);
    }

    @Test
    public void docuportTitle(){
        driver.get(DocuportConstants.DOCUPORT_TEST);
        System.out.println("((RemoteWebDriver) driver).getSessionId() = " + ((RemoteWebDriver) driver).getSessionId());
        expected = "Docuport";
        actual = driver.getTitle();
        assertEquals(actual, expected, "Actual: " + actual + " does not match expected: " + expected);

    }
}
