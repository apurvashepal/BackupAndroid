package com.example.apiapplication.Application;


import android.app.Application;

public class App extends Application {

        private static App _application;

        public static App getApplication() {
            return _application;
        }

        @Override
        public void onCreate() {
            super.onCreate();

            App._application = this;
        }
    }

