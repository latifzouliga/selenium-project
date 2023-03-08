package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LibraryLoginPage {

    // 1. Initialize the object of the class and driver instance inside the constructor

    public LibraryLoginPage(){
        // this line is coming from selenium
        PageFactory.initElements(Driver.getDriver(),this);
    }

    // 2. use @FindBy annotation instead of findElement method

    @FindBy(xpath = "//button[.='Sign in']")
    public WebElement signInButton;

    @FindBy(id = "inputPassword")
    public WebElement passwordInput;

    @FindBy(id = "inputEmail")
    public WebElement emailAddressInput;

    @FindBy(xpath = "//div[.='Sorry, Wrong Email or Password']")
    public WebElement wrongEmailOrPassword;

    @FindBy(xpath = "//div[@id='inputEmail-error']")
    public WebElement fieldRequiredError;

    @FindBy(xpath = "//div[.='Please enter a valid email address.']")
    public WebElement enterValidEmailErrorMessage;







}
