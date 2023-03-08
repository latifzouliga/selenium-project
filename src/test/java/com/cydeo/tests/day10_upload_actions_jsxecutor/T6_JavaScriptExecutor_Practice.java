package com.cydeo.tests.day10_upload_actions_jsxecutor;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class T6_JavaScriptExecutor_Practice {

    //TC #6: Scroll using JavascriptExecutor
    //1- Open a chrome browser
    //2- Go to: https://practice.cydeo.com/infinite scroll
    //3- Use below JavaScript method and scroll
    //a. 750 pixels down 10 times.
    //b. 750 pixels up 10 times
    //JavaScript method to use : window.scrollBy 0,0)


    @Test
    public void infinite_scroll_test_using_JSExecutor() {
        //TC #6: Scroll using JavascriptExecutor
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/infinite scroll
        Driver.getDriver().get("https://practice.cydeo.com/infinite_scroll");

        //((JavascriptExecutor) Driver .getDriver ()).executeScript ("window .scrollBy(0,-750)");

        //3- Use below JavaScript method and scroll
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();

        BrowserUtils.sleep(2);

        //a. 750 pixels down 10 times.
        //b. 750 pixels up 10 times
        //JavaScript method to use : window.scrollBy 0,0)

        //window.scrollBy(x,y)

        // scrolling down
        for (int i = 0; i < 3; i++) {
            BrowserUtils.sleep(1);
            jsExecutor.executeScript("window.scrollBy (0,750)");
        }


        // scrolling up
        for (int i = 0; i < 3; i++) {
            BrowserUtils.sleep(1);
            jsExecutor.executeScript("window.scrollBy (0,-750)");
        }

        BrowserUtils.sleep(1);
        for (int i = 0; i < 1000; i++) {
            jsExecutor.executeScript("window.scrollBy (0,750)");
        }
        


    }





}




















