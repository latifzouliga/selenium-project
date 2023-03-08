package com.cydeo.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JSUtils {

    public static void flashElement(WebElement element) {

        String bgColor = element.getCssValue("background-color");

        for (int i = 0; i < 100; i++) {
            changeColor("red",element);
            changeColor(bgColor,element);
        }

    }

    public static void changeColor(String color, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].style.background= '"+color+"'",element);
        //.setAttribute('style','background:"+color+"')
        try {
            Thread.sleep(50);
        }catch (InterruptedException e){
            // do nothing
        }

    }
}
