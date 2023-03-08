package com.cydeo.tests.day07_webTable_utilities_javafaker;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class T1_WindowsHandling {

    //TC #1: Window Handle practice
    //1. Create new test and make setups
    //2. Go to:https://www.amazon.com
    //3. Copy and paste the lines from below into your class
    //4. Create a logic to switch to the tab where Etsy.com is open
    //5. Assert:Title contains “Etsy”
    //Lines to be pasted:
    //((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
    //((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
    //((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");
    //These lines will simply open new tabs using something called JavascriptExecutor and get those pages.
    // We will learn JavascriptExecutor later as well.

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        //1. Create new test and make setups
        //2. Go to:https://www.amazon.com
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.com");


    }

    @Test
    public void window_handling_test_1() {

        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");


        String mainHandle = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();

        handles.forEach(p -> {              // looping through windows

            driver.switchTo().window(p);    // switching windows
            System.out.println(driver.getTitle());     // printing windows titles

            if (driver.getTitle().contains("Etsy")) {  // stopping at Etsy.com

                // locating search box in etsy website
                WebElement searchBox = driver.findElement(By.id("global-enhancements-search-query"));
                searchBox.sendKeys("Wooden spoon", Keys.ENTER);
                WebElement price = driver.findElement(By.cssSelector("p.wt-text-title-01.lc-price"));
                price.click();

                driver.switchTo().window(driver.getWindowHandle()); // switching to selected wooden spoon
                System.out.println(driver.getTitle());
                Assert.assertTrue(driver.getTitle().contains("Etsy"));

            }

        });

        driver.switchTo().window(mainHandle);


    }

    @Test
    public void window_handling_test_2() {

        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");


        BrowserUtils.switchWindowAndVerify(driver,"etsy","Etsy");

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
