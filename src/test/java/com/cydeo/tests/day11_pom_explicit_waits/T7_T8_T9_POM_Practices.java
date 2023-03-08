package com.cydeo.tests.day11_pom_explicit_waits;

import com.cydeo.pages.LibraryLoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class T7_T8_T9_POM_Practices {

    LibraryLoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        // 2- Go to: https://library1.cydeo.com

        Driver.getDriver().get("https://library1.cydeo.com");

        loginPage = new LibraryLoginPage();


    }
    @Test
    public void T7_field_required_error_message_test() {


        //TC #r Required field error message test 1- Open a chrome browser
        // 3- Do not enter any information
        // 4- Click to "Sign in" button
        loginPage.signInButton.click();

        // 5- Verify expected error is displayed:

        Assert.assertTrue(loginPage.fieldRequiredError.isDisplayed());
        // Expected: This field is required.


    }

    @Test
    public void t8_email_format_error_message_test() {
        //TC #2: Invalid email format error message test

        //3- Enter invalid email format


        loginPage.emailAddressInput.sendKeys("username",Keys.TAB);

        //4- Verify expected error is displayed:
        //Expected: Please enter a valid email address.
        String actualText = loginPage.enterValidEmailErrorMessage.getText();
        String expectedText = "Please enter a valid email address.";

        Assert.assertEquals(actualText, expectedText);
        //NOTE: FOLLOW POM DESIGN PATTERN


    }

    @Test
    public void t9_wrong_email_or_password_error_message_test() {
        //TC #3: Library negative login

        //3- Enter incorrect username or incorrect password
        loginPage.emailAddressInput.sendKeys("hello@yahoo.com");

        loginPage.passwordInput.sendKeys("!!!!!");

        loginPage.signInButton.click();

        //4- Verify title expected error is displayed:
        //Expected: Sorry, Wrong Email or Password
        Assert.assertTrue(loginPage.wrongEmailOrPassword.isDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        BrowserUtils.sleep(3);
        Driver.closeDriver();
    }
}
