package com.cydeo.tests.day05_testING_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T8_Select_Value_From_NonSelect_DropDown {

    //TC #8: Selecting value from non-select dropdown
    //1. Open Chrome browser
    //2. Go to https://practice.cydeo.com/dropdown
    //3. Click to non-select dropdown
    //4. Select Facebook from dropdown
    //5. Verify title is “Facebook - Log In or Sign Up”

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        //TC #8: Selecting value from non-select dropdown
        //1. Open Chrome browser
        //2. Go to https://practice.cydeo.com/dropdown
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practice.cydeo.com/dropdown");
        wait(3);
    }

    @Test
    public void test() {
        WebElement dropDownLink = driver.findElement(By.xpath("//a[@role='button']"));

        //3. Click to non-select dropdown
        dropDownLink.click();

        //4. Select Facebook from dropdown
        WebElement facebookLink = driver.findElement(By.xpath("//a[.='Facebook']"));

        facebookLink.click();

        //5. Verify title is “Facebook - Log in or Sign up”
        String actualTitle = driver.getTitle();
        String expectedTitle = "Facebook - log in or sign up";

        Assert.assertEquals(actualTitle, expectedTitle);



    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    private void wait(int seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
