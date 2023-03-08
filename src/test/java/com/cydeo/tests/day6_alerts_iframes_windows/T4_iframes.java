package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T4_iframes {
    //1. Open browser
    //2. Create  new test and make set ups
    //3. Go to website: https://practice.cydeo.com/iframe
    //4. Assert: “Your content goes here.” Text is displayed.
    //5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor”

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        //1. Open browser
        //2. Create  new test and make set ups
        //3. Go to website: https://practice.cydeo.com/iframe
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practice.cydeo.com/iframe");

    }

    @Test
    public void test(){

        // we have to switch to iframe to be abe to locate the webElement

        //option 1: "id" attribute value or name attribute
        driver.switchTo().frame("mce_0_ifr");

        //option 2: switch using index number
        driver.switchTo().frame(0);

        //option 3: switch using WebElement
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']")));

        WebElement paragraph = driver.findElement(By.tagName("p"));

        paragraph.getText();

        //4. Assert: “Your content goes here.” Text is displayed.
        Assert.assertTrue(paragraph.isDisplayed());

        //5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor”
        // switch back to parent frame
        driver.switchTo().parentFrame();
        //driver.switchTo().defaultContent();
        WebElement h3 = driver.findElement(By.tagName("h3"));

        Assert.assertTrue(h3.isDisplayed());


    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
