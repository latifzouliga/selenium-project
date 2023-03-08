package com.cydeo.tests.day04_findElement_checkbox_radioButtons;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class T4_StaleElementReferenceException {

    public static void main(String[] args) {

        //TC #4: StaleElementReferenceException
        //Task 1- Open a Chrome browser
        //2- Go to: https://practice.cydeo.com/abtest
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://practice.cydeo.com/abtest");

        //3- Locate "CYDEO" link is displayed
        WebElement cydeoText = driver.findElement(By.xpath("//a[.='CYDEO']"));

        // check if the CYDEO text link is displayed
        System.out.println("cydeoText.isDisplayed() = " + cydeoText.isDisplayed());

        //4- Refresh the page
        driver.navigate().refresh();

        System.out.println("Refreshing the page .........");

        // Re-assigning the element reference to avoid StaleElementException
        cydeoText = driver.findElement(By.xpath("//a[.='CYDEO']"));

        try {
            // Recheck if the CYDEO text link is displayed
            System.out.println("cydeoText.isDisplayed() = " + cydeoText.isDisplayed());
        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        System.out.println("task is done");

        driver.close();


    }
}
