package com.cydeo.tests.browser_pops_handling;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Auth_Popups_handling {


    @Test
    public void test() {

        // for handling Auth popups, we need to pass username and password in the URL
        // let's assume that the username is admin and password is admin
        // in this case we need to pass then between the double forward slashes and the domain name

        // actual URL is                              "https://the-internet.herokuapp.com/basic_auth"
        // URL after passing username and password   "https://admin:admin@the-internet.herokuapp.com/basic_auth"

        Driver.getDriver().get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        WebElement element = Driver.getDriver().findElement(By.tagName("p"));

        String actualText = element.getText();
        String expectedText = "Congratulations! You must have the proper credentials.";

        Assert.assertTrue(actualText.contains(expectedText));


    }
}
