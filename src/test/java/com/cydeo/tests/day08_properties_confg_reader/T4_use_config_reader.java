package com.cydeo.tests.day08_properties_confg_reader;

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

public class T4_use_config_reader {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        //1- Open a chrome browser
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2 - Go to: https://www.gpogle.com
        driver.get(ConfigurationReader.getProperty("googleURL"));
    }
    @Test
    public void google_search_test() {
        //TC #4: Google search
        // locating google search box
        WebElement googleSearchBox = driver.findElement(By.name("q"));

        BrowserUtils.sleep(2);
        // 3- Write "apple" in search box 4- Verify title:
        googleSearchBox.sendKeys(ConfigurationReader.getProperty("search.keyword"), Keys.ENTER);

        BrowserUtils.sleep(2);
        //Expected: apple - Google Search
        BrowserUtils.verifyTitle(driver,ConfigurationReader.getProperty("title"));

        BrowserUtils.sleep(2);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
