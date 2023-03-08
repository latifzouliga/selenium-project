package com.cydeo.tests.day02_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_Name_GoogleSearch {

    public static void main(String[] args) {


        //TC#3: Google search
        //1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2- Go to: https://google.com
        driver.get("https://google.com");

        //3- Write “apple” in search box
        // A- locate search box
        WebElement searchAreaName = driver.findElement(By.name("q"));

        //B- enter "apple" and Press Enter
        searchAreaName.sendKeys("apple", Keys.ENTER);

        //4- Press ENTER to search
        //searchAreaName.sendKeys(Keys.ENTER);

        //5- Verify title:
        //Expected: Title should start with “apple” word
        String expectedTitle = "apple";
        String actualTitle = driver.getTitle();

        if (actualTitle.startsWith(expectedTitle)){
            System.out.println("Title verification PASSED");
        }else {
            System.out.println("Title verification FAILED");
        }



    }
}

/*
        TC#3: Google search
        1- Open a chrome browser
        2- Go to: https://google.com
        3- Write “apple” in search box
        4- Press ENTER to search
        5- Verify title:
        Expected: Title should start with “apple” word
 */
