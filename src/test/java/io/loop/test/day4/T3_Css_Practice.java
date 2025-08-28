package io.loop.test.day4;

import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
go to docuport app
identify docuport with css
get value of the attribute
validate if it is "Docuport"

the rest is home work
locate:
username
password
login
    with css
login to docuport
locate home icon of docuport after login or any other element after login
validated that you logged in

 */
public class T3_Css_Practice {
    public static void main(String[] args) {
        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.CHROME);

        driver.manage().window().maximize();
        driver.navigate().to(DocuportConstants.DOCUPORT_TEST);

        //locate the elemet wiht CSS
        WebElement logo = driver.findElement(By.cssSelector("img[src='/img/logo.d7557277.svg']"));

        //get value of the attribute
        String actualLogoDocuport = logo.getDomAttribute("alt");

        if (DocuportConstants.EXPECTED_LOGO_DOCUPORT.equals(actualLogoDocuport)){
            System.out.println("Expected logo: " + DocuportConstants.EXPECTED_LOGO_DOCUPORT + ", matches actual " + actualLogoDocuport +  " => test PASS");
        }else {
            System.err.println("Expected logo: " + DocuportConstants.EXPECTED_LOGO_DOCUPORT + ", does not matches actual " + actualLogoDocuport +  " => test FAIL");
        }




    }
}
