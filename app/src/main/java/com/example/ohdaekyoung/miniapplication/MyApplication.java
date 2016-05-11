package com.example.ohdaekyoung.miniapplication;

import android.app.Application;
import android.content.Context;

import com.facebook.FacebookSdk;

/**
 * Created by Tacademy on 2016-05-10.
 */
public class MyApplication extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        this.context=getApplicationContext();
        FacebookSdk.sdkInitialize(this);//getApplicationContext());
    }
    public static Context getContext(){
        return context;
    }
}
