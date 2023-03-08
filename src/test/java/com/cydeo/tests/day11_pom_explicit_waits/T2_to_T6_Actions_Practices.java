package com.cydeo.tests.day11_pom_explicit_waits;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class T2_to_T6_Actions_Practices {


    @BeforeMethod
    public void setUp() {
        //1. Go to https://practice.cydeo.com/drag and drop circles I
        Driver.getDriver().get("https://practice.cydeo.com/drag_and_drop_circles");
    }

    @Test
    public void test2_default_value_verification(){

        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));

        //-Text in big circle changed to: "Drag the small circle here
        Assert.assertEquals(bigCircle.getText(),"Drag the small circle here.");
    }

    @Test
    public void test3_drop_into_big_circle() {

        //TC2 #: Drag and drop default value verification

        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));

        Actions actions = new Actions(Driver.getDriver());

        // drag and drop small circle into big circle
        //actions.dragAndDrop(smallCircle, bigCircle)actions.perform();

        actions.clickAndHold(smallCircle)
                .pause(1000)
                .moveToElement(bigCircle)
                .pause(1000)
                .release()
                .perform();

        //2. Verify big circle text is as below.
        // expected: "You did great!"
        String dropTargetText = bigCircle.getText();

        //3. Assert:
        Assert.assertEquals(dropTargetText,"You did great!");
    }

    @Test
    public void test4_click_and_hold_small_circle() {


        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));

        WebElement cydeoLink = Driver.getDriver().findElement(By.linkText("CYDEO"));

        Actions actions = new Actions(Driver.getDriver());

        actions.clickAndHold(smallCircle)
                .pause(1000)
                //.dragAndDropBy(smallCircle,100,100)
                .moveToElement(cydeoLink)
                .pause(1000)
                .perform();


        String dropTargetText = bigCircle.getText();
        Assert.assertEquals(dropTargetText,"Drop here.");


        BrowserUtils.sleep(3);

    }

    @Test
    public void test5_drag_and_drop_outside_big_circle() {
        //TC2 #: Drag and drop default value verification

        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));

        Actions actions = new Actions(Driver.getDriver());

        // moving the small circle and dropping it outside the big circle
        actions.clickAndHold(smallCircle)
                .pause(1000)
                .dragAndDropBy(smallCircle,0,100)
                .pause(1000)
                .perform();

        //2. Verify big circle text is as below.
        // expected: "Try again!"
        String dropTargetText = bigCircle.getText();

        //3. Assert:
        Assert.assertEquals(dropTargetText,"Try again!");
    }

    @Test
    public void test6_big_circle_hovering_text() {
        //Drag the small circle on top of the big circle, hold it, and verify.
        WebElement smallCircle = Driver.getDriver().findElement(By.id("draggable"));
        WebElement bigCircle = Driver.getDriver().findElement(By.id("droptarget"));

        Actions actions = new Actions(Driver.getDriver());

        // moving the small circle to the big circle and hold
        actions.clickAndHold(smallCircle)
                .pause(1000)
                .moveToElement(bigCircle)
                .pause(1000)
                .perform();

        //2. Verify big circle text is as below.
        // expected: "Now drop..."
        String dropTargetText = bigCircle.getText();

        //3. Assert:
        Assert.assertEquals(dropTargetText,"Now drop...");
    }

    @AfterMethod
    public void tearDown() {
        BrowserUtils.sleep(3);
        Driver.closeDriver();
    }
}
