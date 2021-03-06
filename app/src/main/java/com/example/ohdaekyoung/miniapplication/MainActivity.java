package com.example.ohdaekyoung.miniapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ohdaekyoung.miniapplication.Chatting.ChattingFragment;
import com.example.ohdaekyoung.miniapplication.facebook.FacebookFragment;
import com.example.ohdaekyoung.miniapplication.store.TStoreFragment;
import com.example.ohdaekyoung.miniapplication.youtube.YoutubeFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ImageView profileView;
    TextView nameView, emailView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View headerView=navigationView.getHeaderView(0);
        profileView = (ImageView)headerView.findViewById(R.id.image_profile);
        nameView = (TextView)headerView.findViewById(R.id.text_name);
        emailView = (TextView)headerView.findViewById(R.id.text_email);
        if(savedInstanceState==null)//맨처음 구동되면
        {
            getSupportFragmentManager().beginTransaction().add(R.id.container,new TStoreFragment()).commit();
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
       // setMyInfo();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_tstore) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new TStoreFragment()).commit();
            // Handle the camera action
        } else if (id == R.id.nav_facebook) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new FacebookFragment()).commit();

        } else if (id == R.id.nav_youtube) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container,new YoutubeFragment()).commit();

        } else if (id == R.id.nav_chatting) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new ChattingFragment()).commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
