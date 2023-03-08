package com.cydeo.tests.day04_findElement_checkbox_radioButtons;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_xpath_cssSelector_Practice {

    public static void main(String[] args) throws InterruptedException {

        //TC #1: XPATH and cssSelector Practices
        //1. Open Chrome browser

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //2. Go to https://practice.cydeo.com/forgot_password
        driver.get("https://practice.cydeo.com/forgot_password");

        //3. Locate all the WebElements on the page using XPATH and/or CSS locator only (total of 6)
        //a. “Home” link
        WebElement homeButton = driver.findElement(By.cssSelector("a.nav-link"));

        //b. “Forgot password” header
        WebElement forgotPassword = driver.findElement(By.xpath("//h2[.='Forgot Password']"));
        WebElement forgotPassword2 = driver.findElement(By.cssSelector("div[class='example'] > h2 "));
        WebElement forgotPassword3 = driver.findElement(By.cssSelector("div.example > h2"));


        //c. “E-mail” text
        WebElement emailTest = driver.findElement(By.xpath("//label[@for='email']"));
        WebElement emailTest1 = driver.findElement(By.xpath("//label[.='E-mail']"));
        WebElement emailTest2 = driver.findElement(By.cssSelector("label[for='email']"));

        //d. E-mail input box
        WebElement emailBox = driver.findElement(By.xpath("//input[@type='text']"));
        WebElement emailBox1 = driver.findElement(By.xpath("//input[contains(@pattern,'a-z')]"));

        //e. “Retrieve password” button
        WebElement retrievePasswordLink = driver.findElement(By.cssSelector("button[class='radius'] > i"));

        //f. "Powered by Cydeo" text
        WebElement poweredByCydeoText = driver.findElement(By.xpath("//div[@style='text-align: center;']"));
        //4. Verify all web elements are displayed

        System.out.println("homeButton.isDisplayed() = " + homeButton.isDisplayed());
        System.out.println("forgotPassword.isDisplayed() = " + forgotPassword.isDisplayed());
        System.out.println("emailBox.isDisplayed() = " + emailBox.isDisplayed());
        System.out.println("emailTest.isDisplayed() = " + emailTest.isDisplayed());
        System.out.println("retrievePasswordLink.isDisplayed() = " + retrievePasswordLink.isDisplayed());
        System.out.println("poweredByCydeoText.isDisplayed() = " + poweredByCydeoText.isDisplayed());

        Thread.sleep(3000);
        driver.close();


    }
}
/*
    //TC #1: XPATH and cssSelector Practices
    //1. Open Chrome browser
    //2. Go to https://practice.cydeo.com/forgot_password
    //3. Locate all the WebElements on the page using XPATH and/or CSS locator only (total of 6)
    //a. “Home” link
    //b. “Forgot password” header
    //c. “E-mail” text
    //d. E-mail input box
    //e. “Retrieve password” button
    //f. "Powered by Cydeo" text
    //4. Verify all web elements are displayed
 */