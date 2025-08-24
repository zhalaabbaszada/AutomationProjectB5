package io.loop.test.base;

import io.loop.test.utilisies.GeneralConstants;
import io.loop.test.utilisies.WebDriverUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    public WebDriver driver;

    @BeforeMethod
    public void setUpMethod (){
        driver = WebDriverUtil.getDriver(GeneralConstants.CHROME);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public  void  TearDown(){
        //driver.close();
    }
}
