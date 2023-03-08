package com.cydeo.tests.day11_pom_explicit_waits;

import com.cydeo.utilities.Driver;
import org.testng.annotations.Test;

public class Understanding_closeDriver_method {


    @Test
    public void test1() {
        Driver.getDriver().get("https://google.com");
        //Driver.getDriver().quit(); // terminate the session
        Driver.closeDriver(); // this method terminated the session but it will re-assign null value to the driver
    }

    @Test
    public void test2() {
        Driver.getDriver().get("https://google.com");
        //Driver.getDriver().quit(); // terminate the session
        // this test will not be executed because the session was terminated
        Driver.closeDriver(); // this method terminated the session but it will re-assign null value to the driver
        // this method will be executed because the driver value is null which means that .getDriver() method will
        // be executed and create a new session
    }

    @Test
    public void test3() {
        Driver.getDriver().get("https://google.com");
        //Driver.getDriver().quit(); // terminate the session
        // this test will not be executed because the session was terminated
        Driver.closeDriver(); // this method terminated the session but it will re-assign null value to the driver
        // this method will be executed because the driver value is null which means that .getDriver() method will
        // be executed and create a new session
    }
}
