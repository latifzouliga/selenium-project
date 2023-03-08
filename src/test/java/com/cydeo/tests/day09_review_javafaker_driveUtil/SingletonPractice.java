package com.cydeo.tests.day09_review_javafaker_driveUtil;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SingletonPractice {


    @Test
    public void singleton_understanding_test1(){

        Singleton.getWord();

        Singleton.getWord();

    }

    @Test
    public void singleton_understanding_test2(){

        Singleton.getWord();

        Singleton.getWord();
    }

    @AfterMethod
    public void tearDown(){
        Singleton.quit();
    }

}
