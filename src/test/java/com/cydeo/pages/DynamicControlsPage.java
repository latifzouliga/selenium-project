package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DynamicControlsPage {

    public DynamicControlsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//button[.='Remove']")
    public WebElement removeButton;

    @FindBy(css = "input[label='blah']")
    public WebElement checkBox;

    @FindBy(id = "message")
    public WebElement goneMessage;

    @FindBy(xpath = "//p[@id='message']/..//div[1]")
    public WebElement loadingBar;

    @FindBy(xpath = "//button[.='Enable']")
    public WebElement enableButton;

    @FindBy(css = "#message")
    public WebElement itsEnabledMessage;

    @FindBy(css = "#input-example > input")
    public WebElement inputBox;

}





















