package com.cydeo.tests.day10_upload_actions_jsxecutor;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class T2_Upload_Practice {

    @Test
    public void uploading_test() {

        //TC #2 Upload Test
        //1. Go to https://practice.cydeo.com/upload
        Driver.getDriver().get(ConfigurationReader.getProperty("file.upload.url"));

        //File file = new File("/Users/zouliga/Desktop/git commands.txt");

        WebElement chooseFileButton = Driver.getDriver().findElement(By.id("file-upload"));

        //2. Find some small file from your computer, and get the path of it. y
        // 3. Upload the file.
        chooseFileButton.sendKeys("/Users/zouliga/Desktop/git commands.txt");

        // locating upload button
        Driver.getDriver().findElement(By.cssSelector("#file-submit")).submit();

        WebElement displayedText = Driver.getDriver().findElement(By.cssSelector("#uploaded-files"));

        //-File uploaded text is displayed on the page
        //4. Assert:
        Assert.assertEquals(displayedText.getText(), "git commands.txt");





    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
}




















