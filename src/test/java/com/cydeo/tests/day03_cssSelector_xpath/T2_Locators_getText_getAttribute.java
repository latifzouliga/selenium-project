package com.cydeo.tests.day03_cssSelector_xpath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class T2_Locators_getText_getAttribute {

    public static void main(String[] args) {

        //TC #2: NextBaseCRM, locators, getText(), getAttribute() practice
        //1- Open a chrome browser

        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");

        //3- Verify “remember me” label text is as expected:
        //Expected: Remember me on this computer
        String expectedText = "Remember me on this computer";
        String actualText = driver.findElement(By.className("login-item-checkbox-label")).getText();

        if (expectedText.equals(actualText)){
            System.out.println("Remember  me text PASSED");
        }else {
            System.out.println("Remember  me text FAILED");
        }

        //4- Verify “forgot password” link text is as expected:
        //Expected: Forgot your password?
        expectedText = "FORGOT YOUR PASSWORD?";
        actualText = driver.findElement(By.className("login-link-forgot-pass")).getText();

        if (actualText.equals(expectedText)){
            System.out.println("Forgot password Text PASSED");
        }else {
            System.out.println("Forgot password Text FAILED");
        }


        //5- Verify “forgot password” href attribute’s value contains expected:
        //Expected: forgot_password=yes
        String expectedHref = "forgot_password=yes";
        String actualHref = driver.findElement(By.className("login-link-forgot-pass")).getAttribute("href");
        //System.out.println(actualHref);

        if (actualHref.contains(expectedHref)){
            System.out.println("Href's value PASSED");
        }else {
            System.out.println("Href's value FAILED");
        }

        //PS: Inspect and decide which locator you should be using to locate web
        //elements.
        // a[class='ff58'] a[id='bb22']  a[href='https://www.ddfs.com]

        driver.quit();

    }
}
    /*TC #2: NextBaseCRM, locators, getText(), getAttribute() practice
    1- Open a chrome browser
    2- Go to: https://login1.nextbasecrm.com/
    3- Verify “remember me” label text is as expected:
    Expected: Remember me on this computer
    4- Verify “forgot password” link text is as expected:
    Expected: Forgot your password?
    5- Verify “forgot password” href attribute’s value contains expected:
    Expected: forgot_password=yes
    PS: Inspect and decide which locator you should be using to locate web
    elements.
 */