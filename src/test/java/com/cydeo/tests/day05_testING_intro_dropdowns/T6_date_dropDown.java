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
import java.util.List;

public class T6_date_dropDown {

    //TC #6: Selecting date on dropdown and verifying
    //1. Open Chrome browser
    //2. Go to https://practice.cydeo.com/dropdown
    //3. Select “December 1st
    //, 1933” and verify it is selected.
    //Select year using : visible text
    //Select month using : value attribute
    //Select day using : index number

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        //TC #6: Selecting date on dropdown and verifying
        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");

    }

    @Test
    public void date_dropDown_test() {

        //3. Select “December 1st , 1933”
        // select year
        wait(2);
        List<WebElement> years = driver.findElements(By.xpath("//select[@id='year']"));

        for (WebElement each : years) {
            Select select = new Select(each);
            select.selectByVisibleText("1933");
            String actualYear = select.getFirstSelectedOption().getText();
            Assert.assertEquals(actualYear, "1933");
            break;
        }

        wait(2);

        // select month
        List<WebElement> months = driver.findElements(By.xpath("//select[@id='month']"));

        for (WebElement each : months) {
            Select select = new Select(each);
            select.selectByValue("2");
            String actualMonth = select.getFirstSelectedOption().getText();
            Assert.assertEquals(actualMonth, "March");
            break;
        }

        // select day
        List<WebElement> days = driver.findElements(By.xpath("//select[@id='day']"));

        for (WebElement each : days) {
            Select select = new Select(each);
            select.selectByIndex(6);
            String actualDay = select.getFirstSelectedOption().getText();
            Assert.assertEquals(actualDay, "7");
            break;
        }
        wait(5);

        /*
        // use visible text string for expected day
        String year = selectDate(driver,"year","1933");
        Assert.assertEquals(year,"1933");
        wait(2);

        // use value string for expected month
        String month = selectDate(driver,"month","2");
        Assert.assertEquals(month,"March");
        wait(2);

        // use int index for expected day
        String day = selectDate(driver,"day",2);
        Assert.assertEquals(day,"3");

 */

        // and verify it is selected.

        //Select year using : visible text
        //Select month using : value attribute
        //Select day using : index number

    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    private static void wait(int seconds){
        try {
            Thread.sleep(1000*seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    /*
    private static <T> String selectDate(WebDriver driver, T id, T expected){

        List<WebElement> days = driver.findElements(By.xpath("//select[@id='"+id+"']"));

        for (WebElement each : days) {
            Select select = new Select(each);
            if (expected.equals((T)"year")){
                select.selectByVisibleText((String) expected);
            }
            if (expected.equals("month")){
                select.selectByValue((String) expected);
            }else {
                select.selectByIndex((Integer) expected);
            }
            return select.getFirstSelectedOption().getText();


        }
        return null;
    }

     */



}















