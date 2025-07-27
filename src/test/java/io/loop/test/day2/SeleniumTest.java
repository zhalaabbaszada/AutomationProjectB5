package io.loop.test.day2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {



        public static void main(String[] args) throws InterruptedException {
            // older version of selenium you need to set up web driver manage
            //WebDriverManager.chromedriver().setup(); - this is coming from boni garcia


          //  ChromeOptions options = new ChromeOptions();
           // options.addArguments("--start-maximized");
           // options.addArguments("--incognito");
            // Setting up to driver
            WebDriver driver = new ChromeDriver();

            // maximize the window
            driver.manage().window().maximize();

            // navigate the page
            driver.get("https://www.loopcamp.io/");

            //navigate to the page
            driver.navigate().to("https://www.google.com");

            //just wait
            Thread.sleep(3000);

            //navigate back to page
            driver.navigate().back();

            //navigate forward
            driver.navigate().forward();

            // refresh
            driver.navigate().refresh();

            //quitting the browser
            driver.quit();
        }
}
