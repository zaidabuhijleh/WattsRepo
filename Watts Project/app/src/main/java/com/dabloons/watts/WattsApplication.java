package com.dabloons.watts;

import android.app.Application;
import android.content.Context;

public class WattsApplication extends Application {
    private static WattsApplication instance;

    public static WattsApplication getInstance() {
        return instance;
    }

    public static Context getContest() {
        return instance.getApplicationContext();
    }

    @Override
    public void onCreate() {
        instance = this;
        super.onCreate();
    }
}
