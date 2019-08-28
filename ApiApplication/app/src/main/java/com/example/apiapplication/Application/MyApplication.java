package com.example.apiapplication.Application;


import android.content.Context;

public class MyApplication extends android.app.Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        Preferences.init(context);


    }
    public static Context getContext()
    {
        return context;
    }
}
