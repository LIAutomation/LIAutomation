package com.cgi.li.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileUtility {
    public  static String getValueInPropertiesFile(String propertyname) throws IOException {
            String propertyFilePath ="C:\\Users\\bsreenivasa\\Downloads\\Sep22thAuto\\Sep22thAuto\\LIAutomation\\src\\test\\resources\\Propertyfile\\LIAutomation.properties";
            FileInputStream fileInputStream = new FileInputStream(propertyFilePath);
            Properties p = new Properties();
            p.load(fileInputStream);
            String value = p.getProperty(propertyname);
            fileInputStream.close();
            return (value);
        }
}

