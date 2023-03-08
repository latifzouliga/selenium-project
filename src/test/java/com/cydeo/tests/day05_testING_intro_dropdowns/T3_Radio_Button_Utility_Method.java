package com.cydeo.tests.day05_testING_intro_dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class T3_Radio_Button_Utility_Method {

    public static void main(String[] args) throws InterruptedException {

        //XPATH PRACTICES
        //DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
        //TC #2: Radiobutton handling
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2. Go to https://practice.cydeo.com/radio_buttons
        driver.get("https://practice.cydeo.com/radio_buttons");

        //Locate all of the 'sport' radio buttons, and store them in a webElement
        Thread.sleep(3000);

        clickAndVerifyRadioButton(driver,"sport","hockey");

        Thread.sleep(3000);

        clickAndVerifyRadioButton(driver,"sport","football");







    }

    private static void clickAndVerifyRadioButton(WebDriver driver, String attributeName, String expectedId) {

        List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@name='" + attributeName + "']"));

        for (WebElement each : radioButtons) {
            String actualID = each.getAttribute("id");
            System.out.println("Actual ID: " + actualID);

            if (actualID.equals(expectedId)) {
                each.click();
                System.out.println(actualID + " is selected: " + each.isSelected());
                break;
            }


        }


    }


}
