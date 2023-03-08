package com.cydeo.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Set;

public class BrowserUtils {

    /** This will be storing only the methods that can be used across the project */

    /** pauses the execution for a given number of seconds */
    public static void sleep(int seconds){

        seconds *= 1000;
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            // do nothing
        }

    }

    /** switching to a window with the expectedURL and verify the title */
    public static void switchWindowAndVerify(WebDriver driver, String expectedInURL, String expectedTitle){

        Set<String > handles = driver.getWindowHandles();

        // looping through window handles
        for (String eachHandle : handles) {

            // condition for switching to a window
            driver.switchTo().window(eachHandle);
            System.out.println("Current URL: "+driver.getCurrentUrl());
            if (driver.getCurrentUrl().contains(expectedInURL)){
                // switching to window
                break;
            }
        }

        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);
        Assert.assertTrue(actualTitle.contains(expectedTitle));


    }

    /** verify and check if the actual title matches the expected title */
    public static void verifyTitle(WebDriver driver, String  expectedTitle){

        Assert.assertEquals(driver.getTitle(),expectedTitle);

    }

    /** check and verify the actual title if it contains an expected word */
    public static void verifyTitleContains(WebDriver driver, String  expectedInTitle){

        Assert.assertTrue(driver.getTitle().contains(expectedInTitle));

    }

    /** this method takes a webElement as a target and wait until it disappears from the DOM */
    public static void waitForInvisibilityOf(WebElement target){

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(target));

    }

    /** this method takes a string as argument, and it will be passed as a wait condition */
    public static void waitForTitleToContain(String title){

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains(title));

    }



}
