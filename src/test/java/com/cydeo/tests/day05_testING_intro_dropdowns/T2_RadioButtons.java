package com.cydeo.tests.day05_testING_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class T2_RadioButtons {

    public static void main(String[] args) throws InterruptedException {

        //XPATH PRACTICES
        //DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
        //TC #2: Radiobutton handling
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2. Go to https://practice.cydeo.com/radio_buttons
        driver.get("https://practice.cydeo.com/radio_buttons");

        // locating hockey button
        //WebElement hockeyButton = driver.findElement(By.xpath("//input[@id='hockey']"));
        boolean isSelected = clickAndVerifyRadioButton(driver,"id","hockey");
        System.out.println(isSelected);

        Thread.sleep(3000);
        isSelected = clickAndVerifyRadioButton(driver,"id","football");

        System.out.println(isSelected);

        driver.close();
    }

    public static boolean clickAndVerifyRadioButton(WebDriver driver, String attributeName, String idAttribute){
        /**
         * This WebElement object is accepting
         */

        WebElement buttons = driver.findElement(By.xpath("//input[@"+attributeName+"='"+idAttribute+"']"));

        buttons.click();

        return buttons.isSelected();
    }

}
