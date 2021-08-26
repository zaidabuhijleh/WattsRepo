package com.dabloons.watts.util;

import android.content.Context;
import android.content.res.AssetManager;

import com.dabloons.watts.WattsApplication;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtil {
    public static String getProperty(String key) {
        Properties properties = new Properties();
        try {
            AssetManager assetManager = WattsApplication.getContest().getAssets();
            InputStream inputStream = assetManager.open("app.properties");
            properties.load(inputStream);
            return properties.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean getPropertyAsBoolean(String key) {
        String val = ConfigUtil.getProperty(key);
        Boolean ret = Boolean.getBoolean(val);
        return ret;
    }
}
