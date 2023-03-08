package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_Locators_getText {

    public static void main(String[] args) {

        //TC #1: NextBaseCRM, locators and getText() practice
        //1- Open a chrome browser


        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");


        //3- Enter incorrect username: “incorrect”
         WebElement loginBox = driver.findElement(By.name("USER_LOGIN"));
         loginBox.sendKeys("incorrect");

        //4- Enter incorrect password: “incorrect”
        WebElement passWordBox = driver.findElement(By.name("USER_PASSWORD"));
        passWordBox.sendKeys("incorrect");

        //5- Click to login button.
        WebElement loginBottom = driver.findElement(By.className("login-btn"));
        loginBottom.click();

        //6- Verify error message text is as expected:
        WebElement errorText = driver.findElement(By.className("errortext"));

        //Expected: Incorrect login or password
        String expectedText = "Incorrect login or password";
        String actualText = errorText.getText();

        if (expectedText.equals(actualText)){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }

        driver.quit();

        //PS: Inspect and decide which locator you should be using to locate web
        //elements.

    }
}
/*
    TC #1: NextBaseCRM, locators and getText() practice
    1- Open a chrome browser
    2- Go to: https://login1.nextbasecrm.com/
    3- Enter incorrect username: “incorrect”
    4- Enter incorrect password: “incorrect”
    5- Click to login button.
    6- Verify error message text is as expected:
    Expected: Incorrect login or password
    PS: Inspect and decide which locator you should be using to locate web
elements.
 */
