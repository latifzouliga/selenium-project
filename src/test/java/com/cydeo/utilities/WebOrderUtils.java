package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class WebOrderUtils {


    /**
     * This method accepts a costumerName and return the costumer's order date as a String.
     */
    public static String returnOrderDate(WebDriver driver, String costumerName) {

        // locating customer order date
        String locator = "//td[.='" + costumerName + "']/following-sibling::td[3]";
        WebElement orderDate = driver.findElement(By.xpath(locator));

        return orderDate.getText();

    }

    /**
     * This method accepts 3 arguments; driver costumerName and expected date
     * it locates the customer actual order date and compare it with the expected date
     */
    public static void orderVerify(WebDriver driver, String costumerName, String expectedOrderDate) {

        // locating customer order date and returning it as a String text
        String actualOrderDate = driver.findElement(
                By.xpath("//td[.='" + costumerName + "']/following-sibling::td[3]")).getText();

        // verifying the actual date
        Assert.assertEquals(actualOrderDate, expectedOrderDate);


    }

}
