package io.loop.test.day9;

import io.loop.test.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.time.Duration;

/*
    1. Go to “http://demo.guru99.com/test/upload”
    2. Upload file into Choose File
    3. Click terms of service check box
    4. Click Submit File button
    5. Validate expected message appeared. Expected: “1 file has been successfully uploaded.
    */
public class T6_uploads {
    @Test
    public void upload_file(){
        Driver.getDriver().get("http://demo.guru99.com/test/upload/");
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        WebElement chooseFile = Driver.getDriver().findElement(By.xpath("//input[@type='text']"));
        String path = "\"C:\\Users\\DELL\\Desktop\\text.txt\"";
        chooseFile.sendKeys(path);

        WebElement checkBox = Driver.getDriver().findElement(By.xpath("//input[@type='checkbox']"));
        checkBox.click();

        WebElement submitButton = Driver.getDriver().findElement(By.xpath("//button[@id='submitbutton']"));
        submitButton.click();

    }

}
