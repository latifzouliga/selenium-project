package com.cydeo.tests.day04_findElement_checkbox_radioButtons;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class T3_checkBoxes_radioButtons {

    public static void main(String[] args) throws InterruptedException {


        //TC#3: Checkboxes
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1. Go to https://practice.cydeo.com/checkboxes
        driver.get("https://practice.cydeo.com/checkboxes");

        // locating checkbox #2
        WebElement checkBox1 = driver.findElement(By.cssSelector("input[id='box1']"));

        System.out.println("Default checkBox setup");

        //2. Confirm checkbox #1 is NOT selected by default
        System.out.println("checkBox # 1 is selected, expecting false = " + checkBox1.isSelected());

        // locating checkbox #2
        WebElement checkBox2 = driver.findElement(By.cssSelector("input#box2"));


        //3. Confirm checkbox #2 is SELECTED by default.
        System.out.println("checkBox # 2 is selected, expecting true = " + checkBox2.isSelected());
        Thread.sleep(3000);
        //4. Click checkbox #1 to select it.
        checkBox1.click();
        Thread.sleep(3000);
        //5. Click checkbox #2 to deselect it.
        checkBox2.click();

        System.out.println("confirm checkBox 1 is selected and checkBox 2 is not selected");

        //6. Confirm checkbox #1 is SELECTED.
        System.out.println("checkBox # 1 is selected, expecting true = " + checkBox1.isSelected());

        //7. Confirm checkbox #2 is NOT selected.
        System.out.println("checkBox # 3 is selected, expecting false = " + checkBox2.isSelected());

        driver.close();

    }
}

/*
        TC#3: Checkboxes
        1. Go to https://practice.cydeo.com/checkboxes
        2. Confirm checkbox #1 is NOT selected by default
        3. Confirm checkbox #2 is SELECTED by default.
        4. Click checkbox #1 to select it.
        5. Click checkbox #2 to deselect it.
        6. Confirm checkbox #1 is SELECTED.
        7. Confirm checkbox #2 is NOT selected.
 */
