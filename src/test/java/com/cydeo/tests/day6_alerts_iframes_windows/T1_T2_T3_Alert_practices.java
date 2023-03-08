package com.cydeo.tests.day6_alerts_iframes_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T1_T2_T3_Alert_practices {
    //1. Open browser
    //2. Go to website: https://practice.cydeo.com/javascript_alerts
    //TC #1: Information alert practice
    //3. Click to “Click for JS Alert” button
    //4. Click to OK button from the alert
    //5. Verify “You successfully clicked an alert” text is displayed.

    //Failure message will only be displayed if assertion fails:
    //TC #2: Confirmation alert practice
    //3. Click to “Click for JS Confirm” button
    //4. Click to OK button from the alert
    //5. Verify “You clicked: Ok” text is displayed.

    WebDriver driver;
    Alert alert;

    @BeforeMethod
    public void setUp() {
        //1. Open browser
        //2. Go to website: https://practice.cydeo.com/javascript_alerts
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://practice.cydeo.com/javascript_alerts");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void conformation_alert_test1() {
        //TC #1: Information alert practice
        //3. Click to “Click for JS Alert” button
        driver.findElement(By.cssSelector("button.btn.btn-primary")).click();

        //4. Click to OK button from the alert
        alert = driver.switchTo().alert();
        alert.accept();

        //5. Verify “You successfully clicked an alert” text is displayed.
        WebElement alertText = driver.findElement(By.id("result"));

        Assert.assertTrue(alertText.isDisplayed(), "Result text is NOT displayed on the page!");

        String actualText = alertText.getText();
        String expectedText = "You successfully clicked an alert";

        Assert.assertEquals(actualText, expectedText);

    }

    @Test
    public void conformation_alert_ok_test2() {
        //TC #2: Confirmation alert practice
        //3. Click to “Click for JS Confirm” button
        wait(2);
        driver.findElement(By.xpath("//button[contains(text(),'JS Confirm')]")).click();
        //driver.findElement(By.xpath("//button[ends-with(text(),'Confirm')]")).click();

        wait(2);
        //4. Click to OK button from the alert
        alert = driver.switchTo().alert();
        alert.accept();

        wait(2);
        //5. Verify “You clicked: Ok” text is displayed.
        WebElement alertText = driver.findElement(By.id("result"));

        String actualText = alertText.getText();
        String expectedText = "You clicked: Ok";

        Assert.assertEquals(actualText, expectedText);

        wait(2);

    }

    @Test
    public void conformation_alert_cancel_teat3() {
        //TC #2: Confirmation alert practice
        //3. Click to “Click for JS Confirm” button
        WebElement conformationButton = driver.findElement(By.cssSelector("button[onclick='jsConfirm()']"));
        conformationButton.click();

        //4. Click to OK button from the alert
        alert = driver.switchTo().alert();

        alert.dismiss();



        //5. Verify “You clicked: cancel” text is displayed.
        WebElement alertText = driver.findElement(By.xpath("//p[@id='result']"));

        Assert.assertTrue(alertText.isDisplayed(), "Alert message is NOT displayed on the web page");

        String actualText = alertText.getText();
        String expectedText = "You clicked: Cancel";

        Assert.assertEquals(actualText, expectedText);

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public void wait(int seconds) {
        try {
            Thread.sleep(1000 * seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
