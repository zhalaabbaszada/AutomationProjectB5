package io.loop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {



        public static void main(String[] args) {
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.loopcamp.io/");
        }
}
