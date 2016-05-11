package com.example.ohdaekyoung.miniapplication;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ohdaekyoung.miniapplication.com.begentgorup.miniapplication.login.LoginActivity;
import com.facebook.AccessToken;

public class SplashActivity extends AppCompatActivity {
    Handler mHandler = new Handler(Looper.getMainLooper());
    AccessToken token=AccessToken.getCurrentAccessToken();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
      //  if(token==null) {
            mHandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    finish();
                }
            }, 2000);
    /*    }else {
           mHandler.postDelayed(new Runnable() {
               @Override
                public void run() {
                   startActivity(new Intent(SplashActivity.this, MainActivity.class));
                   finish();
               }
           }, 2000);
        }*/

    }
}
