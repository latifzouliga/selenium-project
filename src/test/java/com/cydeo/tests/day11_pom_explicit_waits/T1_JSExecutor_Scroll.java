package com.cydeo.tests.day11_pom_explicit_waits;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class T1_JSExecutor_Scroll {

    //TC #1: Scroll using JavascriptExecutor
    //1- Open a Chrome browser
    //2- Go to: https://practice.cydeo.com/large
    //3- Scroll down to "Cydeo" link
    //4- Scroll u to "Home" link
    //5- Use below provided JS method only
    //JavaScript method to use : arguments [0].scrollIntoView (true)
    //Note: You need to locate the links as web elements and pass them as arguments into executeScript() method


    @Test
    public void testName() {

        //TC #1: Scroll using JavascriptExecutor
        //1- Open a Chrome browser
        //2- Go to: https://practice.cydeo.com/large
        Driver.getDriver().get("https://practice.cydeo.com/large");

        WebElement cydeoLink = Driver.getDriver().findElement(By.linkText("CYDEO"));
        WebElement homeLink = Driver.getDriver().findElement(By.linkText("Home"));

        BrowserUtils.sleep(2);

        //3- Scroll down to "Cydeo" link
        ((JavascriptExecutor)Driver.getDriver()).executeScript("arguments[0].scrollIntoView (true)", cydeoLink);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();

        BrowserUtils.sleep(2);
        jsExecutor.executeScript("arguments [0].scrollIntoView (true)",homeLink);
        //4- Scroll u to "Home" link
        //5- Use below provided JS method only
        //JavaScript method to use : arguments [0].scrollIntoView (true)
        //Note: You need to locate the links as web elements and pass them as arguments into executeScript() method
        BrowserUtils.sleep(2);


    }
}












