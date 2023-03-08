package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {


    // Create a private constructor to remove access to this object
    private Driver() {

    }

    /**
     * We make the WebDriver private, because we want to close access from outside the class.
     * We are making it static, because we will use it in a static method.
     */
    private static WebDriver driver;

    /**
     * This method which will return the same driver instance once we call it.
     * If an instance doesn't exist, it will create first, and then it will always return same instance.
     */
    public static WebDriver getDriver() {

        if (driver == null) {
            // read the browser type from the configuration.properties file.
            // this way, we control which browser is opened from outside our code.
            String browserType = ConfigurationReader.getProperty("browser");
            /**
             * Depending on the browserType returned from the configuration. properties switch statement
             * will determine the "case", and open the matching browser
             */
            switch (browserType) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().disableCsp();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
            }
        }


        return driver;


    }

    /**
     * closeDriver; it will use quit() method to quit browsers,
     * and then set the driver value back to null to avoid NoSuchSessionException
     */
    public static void closeDriver() {
        if (driver != null) {
            // this line will terminate the driver
            driver.quit();
            //re-assign the value back to null
            driver = null;
        }
    }


}
