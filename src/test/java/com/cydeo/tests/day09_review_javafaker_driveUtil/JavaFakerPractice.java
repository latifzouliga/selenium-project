package com.cydeo.tests.day09_review_javafaker_driveUtil;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFakerPractice {


    @Test
    public void test1(){
        // Create Java Faker object

        Faker faker = new Faker();

        // Print out a random first name using Faker object
        System.out.println("name "+faker.name().firstName());
        System.out.println("last name "+faker.name().lastName());
        System.out.println("full name "+faker.name().fullName());

        System.out.println(faker.address().fullAddress());
         //Print out city

        System.out.println(faker.address().city());

        System.out.println(faker.numerify("###-###-####"));

        System.out.println(faker.numerify("1800-###-####"));

        //letterify() method is used to generate RANDOM letters with specific formatting
        System.out.println(faker.letterify("??? ???? ? ??? ??????? ?? ??? ???? ????? ???"));

        //bothi() method is used to generate both letters and digits randomly
        System.out.println(faker.bothify("### ??? ???#?"));

        //chuckNorris method is used to create chuckNorris facts
        System.out.println(faker.chuckNorris().fact().replaceAll("Chuck Norris","Muhtar"));


        //
    }
}
