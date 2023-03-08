package com.cydeo.tests.day10_upload_actions_jsxecutor;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class T3_Actions_Hover {


    @Test
    public void hovering_test() {

        //TC #3: Hover Test
        //1. Go to https://practice.cydeo.com/hovers
        Driver.getDriver().get(ConfigurationReader.getProperty("env3"));

        WebElement image1 = Driver.getDriver().findElement(By.xpath("(//img)[1]"));
        WebElement image2 = Driver.getDriver().findElement(By.xpath("(//img)[2]"));
        WebElement image3 = Driver.getDriver().findElement(By.xpath("(//img)[3]"));

        //locate all users
        WebElement user1 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user1']"));
        WebElement user2 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user2']"));
        WebElement user3 = Driver.getDriver().findElement(By.xpath("//h5[.='name: user3']"));

        // To be able to hover on image, we need to create Actions class object,
        Actions action = new Actions(Driver.getDriver());

        BrowserUtils.sleep(3);
        //2. Hover over to first image
        action.moveToElement(image1).perform();

        //3. Assert:
        //a. "name: user" is displayed
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(user1.isDisplayed());
        softAssert.assertAll();

        BrowserUtils.sleep(2);
        //4. Hover over to secondImage
        action.moveToElement(image2).perform();

        //5. Assert:
        //a. "name: user2" is displayed
        Assert.assertTrue(user2.isDisplayed());

        BrowserUtils.sleep(2);
        //6. Hover over to third image
        //7. Confirm:
        //a. "name: users" is displayed
        action.moveToElement(image3).perform();
        softAssert.assertTrue(user3.isDisplayed());
        softAssert.assertAll();

        BrowserUtils.sleep(2);


        Driver.closeDriver();

    }



}


























