package com.cydeo.tests.day05_testING_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T5_dropDown_intro {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        //TC#5: Verifying “Simple dropdown” and “State selection” dropdown
        //default values
        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");
    }


    @Test
    public void simple_DropDowns_test() {

        //3. Verify “Simple dropdown” default selected value is correct
        //Expected: “Please select an option”
        WebElement simpleDropDown = driver.findElement(By.cssSelector("select#dropdown"));
        Select dropDown = new Select(simpleDropDown);

        WebElement stateSelection = dropDown.getFirstSelectedOption();


        String expectedDefaultSelection = "Please select an option";
        String actualDefaultSelection = stateSelection.getText();

        Assert.assertEquals(expectedDefaultSelection, actualDefaultSelection);

        wait(3);

    }

    @Test
    public void state_dropDown_test() {
        //4. Verify “State selection” default selected value is correct
        //Expected: "select an option"

        Select dropDown = new Select(driver.findElement(By.id("state")));

        String actualDefaultSelection = dropDown.getFirstSelectedOption().getText();

        String expectedDefaultSelection = "Select a State";

        Assert.assertEquals(actualDefaultSelection, expectedDefaultSelection);

        wait(3);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    private static void wait(int seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
