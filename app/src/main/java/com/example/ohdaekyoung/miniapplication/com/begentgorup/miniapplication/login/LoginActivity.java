package com.example.ohdaekyoung.miniapplication.com.begentgorup.miniapplication.login;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ohdaekyoung.miniapplication.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if(savedInstanceState==null)
        {
           getSupportFragmentManager().beginTransaction()
                   .add(R.id.containers,new LoginFragment())
                   .commit();
        }
    }
}
