package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CRM_Utilities {

    /** This method will log in using below credentials.
        Username: helpdesk1@cydeo.com
        Password: UserUser */

    public static void crm_login(WebDriver driver){
        WebElement userLoginBox = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        userLoginBox.sendKeys("helpdesk1@cydeo.com");

        //4. Enter valid password
        WebElement passwordBox = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        passwordBox.sendKeys("UserUser");

        //5. Click to 'Log In' button
        driver.findElement(By.cssSelector("input[type='submit']")).click();

    }

    public static void crm_login(WebDriver driver,String userName, String password){

        WebElement userLoginBox = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        userLoginBox.sendKeys(userName);

        //4. Enter valid password
        WebElement passwordBox = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        passwordBox.sendKeys(password);

        //5. Click to 'Log In' button
        driver.findElement(By.cssSelector("input[type='submit']")).click();

    }



}
