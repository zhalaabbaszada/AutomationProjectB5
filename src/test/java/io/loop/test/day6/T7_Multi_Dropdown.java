package io.loop.test.day6;

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
import java.util.List;

import static org.testng.Assert.assertTrue;

public class T7_Multi_Dropdown {
        /*
    1. Open Chrome browser
    2. Go to https://demoqa.com/select-menu
    3. Select all the options from multiple select dropdown.
    4. Print out all selected values.
    5. Deselect all values.
     */

    WebDriver driver;
    @BeforeMethod
    public  void setUpMethod(){
        driver = WebDriverUtil.getDriver(GeneralConstants.CHROME);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/select-menu");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
    @AfterMethod
    public void tearDownMethod(){
        //driver.close();
    }

    @Test
    public void multiSelect(){
        // create dropdown
        Select dropdowns = new Select(driver.findElement(By.xpath("//select[@id='cars']")));

        // there is method which tells us that dropdown is multiselect or not
        assertTrue(dropdowns.isMultiple(), "Dropdown is not multi select");
/*
        dropdowns.selectByIndex(0);
        dropdowns.selectByValue("saab");
        dropdowns.selectByVisibleText("Opel");
        dropdowns.deSelectByContainsVisibleText("Au");
*/

        // get all options and assign them to the list of element

        List <WebElement> options;
        options = dropdowns.getOptions();
/*
        for (WebElement option: options){
            option.click();
            System.out.println("option.getText() = " + option.getText());
        }
*/
        /*
        options.forEach(option ->{
        option.click()
        System.out.println("option.getText() = " + option.getText())});
        */

        options.forEach(WebElement::click);
        dropdowns.deselectAll();


    }
}
