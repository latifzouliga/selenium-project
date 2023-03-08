package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class T5_windows_practice {

    //1. Open browser
    //2. Go to website: https://practice.cydeo.com/windows
    //4. Assert: Title is “Windows”
    //5. Click to: “Click Here” link
    //6. Switch to new Window. We need to use driver.getWindowHandles() method

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        //1. Open browser
        //2. Go to website: https://practice.cydeo.com/windows
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practice.cydeo.com/windows");

    }

    @Test
    public void multiple_windows_test() {
        //4. Assert: Title is “Windows”
        String actualTitle = driver.getTitle();
        String expectedTitle = "Windows";

        String mainHandle = driver.getWindowHandle();

        System.out.println(driver.getTitle());


        Assert.assertEquals(actualTitle, expectedTitle);
        //5. Click to: “Click Here” link
        driver.findElement(By.xpath("//a[@target='_blank']")).click();

        //6. Switch to new Window. We need to use driver.getWindowHandles() method
        Set<String> windowTitle = driver.getWindowHandles();

        //windowTitle.forEach(p -> driver.switchTo().window(p));
        windowTitle.forEach(driver.switchTo()::window);

        System.out.println(driver.getTitle());

        actualTitle = driver.getTitle();
        expectedTitle = "New Window";

        //7. Assert: Title is "New Window"
        Assert.assertEquals(actualTitle,expectedTitle);

        driver.switchTo().window(mainHandle);

        System.out.println(driver.getTitle());

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
