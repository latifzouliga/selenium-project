package com.cydeo.tests.day09_review_javafaker_driveUtil;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T1_Bing_Search {

    //TC #1: Bing search
    //1- Open a Chrome browser
    //2- Go to: https://www.bing.com
    //3- Write "apple" in search box 4- Verify title:
    //Expected: apple - Search
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //https://www.bing.com
        driver.get(ConfigurationReader.getProperty("bingURL"));
    }

    @Test
    public void bing_search_test() {

        // locating bing search box
        WebElement bingSearchBox = driver.findElement(By.id("sb_form_q"));

        BrowserUtils.sleep(2);
        // sending a text to search box
        bingSearchBox.sendKeys(ConfigurationReader.getProperty("bing.search.keyword"), Keys.ENTER);

        BrowserUtils.sleep(2);
        //Verify title
        //Expected title: apple - Search
        BrowserUtils.verifyTitle(driver, ConfigurationReader.getProperty("bing.search.title"));

        BrowserUtils.sleep(2);

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
