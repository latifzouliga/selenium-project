package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T3_ccsSelector {

    public static void main(String[] args) {

        //TC #3: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        //3- Verify “Log in” button text is as expected:
        //WebElement loginButton = driver.findElement(By.cssSelector("input[value='Log In']"));
        //WebElement loginButton = driver.findElement(By.cssSelector("input[type='submit']"));
        WebElement loginButton = driver.findElement(By.cssSelector("input.login-btn"));


        //Expected: Log In
        String expectedLoginText = "Log In";
        String actualLoginText = loginButton.getAttribute("value");

        if (expectedLoginText.equals(actualLoginText)){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }

        driver.quit();

        //PS: Inspect and decide which locator you should be using to locate web
        //elements.
        //PS2: Pay attention to where to get the text of this button from
    }
}
/*
    TC #3: NextBaseCRM, locators, getText(), getAttribute() practice
    1- Open a chrome browser
    2- Go to: https://login1.nextbasecrm.com/
    3- Verify “Log in” button text is as expected:
    Expected: Log In
    PS: Inspect and decide which locator you should be using to locate web
    elements.
    PS2: Pay attention to where to get the text of this button from
 */