package io.loop.test.day5;

import io.loop.test.utilities.GeneralConstants;
import io.loop.test.utilities.WebDriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class T3_findElements {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.CHROME);
        driver.manage().window().maximize();

        driver.get("https://www.nba.com");
        Thread.sleep(10000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // selenium 4
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); - Selenium 3

        List <WebElement> nbaLinks= driver.findElements(By.tagName("a"));
        System.out.println("nbaLinks.size() = " + nbaLinks.size());

        List <WebElement> nbaLinksWithXPath = driver.findElements(By.xpath("//a"));
        System.out.println("nbaLinksWithXPath = " + nbaLinksWithXPath);

        for (WebElement nbaLink : nbaLinks){
            if (!nbaLink.getText().equals("")){
                System.out.println("nbaLink.getText() = " + nbaLink.getText());
                System.out.println("nbaLink.getDomAttribute(\"href\") = " + nbaLink.getDomAttribute("href"));
            }
        }

        for (int i = 0; i < nbaLinks.size(); i++) {
            if(!nbaLinks.get(i).getText().equals("")){
                System.out.println("nbaLinks.get(i).getText() = " + nbaLinks.get(i).getText());
                System.out.println("nbaLinks.get(i).getAttribute(\"href\") = " + nbaLinks.get(i).getAttribute("href"));
            }
        }

    }

}
