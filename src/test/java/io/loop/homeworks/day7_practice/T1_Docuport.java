package io.loop.homeworks.day7_practice;

import io.loop.test.base.TestBase;
import io.loop.test.utilities.DocuportConstants;
import io.loop.test.utilities.DocuportUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertTrue;

/*
=============
1. login as an advisor
2. go to received document
3. click search
4. validate that status dropdown does not allow to select multiple
5. validate that tags dropdown allows to select multiple
 */
public class T1_Docuport extends TestBase {
    @Test
    public void singleDropdown() throws InterruptedException {
        DocuportUtils.login(driver, DocuportConstants.ADVISOR);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // go to received document
        WebElement receivedDocuments = driver.findElement(By.xpath("//h2[text()='Received ']"));
        receivedDocuments.click();

        //click search
        WebElement searchButton = driver.findElement(By.xpath("//span[text()='Search']"));
        searchButton.click();

        // Validate that status dropdown does not allow to select multiple
        WebElement statusDropdown = driver.findElement(By.xpath("//label[text()='Status']/following-sibling::div[contains(@class,'v-select__selections')]"));
        statusDropdown.click();

        //choose in progress option
        WebElement inProgressOption = driver.findElement(By.xpath("//div[text()='In progress']"));
        inProgressOption.click();

        //Click status dropdown again
        statusDropdown.click();

        //choose Done option
        WebElement doneOption = driver.findElement(By.xpath("//div[@class='v-list-item__content']/div[text()='Done']"));
        doneOption.click();

        // Validate that only 1 option selected
        List <WebElement> selectedOptionsForStatus = driver.findElements(By.xpath("//div[@class='v-list-item__content']/div[text()='Done']"));
        if (selectedOptionsForStatus.size() ==1 ){
            System.out.println("One option selected: Test PASS");
        }else {
            System.out.println("Multiple option selected: Test FAIL");
        }

        // Validate that tags dropdown allows to select multiple
        WebElement tagsDropdown = driver.findElement(By.xpath("//label[text()='Tags']/following-sibling::div[contains(@class,'v-select__selections')]"));
        tagsDropdown.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement otherDocumentsOption = driver.findElement(By.xpath("//span[text()='Other Documents']"));
        System.out.println("otherDocumentsOption.isDisplayed() = " + otherDocumentsOption.isDisplayed());
        System.out.println("otherDocumentsOption.isEnabled() = " + otherDocumentsOption.isEnabled());
        otherDocumentsOption.click();

       // tagsDropdown.click();

        WebElement irsStateLetterIssue = driver.findElement(By.xpath("//span[text()='IRS/State Letter']"));
        irsStateLetterIssue.click();

        List <WebElement> selectedOptionsForTags = driver.findElements(By.xpath("//span[text()='IRS/State Letter']"));
        if (selectedOptionsForTags.size() > 1){
            System.out.println("One option selected: Test PASS");
        }else {
            System.out.println("Multiple option selected: Test FAIL");
        }

    }
}
