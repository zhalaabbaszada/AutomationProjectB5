package io.loop.test.day9;

import io.loop.test.base.TestBase;
import io.loop.test.utilities.PizzaOrderWebTableUtil;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/*
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
public class T1_Pizza_Order extends TestBase {

    @Test
    public void testPizzaOrder(){
        driver.get("https://loopcamp.vercel.app/web-tables.html");
        String name = "Bart Fisher";
        String expectedPizzaType = "Cheese";
        String actualPizzaType = PizzaOrderWebTableUtil.returnFieldValue(driver, name, "pizza type");
        assertEquals(actualPizzaType, expectedPizzaType, "Actual does not match expected");
    }
}
