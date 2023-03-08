package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * In this class we will be creating the re-usable logic to read from configuration.properties file
 */
public class ConfigurationReader {

    // create object
    private static Properties properties = new Properties();

    static {

        try {
            // open file
            FileInputStream file = new FileInputStream("configuration.properties");
            // load the file
            properties.load(file);
            // close the file in the memory
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("File NOT found with given path");
        }

    }

    // Create a utility method to use the object to read
    /** a utility method that accepts one config properties String key */
    public static String getProperty(String keyword){
        return properties.getProperty(keyword);
    }


}
