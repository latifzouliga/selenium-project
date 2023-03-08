package com.cydeo.tests.day09_review_javafaker_driveUtil;

import com.github.javafaker.Faker;

public class Singleton {

    private Singleton() {

    }

    private static String WORD;

    // counts how many times the String WORD been called
    public static int count;

    // Singleton pattern design
    // this method will check the value of String WORD and assign it if it is null
    // the String WORD will always return the same session value whenever it is called
    public static void getWord() {
        Faker faker = new Faker();
        count++;
        if (WORD == null) {
            WORD = faker.bothify("#?#?#?#?#?#?#?#?#?").toUpperCase();
            System.out.println("Call number: "+count+". WORD object is null");
            System.out.println("Assigning value to it now.");
            System.out.println("Driver_Session_ID"+WORD);
        } else {
            System.out.println("Call number: "+count+". WORD already has a value.");
        }
    }

    // re-assign the value back to null
    public static void quit(){
        if (WORD != null){
            WORD = null;
        }
    }


}
