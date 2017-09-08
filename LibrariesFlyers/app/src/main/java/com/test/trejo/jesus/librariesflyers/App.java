package com.test.trejo.jesus.librariesflyers;

import android.app.Application;
import android.content.Context;

/**
 * Created by roger on 08/09/17.
 */

public class App extends Application {

    private static App instance;

    /**
     * @return Application
     */
    public static App getInstance() {
        return instance;
    }

    /**
     * @return Context
     */
    public static Context getContext() {
        return instance.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

}