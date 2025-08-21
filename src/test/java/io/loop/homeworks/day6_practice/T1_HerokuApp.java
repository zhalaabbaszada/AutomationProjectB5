package io.loop.homeworks.day6_practice;

import io.loop.test.utilisies.GeneralConstants;
import io.loop.test.utilisies.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

/*

task1
=============

go to http://the-internet.herokuapp.com/dropdown
validate "Please select an option" is selected by default
Choose option 1 and validate that it is selected
Choose option 2 and validate that it is selected
Validate dropdown name is "Dropdown List"

 */
public class T1_HerokuApp {

    WebDriver driver;
    String expected;
    String actual;

    @BeforeMethod
    public void SetUp(){
        driver = WebDriverUtil.getDriver(GeneralConstants.CHROME);
        driver.manage().window().maximize();
        driver.get("http://the-internet.herokuapp.com/dropdown");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void TearDownMethod(){
        driver.quit();
    }

    @Test
    public void Test1 (){
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));

        //validate "Please select an option" is selected by default
        actual = dropdown.getFirstSelectedOption().getText();
        expected = "Please select an option";
        assertEquals(actual, expected, "Actual does not match expected");

    }
    @Test
    public void Test2(){
        // Choose option 1 and validate that it is selected
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
        dropdown.selectByIndex(1);

        actual = dropdown.getFirstSelectedOption().getText();
        expected = "Option 1";
        assertEquals(actual, expected, "Actual does not match expected");
    }

    @Test
    public  void test3(){
        //Choose option 2 and validate that it is selected
        Select dropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));
        dropdown.selectByIndex(2);

        actual = dropdown.getFirstSelectedOption().getText();
        expected = "Option 2";

        assertEquals(actual, expected, "Actual does not matches expected test fail");
    }

    @Test
    public void test4(){
        WebElement element = driver.findElement(By.xpath("//div[@class='example']/h3"));

        if (element.isDisplayed()){
            System.out.println("Test pass");
        }else {
            System.out.println("Test fail");
        }
    }

















}
