package com.cydeo.tests.day12_review;

import com.cydeo.pages.DynamicControlsPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class T2_T3_Explicit_Wait_Practices {


    DynamicControlsPage dynamicControlsPage;
    //WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/dynamic_controls
        Driver.getDriver().get("https://practice.cydeo.com/dynamic_controls");

        dynamicControlsPage = new DynamicControlsPage();

        //wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));


    }

    @Test
    public void t1_remove_checkbox_test() {

        //TC #2: Explicit wait practice



        //3- Click to "Remove" button
        dynamicControlsPage.removeButton.click();

        //4- Wait until "loading bar disappears"
        //wait.until(ExpectedConditions.invisibilityOf(dynamicControlsPage.loadingBar));
        BrowserUtils.waitForInvisibilityOf(dynamicControlsPage.loadingBar);

        //5- Verify:
        //a. Checkbox is not displayed
        try {
            // webElement disappears from the page
            // false if appears and true if disappears
            Assert.assertFalse(dynamicControlsPage.checkBox.isDisplayed());
        }catch (NoSuchElementException e){
            // this line will be printed if the webElement disappears from the DOM
            // if this line is printed the test is passed
            System.out.println("Checkbox is not displayed");
            Assert.assertTrue(true);
        }

        //b. "It's gone!" message is displayed.
        Assert.assertTrue(dynamicControlsPage.goneMessage.isDisplayed()); // expected true
        //NOTE: FOLLOW POM

        Assert.assertEquals(dynamicControlsPage.goneMessage.getText(),"It's gone!");

    }

    @Test
    public void t2_enable_input_box_test() {

        //TC #3: Explicit wait practice
        //3- Cick to "Enable" button
         dynamicControlsPage.enableButton.click();

        //4- Wait until "loading bar disappears"
        //wait.until(ExpectedConditions.invisibilityOf(dynamicControlsPage.loadingBar));
        BrowserUtils.waitForInvisibilityOf(dynamicControlsPage.loadingBar);

        //5- Verify:
        //a. Input box is enabled.
        Assert.assertTrue(dynamicControlsPage.inputBox.isDisplayed(),"Input box is not enabled");

        //b. "it's enabled!" message is displayed.
        Assert.assertTrue(dynamicControlsPage.itsEnabledMessage.isDisplayed(),"\"It's enabled message\" is not displayed");

        Assert.assertEquals(dynamicControlsPage.itsEnabledMessage.getText(),"It's enabled!");


    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
}
