package io.loop.homeworks.day8_practice;

import io.loop.test.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;

/*
extra task
 =============

 automate till payment
 https://app.docuport.app/company-formation/resident
 */
public class T4_Extra extends TestBase {
    @Test
    public void payment(){
        driver.get(" https://app.docuport.app/company-formation/resident");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        // First page
        WebElement formationState = driver.findElement(By.xpath("//*[text()='Maryland']"));
        formationState.click();
        WebElement companyName = driver.findElement(By.xpath("//label[text()='Legal Company Name  *']/following-sibling::input[@type='text']"));
        companyName.sendKeys("Disney World");
        WebElement industry = driver.findElement(By.xpath("//label[text()='Industry *']/following-sibling::input[@type='text']"));
        industry.click();
        WebElement industryType = driver.findElement(By.xpath("//div[text()='Arts and Crafts']"));
        industryType.click();
        WebElement firsName = driver.findElement(By.xpath("//label[text()='First name *']/following-sibling::input[@type='text'][1]"));
        firsName.sendKeys("Snow");
        WebElement lastName = driver.findElement(By.xpath("//label[text()='Last name *']/following-sibling::input[@type='text'][1]"));
        lastName.sendKeys("White");
        WebElement email = driver.findElement(By.xpath("//label[text()='Email address *']/following-sibling::input[@type='text'][1]"));
        email.sendKeys("snowwhite@gmail.com");
        WebElement phoneNumber = driver.findElement(By.xpath("//label[text()='Phone number *']/following-sibling::input[@type='text'][1]"));
        phoneNumber.sendKeys("+11234561221");
        driver.findElement(By.xpath("//button[@type='submit']/span")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //Second page
        /*
        for some reason sometimes didn't work
        //driver.findElement(By.xpath("//label[text()='Company']")).click();
        //driver.findElement(By.xpath("(//div[@class='v-input--selection-controls__ripple'])[5]")).click();
        //WebElement companyName2 = driver.findElement(By.xpath("//label[text()='Company name *']/following-sibling::input"));
        //companyName2.sendKeys("Disney World");
         */
        WebElement firstNameAgentType = driver.findElement(By.xpath("(//label[text()='First name *']/following-sibling::input[@type='text'])[2]"));
        firstNameAgentType.sendKeys("Harry");
        WebElement lastNameAgentType = driver.findElement(By.xpath("(//label[text()='Last name *']/following-sibling::input[@type='text'])[2]"));
        lastNameAgentType.sendKeys("Potter");
        WebElement address = driver.findElement(By.xpath("//label[text()='Address line 1 *']/following-sibling::input"));
        address.sendKeys("456 Disney Ave");
        WebElement city = driver.findElement(By.xpath("//label[text()='City *']/following-sibling::input"));
        city.sendKeys("Fairy");
        driver.findElement(By.xpath("(//label[text()='Jurisdiction *']/following-sibling::input)[1]")).click();
        driver.findElement(By.xpath("//div[text()='Caroline County']")).click();
        WebElement zipCode=driver.findElement(By.xpath("//label[text()='Zip code *']/following-sibling::input"));
        zipCode.sendKeys("12345");
        WebElement phoneNumber2 = driver.findElement(By.xpath("(//label[text()='Phone number *']/following-sibling::input)[2]"));
        phoneNumber2.sendKeys("+11234561221");
        driver.findElement(By.xpath("(//button[@type='submit']/span)[2]")).click();

        // Third page
        WebElement firstName2 = driver.findElement(By.xpath("(//label[text()='First name *']/following-sibling::input[@type='text'])[3]"));
        firstName2.sendKeys("Harry");
        WebElement lastName2 = driver.findElement(By.xpath("(//label[text()='Last name *']/following-sibling::input[@type='text'])[3]"));
        lastName2.sendKeys("Potter");
        driver.findElement(By.xpath("//label[text()='Share Ownership (%) *']/following-sibling::input")).click();
        WebElement ownership = driver.findElement(By.xpath("//label[text()='Share Ownership (%) *']/following-sibling::input"));
        ownership.sendKeys("10");

        WebElement ssnOfOrganizing = driver.findElement(By.xpath("//label[text()='SSN of an Organizing Member *']/following-sibling::input"));
        ssnOfOrganizing.sendKeys("1234561234");

        WebElement firstNameEIN = driver.findElement(By.xpath("(//label[text()='First name *']/following-sibling::input[@type='text'])[4]"));
        firstNameEIN.sendKeys("Jon");
        WebElement lastNameEIN = driver.findElement(By.xpath("(//label[text()='Last name *']/following-sibling::input[@type='text'])[4]"));
        lastNameEIN.sendKeys("Snow");

        driver.findElement(By.xpath("//span[text()=' Go to payment ']")).click();









    }
}
