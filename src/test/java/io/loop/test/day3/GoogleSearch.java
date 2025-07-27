package io.loop.test.day3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Navigate to Google search
 * maximize the page
 * get title of the page
 * get url of the page
 * validate the title, expected title is "Google"
 * validate the url of the page, expected url is "https://www.google.com/"
 * close the browser
 */
public class GoogleSearch {
    public static void main(String[] args) {

        // in selenium 3 we had to set up the driver, for that we need webdrivermanager libraries
        // WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();


        driver.navigate().to("https://www.google.com");

        driver.manage().window().maximize();

        //excepted
        String expectedTitle = "Google";

        //actual
        String actualTitle = driver.getTitle();

        //validation
        if (actualTitle.contains(expectedTitle)){
            System.out.println("Actual title: " + actualTitle + ", matches excepted title: " + expectedTitle + ". => TEST PASS");
        }else {
            System.err.println("Actual title: " + actualTitle + ", DOES NOT matches excepted title: " + expectedTitle + ". => TEST FAIL");
        }

        //expected URL
        String expectedURL = "https://www.google.com";

        // actual URL
        String actualURL = driver.getCurrentUrl();

        if(actualURL.contains(expectedURL)){
            System.out.println("Actual URL: " + actualURL + ", matches expected URL: " + expectedURL + ". TEST PASS");
        }else {
            System.out.println("Actual URL: " + actualURL + ", DOES NOT matches expected URL: " + expectedURL + ". TEST FAIL");
        }

        driver.quit();
    }
}
