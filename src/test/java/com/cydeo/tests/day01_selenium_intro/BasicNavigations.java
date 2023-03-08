package com.cydeo.tests.day01_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigations {

    public static void main(String[] args) throws InterruptedException {

        // Setup browser driver
        WebDriverManager.chromedriver().setup();

        // Create an instance of Chrome drover
        WebDriver driver = new ChromeDriver();

        // maximize the window
        driver.manage().window().maximize();

        // for mac only
        driver.manage().window().fullscreen();

        // Go to tesla.com
        driver.get("https://www.tesla.com");

        // get the current url
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        Thread.sleep(3000);

        // Use navigate back() to go back
        driver.navigate().back();

        //Stop execution for 3 seconds
        Thread.sleep(3000);

        // Use navigate forward() to go forward
        driver.navigate().forward();

        Thread.sleep(3000);

        //User refreshes the page
        driver.navigate().refresh();

        Thread.sleep(3000);

        // navigate to google to google.com
        driver.navigate().to("https://www.google.com");

        // getting the current the url
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        // get the title
        System.out.println("driver.getTitle() = " + driver.getTitle());

        // to close currently opened and focused browser/tab
        driver.close();

        // to close all the opened browser windows/tabs
        driver.quit();




    }
}
