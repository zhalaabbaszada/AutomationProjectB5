package io.loop.test.day4;

import io.loop.test.utilisies.GeneralConstants;
import io.loop.test.utilisies.LoopCampConstants;
import io.loop.test.utilisies.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
  go to url: https://loopcamp.vercel.app/registration_form.html
  validate header text expected:  Registration form
  validate placeholder attribute value for first name expected - first name
   */
public class T2_getText_getAttribute {
    public static void main(String[] args) {

        //go to the url
        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.CHROME);
        driver.manage().window().maximize();

        driver.navigate().to(LoopCampConstants.REGISTRATION_FORM_URL);

        //spy / locate the element -  header

        WebElement header = driver.findElement(By.tagName("h2"));

        //use getText() method

        String actualHeaderForForm = header.getText();

        //validation

        if (actualHeaderForForm.equalsIgnoreCase(LoopCampConstants.EXCEPTED_HEADER_fOR_fORM)){
            System.out.println("Expected header for form: " + LoopCampConstants.EXCEPTED_HEADER_fOR_fORM + ", matches actual header " + actualHeaderForForm + " => TEST PASS");
        }else {
            System.err.println("Expected header for form: " + LoopCampConstants.EXCEPTED_HEADER_fOR_fORM + ", does not matches actual header " + actualHeaderForForm + " => TEST FAIL");
        }


        // use get attribute method which will return the value of the attribute not the text

        WebElement firstNamePlaceHolder = driver.findElement(By.name("firstname"));

        firstNamePlaceHolder.getDomAttribute("placeholder");

        //validation

        String actualPlaceHolderForFirstName = firstNamePlaceHolder.getAttribute("placeholder");

        if (actualPlaceHolderForFirstName.equals(LoopCampConstants.EXPECTED_PLACEHOLDER_FOR_FIRSTNAME)){
            System.out.println("Expected placeholder for form: " + LoopCampConstants.EXCEPTED_HEADER_fOR_fORM + ", matches actual placeholder " + actualHeaderForForm + " => TEST PASS");
        }else {
            System.out.println("Expected placeholder for form: " + LoopCampConstants.EXCEPTED_HEADER_fOR_fORM + ",\" does not matches actual placeholder \"" + actualHeaderForForm + " \" => TEST FAIL");
        }


    }
}
