package com.cydeo.tests.day02_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T4_Library_Practice {

    public static void main(String[] args) throws InterruptedException {

        //        TC #4: Library verifications
        //        1. Open Chrome browser

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2. Go to https://library2.cybertekschool.com/login.html
        driver.get("https://library2.cybertekschool.com/login.html");

        //3. Enter username: “incorrect@email.com”
        //   Locate username input box using “className” locator
        WebElement userNameInputBox = driver.findElement(By.className("form-control"));
        userNameInputBox.sendKeys("incorrect@email.com");

        //4. Enter password: “incorrect password”
        //   Locate password input box using “id” locator
        WebElement passwordInputBox = driver.findElement(By.id("inputPassword"));
        passwordInputBox.sendKeys("incorrect");

        //5  Locate Sign in button using “tagName” locator
        driver.findElement(By.tagName("button")).click();

        //6. Verify: visually “Sorry, Wrong Email or Password” displayed

        WebElement wrongEmailPasswordAlert = driver.findElement(By.className("alert"));

        String actualResult = wrongEmailPasswordAlert.getText();
        String expectedAlertMessage = "Sorry, Wrong Email or Password";

        if (expectedAlertMessage.equals(actualResult)) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }
        System.out.println(actualResult);

        Thread.sleep(3000);

        driver.quit();

        // PS:




    }
}
/*
        TC #4: Library verifications
        1. Open Chrome browser
        2. Go to http://library2.cybertekschool.com/login.html
        3. Enter username: “incorrect@email.com”
        4. Enter password: “incorrect password”
        5. Verify: visually “Sorry, Wrong Email or Password”
        displayed
        PS: Locate username input box using “className” locator
        Locate password input box using “id” locator
        Locate Sign in button using “tagName” locator
 */