package com.cydeo.tests.day05_testING_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class T1_Stale_element_reference {

    public static void main(String[] args) throws InterruptedException {


        //XPATH PRACTICES
        //DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
        //TC #1: StaleElementReferenceException handling
        //1. Open Chrome browser
        //2. Go to https://practice.cydeo.com/add_remove_elements/
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        driver.get("https://practice.cydeo.com/add_remove_elements/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //3. Click to “Add Element” button
        WebElement addElement = driver.findElement(By.xpath("//button[.='Add Element']"));

        addElement.click();

        // locating delete button element
        //WebElement deleteButton = driver.findElement(By.xpath("//div[@class='example']/button"));
        WebElement deleteButton = driver.findElement(By.xpath("//button[.='Delete']"));

        //4. Verify “Delete” button is displayed after clicking.
        System.out.println("Expected result: true = " + deleteButton.isDisplayed());


        Thread.sleep(3000);
        //5. Click to “Delete” button.
        deleteButton.click();


        //6. Verify “Delete” button is NOT displayed after clicking.

        // use try and catch to handle and verify
        try {
            System.out.println("Expected result: false = " + deleteButton.isDisplayed());
        } catch (StaleElementReferenceException e) {
            System.out.println("StaleElementException happened due to element being deleted from the page");
            System.out.println("Which means that our test case is passed");
        }

        //USE XPATH LOCATOR FOR ALL WEBELEMENT LOCATORS
    }
}
