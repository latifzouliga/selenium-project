package com.cydeo.tests.day01_selenium_intro;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    public static void main(String[] args) {

        // 1- Setting up the web driver manager
        WebDriverManager.chromedriver().setup(); // Creates the connection between the browser and the code

        // 2- Create the instance of chrome driver
        WebDriver driver = new ChromeDriver();

        // 3- Test if the driver and the browser are working as expected
        driver.get("https://www.google.com");




    }
}
