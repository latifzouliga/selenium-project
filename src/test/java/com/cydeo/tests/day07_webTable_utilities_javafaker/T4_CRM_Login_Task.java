package com.cydeo.tests.day07_webTable_utilities_javafaker;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.CRM_Utilities;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T4_CRM_Login_Task {

    //TC #4: Login scenario
    //1. Create new test and make set ups
    //2. Go to: http://login1.nextbasecrm.com/
    //3. Enter valid username
    //4. Enter valid password
    //5. Click to 'Log In' button
    //6. Verify title is as expected:
    //Expected: Portal
    //Password: USERNAME
    //helpdesk1@cvdeo.com
    //helpdesk2@cydeo.com


    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        //1. Create new test and make set ups
        //2. Go to: http://login1.nextbasecrm.com/
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://login1.nextbasecrm.com/");
    }

    @Test
    public void crm_login_test1(){
        //3. Enter valid username
        //helpdesk1@cvdeo.com
        WebElement userLoginBox = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        userLoginBox.sendKeys("helpdesk1@cydeo.com");


        //4. Enter valid password
        WebElement passwordBox = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        passwordBox.sendKeys("UserUser");

        //5. Click to 'Log In' button
        driver.findElement(By.cssSelector("input[type='submit']")).click();

        //6. Verify title is as expected:
        //Expected: (2) Portal
        BrowserUtils.verifyTitle(driver,"(2) Portal");

        //Password: UserUser
        //helpdesk1@cvdeo.com
        //helpdesk2@cydeo.com

    }

    @Test
    public void crm_login_test2(){

        //Logging in using the utility method we created in CRM_Utilities class
        CRM_Utilities.crm_login(driver);
        //6. Verify title is as expected:
        //Expected: (2) Portal
        BrowserUtils.verifyTitle(driver,"(2) Portal");
       // CRM_Utilities.crm_login(driver,"hello","me");

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
