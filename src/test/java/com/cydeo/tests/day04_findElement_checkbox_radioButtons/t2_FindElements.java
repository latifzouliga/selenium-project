package com.cydeo.tests.day04_findElement_checkbox_radioButtons;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class t2_FindElements {

    public static void main(String[] args) {

        //TC #2: FindElements Task
        //1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2- Go to: https://practice.cydeo.com/abtest
        driver.get("https://practice.cydeo.com/abtest");

        //3- Locate all the links in the page.
        List<WebElement> webElementList = driver.findElements(By.tagName("a"));
        //System.out.println(webElementList);

        //4- Print out the number of the links on the page.
        int size = webElementList.size();
        System.out.println("----------elements found-----------\n"+size);

        //5- Print out the texts of the links.
        System.out.println("------------WedElements text-----------");
        for (WebElement each : webElementList) {
            System.out.println(each.getText());
        }

        //6- Print out the HREF attribute values of the links
        System.out.println("----------------href's values--------------");
        for (WebElement each : webElementList) {
            String links = each.getAttribute("href");
            System.out.println(links);
        }

        driver.close();




    }
}
/*
    TC #2: FindElements Task
    1- Open a chrome browser
    2- Go to: https://practice.cydeo.com/abtest
    3- Locate all the links in the page.
    4- Print out the number of the links on the page.
    5- Print out the texts of the links.
    6- Print out the HREF attribute values of the links
 */