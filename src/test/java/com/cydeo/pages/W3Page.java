package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class W3Page {

    public W3Page(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "#demo")
    public WebElement paragraph;







}
