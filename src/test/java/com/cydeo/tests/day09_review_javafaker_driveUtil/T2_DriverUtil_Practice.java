package com.cydeo.tests.day09_review_javafaker_driveUtil;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
public class T2_DriverUtil_Practice {

    //TC #1: Bing search
    //1- Open a Chrome browser
    //2- Go to: https://www.bing.com
    //3- Write "apple" in search box 4- Verify title:
    //Expected: apple - Search

    @Test
    public void bing_search_test1() {

        //https://www.bing.com
        Driver.getDriver().get(ConfigurationReader.getProperty("bingURL"));
        // locating bing search box
        WebElement bingSearchBox = Driver.getDriver().findElement(By.id("sb_form_q"));


        // sending a text to search box
        bingSearchBox.sendKeys(ConfigurationReader.getProperty("bing.search.keyword"), Keys.ENTER);

        BrowserUtils.sleep(2);
        //Verify title
        //Expected title: apple - Search
        BrowserUtils.verifyTitle(Driver.getDriver(), ConfigurationReader.getProperty("bing.search.title"));


    }

    @Test
    public void bing_search_test2() {

        //https://www.bing.com
        Driver.getDriver().get(ConfigurationReader.getProperty("bingURL"));
        // locating bing search box
        WebElement bingSearchBox = Driver.getDriver().findElement(By.id("sb_form_q"));


        // sending a text to search box
        bingSearchBox.sendKeys(ConfigurationReader.getProperty("bing.search.keyword"), Keys.ENTER);

        BrowserUtils.sleep(2);
        //Verify title
        //Expected title: apple - Search
        BrowserUtils.verifyTitle(Driver.getDriver(), ConfigurationReader.getProperty("bing.search.title"));


    }

    @Test
    public void bing_search_test3() {

        //https://www.bing.com
        Driver.getDriver().get(ConfigurationReader.getProperty("bingURL"));
        // locating bing search box
        WebElement bingSearchBox = Driver.getDriver().findElement(By.id("sb_form_q"));


        // sending a text to search box
        bingSearchBox.sendKeys(ConfigurationReader.getProperty("bing.search.keyword2"), Keys.ENTER);

        BrowserUtils.sleep(2);
        //Verify title
        //Expected title: apple - Search
        BrowserUtils.verifyTitle(Driver.getDriver(), ConfigurationReader.getProperty("bing.search.title2"));


    }


    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }


}
