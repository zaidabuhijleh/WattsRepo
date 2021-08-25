package com.dabloons.watts.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

    public static String LOCAL_PROPERTIES = "local.properties";

    public static String getProperty(String propertyFile, String propertyName) {
        String result = null;
        InputStream inputStream = null;
        try {
            Properties props = new Properties();
            inputStream = ClassLoader.class.getResourceAsStream(propertyFile);
            if(inputStream != null) {
                props.load(inputStream);
            } else {
                throw new FileNotFoundException("Property file '" + propertyFile + "' could not be found");
            }

            result = props.getProperty(propertyName);
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(inputStream != null)
                    inputStream.close();
            } catch(IOException ex) {
                ex.printStackTrace();;
            }
        }

        return result;
    }

    public static boolean getPropertyAsBoolean(String propertyFile, String propertyName) {
        String res = PropertiesUtil.getProperty(propertyFile, propertyName);
        return Boolean.getBoolean(res);
    }
}
