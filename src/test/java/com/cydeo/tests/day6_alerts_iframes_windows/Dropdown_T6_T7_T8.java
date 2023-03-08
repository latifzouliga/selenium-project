package com.cydeo.tests.day6_alerts_iframes_windows;

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
import java.util.ArrayList;
import java.util.List;

public class Dropdown_T6_T7_T8 {

    //TC #6: Selecting date on dropdown and verifying
    //1. Open Chrome browser
    //2. Go to https://practice.cydeo.com/dropdown
    //3. Select “December 1st, 1933” and verify it is selected.
    //Locate dropdowns and pass them in Select object constructors
    //Select year using : visible text
    //Select month using : value attribute
    //Select day using : index number
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        //TC #6: Selecting date on dropdown and verifying
        //1. Open Chrome browser
        //2. Go to https://practice.cydeo.com/dropdown
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice.cydeo.com/dropdown");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void dropDown_T6_test() {
        //3. Select “December 1st, 1933” and verify it is selected.
        //Locate dropdowns and pass them in Select object constructors

        //Select year
        WebElement year1 = driver.findElement(By.cssSelector("select[id='year']"));
        WebElement year2 = driver.findElement(By.id("year"));
        WebElement year3 = driver.findElement(By.xpath("//select[@id='year']"));
        WebElement year4 = driver.findElement(By.xpath("(//div[@id='content']/select)[2]"));
        WebElement year5 = driver.findElement(By.xpath("//option[@value='2022']/.."));

        //Select year using : visible text
        Select selectYear = new Select(year5);
        selectYear.selectByVisibleText("1933");


        //Select month
        WebElement month1 = driver.findElement(By.id("month"));
        WebElement month2 = driver.findElement(By.cssSelector("select#month"));

        //Select month using : value attribute
        Select selectMonth = new Select(month2);
        selectMonth.selectByValue("11");

        //Select day
        WebElement day = driver.findElement(By.id("day"));

        //Select day using : index number
        Select selectDay = new Select(day);
        selectDay.selectByIndex(0);

        String expectedYear = "1933";
        String expectedMonth = "December";
        String expectedDay = "1";

        String actualYear = selectYear.getFirstSelectedOption().getText();
        String actualMonth = selectMonth.getFirstSelectedOption().getText();
        String actualDay = selectDay.getFirstSelectedOption().getText();


        Assert.assertEquals(actualYear, expectedYear);
        Assert.assertEquals(actualMonth, expectedMonth);
        Assert.assertEquals(actualDay, expectedDay);

    }

    @Test
    public void dropDown_T7_test() {
        //TC #7: Selecting state from State dropdown and verifying result
        //locate the dropdown and create select object
        Select selectStated = new Select(driver.findElement(By.id("state")));

        //Use all Select options. (visible text, value, index)
        //3. Select Illinois
        selectStated.selectByVisibleText("Illinois");

        //4. Select Virginia
        selectStated.selectByValue("VA");

        //5. Select California
        selectStated.selectByIndex(5);

        //6. Verify final selected option is California.

        String expectedState = "California";
        String actualState = selectStated.getFirstSelectedOption().getText();

        Assert.assertEquals(actualState, expectedState);

    }

    @Test
    public void dropDown_T8_test(){
        //TC #8: Selecting value from non-select dropdown
        //3. Click to non-select dropdown
        WebElement dropDownLink1 = driver.findElement(By.cssSelector("a#dropdownMenuLink"));
        WebElement dropDownLink2 = driver.findElement(By.linkText("Dropdown link"));
        WebElement dropDownLink3 = driver.findElement(By.partialLinkText("Dropdown link"));

        dropDownLink3.click();


        //locate the non-select dropdown
        //4. Select Facebook from dropdown
        driver.findElement(By.xpath("//a[.='Facebook']")).click();

        //5. Verify title is  "Facebook - log in or sign up"
        Assert.assertEquals(driver.getTitle(),"Facebook - log in or sign up");
    }

    @Test
    public void getYearOptions() {
        Select select = new Select(driver.findElement(By.id("year")));

        List<WebElement> yearElements = select.getOptions();

        List<String> years = new ArrayList<>();

        // adding WebElements texts to String List
        yearElements.forEach(p -> years.add(p.getText()));

        // prints all the states in separate lines
        years.forEach(System.out::println);

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}


















