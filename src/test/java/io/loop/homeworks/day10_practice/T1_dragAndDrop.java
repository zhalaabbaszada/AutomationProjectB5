package io.loop.homeworks.day10_practice;

import io.loop.pages.LoopPracticeDragDropPage;
import io.loop.test.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/*
task1
1. Open a chrome browser
2. Go to: https://loopcamp.vercel.app/drag-and-drop-circles.html
3. Click and hold small circle
4. Move it on top of the big circle
5. validate “Now drop…” text appears on big circ

task2
1. Open a chrome browser
2. Go to: https://loopcamp.vercel.app/drag-and-drop-circles.html
3. Click and hold small circle
4. Dropped anywhere outside of big circle
5. validate “Try again!” text appears on big circle
 */
public class T1_dragAndDrop {
    LoopPracticeDragDropPage dragAndDropPage;

    @Test
    public void dragAndDrop(){
        Driver.getDriver().get("https://loopcamp.vercel.app/drag-and-drop-circles.html");
        dragAndDropPage = new LoopPracticeDragDropPage();
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(dragAndDropPage.smallCircle)
                .clickAndHold()
                .moveByOffset(0, -200)
                .pause(3000)
                .perform();
        assertEquals(dragAndDropPage.bigCircle.getText(), "Now drop...", "Actual does not match expected" );
    }

    @Test
    public void dragAndDrop2(){
        Driver.getDriver().get("https://loopcamp.vercel.app/drag-and-drop-circles.html");
        dragAndDropPage = new LoopPracticeDragDropPage();
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(dragAndDropPage.smallCircle)
                .clickAndHold()
                .moveByOffset(100, 100)
                .pause(3000)
                .release()
                .pause(3000)
                .perform();
        assertEquals(dragAndDropPage.bigCircle.getText(), "Try again!", "Actual does not match expected" );
    }
}
