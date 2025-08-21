package io.loop.homeworks.day6_practice;

import io.loop.test.utilisies.DocuportConstants;
import io.loop.test.utilisies.GeneralConstants;
import io.loop.test.utilisies.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

/*
  task2
=============
login as an advisor
go to received document
click search
click status dropdown
choose in progress
   */
public class T2_Docuport {
    WebDriver driver;

    @BeforeMethod
    public void SetUp() {
        driver = WebDriverUtil.getDriver(GeneralConstants.CHROME);
        driver.manage().window().maximize();
        driver.get(DocuportConstants.DOCUPORT_TEST);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void TearDownMethod() {
        // driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        //login as an advisor
        WebElement username = driver.findElement(DocuportConstants.USERNAME_FIELD);
        WebElement password = driver.findElement(DocuportConstants.PASSWORD_FIELD);
        WebElement loginButton = driver.findElement(DocuportConstants.LOGIN_BUTTON);
        username.sendKeys(DocuportConstants.USERNAME_ADVISOR);
        password.sendKeys(DocuportConstants.PASSWORD_ALL_ROLES);
        loginButton.click();

        // go to received document
        WebElement receivedDocuments = driver.findElement(By.xpath("//h2[text()='Received ']"));
        receivedDocuments.click();

        //click search
        WebElement searchButton = driver.findElement(By.xpath("//span[text()='Search']"));
        searchButton.click();

        //click status dropdown
        WebElement dropdown = driver.findElement(By.xpath("//label[text()='Status']/following-sibling::div[contains(@class,'v-select__selections')]"));
        //Thread.sleep(5000);
        dropdown.click();

        //choose in progress
        WebElement inProgress = driver.findElement(By.xpath("//div[text()='In progress']"));
        inProgress.click();

    }

}
