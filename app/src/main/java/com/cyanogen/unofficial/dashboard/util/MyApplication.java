package com.cyanogen.unofficial.dashboard.util;

import android.app.Application;
import android.app.UiModeManager;
import android.content.Context;
import android.support.v7.app.AppCompatDelegate;

/**
 * Created by Shiva on 14-03-2016.
 */
public class MyApplication extends Application {

    static {

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO);


    }

    @Override
    public void onCreate() {
        super.onCreate();
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_AUTO);
        }
}
