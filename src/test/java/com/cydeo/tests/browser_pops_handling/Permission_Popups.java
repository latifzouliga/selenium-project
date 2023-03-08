package com.cydeo.tests.browser_pops_handling;

import com.cydeo.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Permission_Popups {

    @Test
    public void test_with_chrome() {


        ChromeOptions options = new ChromeOptions();

        //options.addArguments("disable-notifications");

        WebDriver driver = new ChromeDriver(options);

        //driver.get("https://web-push-book.gauntface.com/demos/notification-examples/");
        //driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
        driver.get("https://mictests.com/");
        BrowserUtils.sleep(3);
        driver.findElement(By.id("mic-launcher")).click();

        options.addArguments("disable-media_stream");
        //driver.get("https://whatmylocation.com/");


    }

    @Test
    public void test_with_firefox() {

        // does not work for firefox

        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("disable-notifications");

        WebDriver driver = new FirefoxDriver(options);

        driver.get("https://web-push-book.gauntface.com/demos/notification-examples/");
        driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();


    }

    @Test
    public void test_allow_disable() {

        // create an ChromeOptions object and pass it to the driver constructor
        ChromeOptions options = new ChromeOptions();


        Map<String, Integer> contSettings = new HashMap<>();  // storing content settings and its value
        Map<String, Object> profile = new HashMap<>();
        Map<String,Object> prefs = new HashMap<>();

        // change the key argument based on notification type
        // media_stream, geolocation, notifications etc
        // change the value argument base on the action that is needed to be done
        // 0 default, 1 Allow, 2 Block
        contSettings.put("media_stream", 1);
        //contSettings.put("geolocation", 1);
        //contSettings.put("media",2);

        profile.put("managed_default_content_settings",contSettings);
        prefs.put("profile",profile);

        options.setExperimentalOption("prefs",prefs);

        WebDriver driver = new ChromeDriver(options);

        //driver.get("https://mictests.com/");
        driver.get("https://webcamtests.com/");

        BrowserUtils.sleep(5);
        //driver.findElement(By.id("mic-launcher")).click();
        driver.findElement(By.id("webcam-launcher")).click();


        // some useful websites for testing these types of notifications

        // https://web-push-book.gauntface.com/demos/notification-examples/
        // https://whatmylocation.com/
        // https://mictests.com/
        // https://webcamtests.com/




    }
}






















