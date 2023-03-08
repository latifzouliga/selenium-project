package com.cydeo.tests.day02_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T5_getText_GetAttribute {

    public static void main(String[] args) {

        //TC #5: getText() and getAttribute() method practice
        //1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to: https://practice.cydeo.com/registration_form
        driver.get("https://practice.cydeo.com/registration_form");

        //3- Verify header text is as expected:
        //Expected: Registration form
        WebElement registrationFormHeader = driver.findElement(By.tagName("h2"));

        String expectedHeader = "Registration form";
        String actualHeader = registrationFormHeader.getText();

        if (expectedHeader.equals(actualHeader)){
            System.out.println("Header verification PASSED");
        }else {
            System.out.println("Header verification FAILED");
        }

        //4- Locate “First name” input box
        WebElement firstNameInput = driver.findElement(By.name("firstname"));

        //5- Verify placeholder attribute’s value is as expected:
        //Expected: first name
        String actualPlaceholder = firstNameInput.getAttribute("placeholder");
        String expectedPlaceholder = "first name";

        if (actualPlaceholder.equals(expectedPlaceholder)){
            System.out.println("Placeholder name verification PASSED");
        }else {
            System.out.println("Placeholder name verification FAILED");
        }


        driver.quit();

    }
}
/*
        TC #5: getText() and getAttribute() method practice
        1- Open a chrome browser
        2- Go to: https://practice.cydeo.com/registration_form
        3- Verify header text is as expected:
        Expected: Registration form
        4- Locate “First name” input box
        5- Verify placeholder attribute’s value is as expected:
        Expected: first name
 */