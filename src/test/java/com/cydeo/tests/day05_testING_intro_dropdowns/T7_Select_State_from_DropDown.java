package com.cydeo.tests.day05_testING_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T7_Select_State_from_DropDown {

    //TC #7: Selecting state from State dropdown and verifying result
    //1. Open Chrome browser
    //2. Go to http://practice.cybertekschool.com/dropdown
    //3. Select Illinois
    //4. Select Virginia
    //5. Select California
    //6. Verify final selected option is California.
    //Use all Select options. (visible text, value, index)

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        //TC #7: Selecting state from State dropdown and verifying result
        //1. Open Chrome browser
        //2. Go to http://practice.cybertekschool.com/dropdown

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://practice.cybertekschool.com/dropdown");

    }

    @Test
    public void test() {

        Select selectState = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        wait(2);
        //3. Select Illinois
        selectState.selectByVisibleText("Illinois");

        wait(2);
        //4. Select Virginia
        selectState.selectByValue("VA");

        wait(2);
        //5. Select California
        selectState.selectByIndex(5);

        //6. Verify final selected option is California.
        String actualState = selectState.getFirstSelectedOption().getText();
        String expectedState = "California";

        // verifying
        Assert.assertEquals(expectedState, actualState);

        //Use all Select options. (visible text, value, index)

        wait(7);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


    public static void wait(int seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}




















