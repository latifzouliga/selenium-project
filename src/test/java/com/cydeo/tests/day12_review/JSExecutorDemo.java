package com.cydeo.tests.day12_review;

import com.cydeo.utilities.Driver;
import com.cydeo.utilities.JSUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class JSExecutorDemo {


    @Test
    public void testName() {

        Driver.getDriver().get("https://www.twoplugs.com");

        WebElement element = Driver.getDriver().findElement(By.cssSelector(".btn.green"));

        JSUtils.flashElement(element);

        element = Driver.getDriver().findElement(By.cssSelector(".btn.border"));

        JSUtils.flashElement(element);



    }
}
