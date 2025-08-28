package io.loop.test.utilities;

import org.openqa.selenium.WebDriver;

import java.util.Set;

import static org.testng.Assert.assertTrue;

public class BrowserUtils {

    /**
     * validate if driver switched to the expected url or title
     * @param driver
     * @param expectedUrl
     * @param expectedTitle
     * @authpr ZA
     * implements assertion
     */
    public static void switchWindowAndValidate(WebDriver driver, String expectedUrl, String expectedTitle){
        // to lowercase the params in order to avoid miss type
        expectedTitle = expectedTitle.toLowerCase();
        expectedUrl = expectedUrl.toLowerCase();

        // get all window handles, switch one by one and each time check if the url matches expected to stop
        // var windowHandles = driver.getWindowHandles();
        Set <String> windowHandles = driver.getWindowHandles();
        for (String each : windowHandles) {
            driver.switchTo().window(each);
            if (driver.getCurrentUrl().toLowerCase().contains(expectedUrl)){
                break;
            }
        }
        // after stopping on expected url, validate the title
        assertTrue(driver.getTitle().toLowerCase().contains(expectedTitle));
    }

    /**
     * @param driver
     * @param targetTitle
     * @author ZA
     */
    public static void switchToWindow(WebDriver driver, String targetTitle) {
        String origin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().contains(targetTitle)) {
                return;
            }
        }
        driver.switchTo().window(origin);
    }








}
