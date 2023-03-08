package com.cydeo.tests.day12_review;

import com.cydeo.pages.W3Page;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_DoubleClick_Practice {


    @Test
    public void t1_double_click_test() {
        //TC #1: Double Click Test
        //1. Go to
        //https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2
        Driver.getDriver().get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");

        W3Page w3Page = new W3Page();
        //2. Switch to itrame.
        Driver.getDriver().switchTo().frame("iframeResult");

        //3. DoubleClick on the text "Double-click me to change my text color."
        Actions actions = new Actions(Driver.getDriver());
        actions.doubleClick(w3Page.paragraph).perform();


        //4. Assert: Text's "style" attribute value contains "red".
        //w3Page.styleColor.getAttribute("style");
        String actualColor = w3Page.paragraph.getAttribute("style");

        Assert.assertTrue(actualColor.contains("red"));

        //NOTE: FOLLOW POM
        Driver.closeDriver();
    }
}
