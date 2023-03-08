package com.cydeo.tests.day08_properties_confg_reader;

import com.cydeo.utilities.WebDriverFactory;
import com.cydeo.utilities.WebOrderUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T1_WebTable_Order_Verify {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        //1. Create new test and Imake setups
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //2. Go to: https://practice.cydeo.com/web-tables
        driver.get("https://practice.cydeo.com/web-tables");
    }

    @Test
    public void verify_name_test() {
        //2. VerifyBob's name is listed as expected.
        //   (//table)[2]//td[.='Bob Martin']
        //   //table[@class='SampleTable']//td[.='Bob Martin']

        // locating bod's cell
        WebElement bobsCell = driver.findElement(By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']"));

        //Expected: "Bob Martin"
        String bobsActualName = bobsCell.getText();
        String expectedName = "Bob Martin";

        Assert.assertEquals(bobsActualName, expectedName);


        //3. VerifyBobMartin's order date is as expected
        WebElement bobsOrderDate1 = driver.findElement(
                By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']/..//td[5]"));

        WebElement bobsOrderDate2 = driver.findElement(
                By.xpath("//table[@class='SampleTable']//td[.='Bob Martin']/following-sibling::td[3]"));

        WebElement bodsOrderDate3 = driver.findElement(
                By.xpath("//td[.='Bob Martin']/following-sibling::td[3]"));

        WebElement bodsOrderDate4 = driver.findElement(
                By.xpath("//td[.='Bob Martin']/..//td[5]")
        );

        String bodsOrderDate5 = WebOrderUtils.returnOrderDate(driver, "Bob Martin");

        //Expected: 12/31/2021
        String expectedOrderDate = "12/31/2021";
        //String actualOrderDate = bobsOrderDate2.getText();

        Assert.assertEquals(bodsOrderDate5, expectedOrderDate);


    }

    @Test
    public void use_order_verify_method_test() {
        String orderDate = WebOrderUtils.returnOrderDate(driver, "Bart Fisher");
        System.out.println("Bart Fisher's order date: " + orderDate);

        orderDate = WebOrderUtils.returnOrderDate(driver, "Ned Stark");
        System.out.println("Ned Stark's order date: " + orderDate);
    }

    @Test
    public void test3(){
        //Expected: 12/31/2021
        WebOrderUtils.orderVerify(driver,"Bob Martin","12/31/2021");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}

















