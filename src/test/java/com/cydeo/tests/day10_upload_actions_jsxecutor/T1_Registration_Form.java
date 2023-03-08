package com.cydeo.tests.day10_upload_actions_jsxecutor;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class T1_Registration_Form {

    @Test
    public void registration_form() throws InterruptedException {
        //TC#1: Registration form confirmation
        //1. Open browser
        //2. Go to website:https://practice.cydeo.com/registration form

        Driver.getDriver().get(ConfigurationReader.getProperty("env2"));
        Faker faker = new Faker();


        //3. Enter first name
        WebElement firstname = Driver.getDriver().findElement(By.name("firstname"));
        String firstName = faker.name().firstName();
        firstname.sendKeys(firstName);

        //4. Enter last name
        WebElement lastname = Driver.getDriver().findElement(By.name("lastname"));
        String lastName = faker.name().lastName();
        lastname.sendKeys(lastName);

        //5. Enter username
        WebElement username = Driver.getDriver().findElement(By.name("username"));
        username.sendKeys(firstName + lastName);

        //6. Enter email address
        WebElement email = Driver.getDriver().findElement(By.name("email"));
        email.sendKeys(faker.internet().emailAddress());

        //7. Enter password
        WebElement password = Driver.getDriver().findElement(By.name("password"));
        password.sendKeys(faker.internet().password());

        //8. Enter phone number
        WebElement phone = Driver.getDriver().findElement(By.name("phone"));
        phone.sendKeys(faker.numerify("###-###-####"));

        //9. Select a gender from radio buttons
        Driver.getDriver().findElement(By.cssSelector("input[value='male']")).click();

        //10. Enter date of birth
        WebElement birthDate = Driver.getDriver().findElement(By.name("birthday"));
        birthDate.sendKeys("10/10/1985");

        Thread.sleep(4000);
        //11. Select Department/Office
        Select select = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='department']")));
        select.selectByVisibleText("Department of Engineering");

        //12. Select Job Title
        select = new Select(Driver.getDriver().findElement(By.xpath("//select[@name='job_title']")));
        select.selectByVisibleText("Developer");

        //13.Select programming language from checkboxes
        Driver.getDriver().findElement(By.cssSelector("#inlineCheckbox2")).click();

        //14. Click to sign up button
        Driver.getDriver().findElement(By.cssSelector("#wooden_spoon")).click();

        //15. Verify success message "You've successfully completed registration." is displayed
        String expectedMessage = "You've successfully completed registration!";
        String actualMessage = Driver.getDriver().findElement(By.tagName("p")).getText();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(actualMessage, expectedMessage);
        softAssert.assertAll();

    }


    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }

    public WebElement gender(WebDriver driver, String gender) {

       return driver.findElement(By.xpath("//input[@value='"+gender+"']"));

    }

    public void department(WebDriver driver, String department) {

        Select select = new Select(driver.findElement(By.xpath("//select[@name='department']")));
        select.selectByVisibleText(department);

    }

    public void jobTitle(WebDriver driver, String department) {

        Select select = new Select(driver.findElement(By.xpath("//select[@name='department']")));
        select.selectByVisibleText(department);

    }

























}
