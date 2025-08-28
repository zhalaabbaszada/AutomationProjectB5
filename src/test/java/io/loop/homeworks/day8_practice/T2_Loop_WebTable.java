package io.loop.homeworks.day8_practice;

import io.loop.test.base.TestBase;
import io.loop.test.utilities.LoopcampUtils;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

/*

task2
=============
    1. go to https://loopcamp.vercel.app/web-tables.html
    2. create a method to test given field for a given name
    3. test type
    4. test amount
    5. test date
    6. test street
    7. test city
    8. test state
    9. test zip
    10. test card
    11. test card number
    12. test exp
 */
public class T2_Loop_WebTable extends TestBase {
    @Test
    public void testGivenField() throws InterruptedException {
        driver.get("https://loopcamp.vercel.app/web-tables.html");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String expectedPizzaType = "Thin Crust";
        String actualPizzaType = LoopcampUtils.returnAnyFieldFromTable(driver, "Alexandra Gray", "Pizza type");
        assertEquals(actualPizzaType, expectedPizzaType, "Actual does not match expected");
        System.out.println("actualPizzaType = " + actualPizzaType);

        String expectedAmount = "2";
        String actualAmount = LoopcampUtils.returnAnyFieldFromTable(driver, "Alexandra Gray", "amount");
        assertEquals(actualAmount, expectedAmount, "Actual does not match expected");
        System.out.println("actualAmount = " + actualAmount);

        String expectedDate = "04/15/2021";
        String actualDate = LoopcampUtils.returnAnyFieldFromTable(driver, "Alexandra Gray", "date");
        assertEquals(actualDate, expectedDate, "Actual does not match expected");
        System.out.println("actualDate = " + actualDate);

        String expectedStreet = "7, Miller Street";
        String actualStreet = LoopcampUtils.returnAnyFieldFromTable(driver, "Alexandra Gray", "street");
        assertEquals(actualStreet, expectedStreet, "Actual does not match expected");
        System.out.println("actualStreet = " + actualStreet);

        String expectedCity = "Chicago, IL";
        String actualCity = LoopcampUtils.returnAnyFieldFromTable(driver, "Alexandra Gray", "city");
        assertEquals(actualCity, expectedCity, "Actual does not match expected");
        System.out.println("actualCity = " + actualCity);

        String expectedState = "US";
        String actualState = LoopcampUtils.returnAnyFieldFromTable(driver, "Alexandra Gray", "state");
        assertEquals(actualState, expectedState, "Actual does not match expected");
        System.out.println("actualState = " + actualState);

        String expectedZip = "748";
        String actualZip = LoopcampUtils.returnAnyFieldFromTable(driver, "Alexandra Gray", "zip");
        assertEquals(actualZip, expectedZip, "Actual does not match expected");
        System.out.println("actualZip = " + actualZip);

        String expectedCard = "VISA";
        String actualCard = LoopcampUtils.returnAnyFieldFromTable(driver, "Alexandra Gray", "card");
        assertEquals(actualCard, expectedCard, "Actual does not match expected");
        System.out.println("actualCard = " + actualCard);

        String expectedCardNumber = "321456789012";
        String actualCardNumber = LoopcampUtils.returnAnyFieldFromTable(driver, "Alexandra Gray", "card number");
        assertEquals(actualCardNumber, expectedCardNumber, "Actual does not match expected");
        System.out.println("actualCardNumber = " + actualCardNumber);

        String expectedExp = "02/24";
        String actualExp = LoopcampUtils.returnAnyFieldFromTable(driver, "Alexandra Gray", "exp");
        assertEquals(actualExp, expectedExp, "Actual does not match expected");
        System.out.println("actualExp = " + actualExp);

    }
}
