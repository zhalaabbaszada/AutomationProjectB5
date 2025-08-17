package io.loop.test.day5;

import io.loop.test.utilisies.GeneralConstants;
import io.loop.test.utilisies.LoopCampConstants;
import io.loop.test.utilisies.WebDriverUtil;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

/*
    https://loopcamp.vercel.app/radio-buttons.html
    wait implicitly 10 seconds
    is selected
    is enabled
     */
public class T4_radioButton {
    public static void main(String[] args) {
        WebDriver driver = WebDriverUtil.getDriver(GeneralConstants.CHROME);
        driver.manage().window().maximize();

        driver.get(LoopCampConstants.RADIOBUTTON_URL);

        //selenium 4 wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}
