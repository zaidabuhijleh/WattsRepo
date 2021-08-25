package com.dabloons.watts.util;

import android.content.res.AssetManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.ResourceBundle;

public class PropertiesUtil {

//    private static String getPath(String path) {
//        AssetManager am = context.getAssets
//        String userDir = System.getProperty("user.dir").toString();
//        Path initial = Paths.get("").toAbsolutePath().getParent();
//
//        String part1 = initial.toString();
//        String part2 = Paths.get(path).toString();
//        String ret = Paths.get(part1, part2).toString();
//        return ret;\
//        try {
//            InputStream s
//        } catch(Exception e) {
//
//        }

//        return Paths.get(Paths.get("").toAbsolutePath().getParent().toString(), Paths.get(path).toString()).toString();
//    }

    public static String APP_PROPERTIES = "app.properties";

    public static String getProperty(String propertyFile, String propertyName) {
        System.out.println("PropFileLocation: " + propertyFile);
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
