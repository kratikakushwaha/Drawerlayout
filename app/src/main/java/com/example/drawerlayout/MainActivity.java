package com.example.drawerlayout;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import  android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
  Toolbar toolbar;
    DrawerLayout drawerLayout;
     NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setNavigation();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

    }



    private void setNavigation()
    {
        drawerLayout=findViewById(R.id.drawer);
        navigationView=findViewById(R.id.navigation);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
               Fragment frag=null;
                int itemId=menuItem.getItemId();
                if (itemId == R.id.first) {
                    Toast.makeText(MainActivity.this,"this is home", Toast.LENGTH_SHORT).show();
              }

            if (itemId == R.id.first) {
                   frag = new Fragment1();
             } else if (itemId == R.id.second) {
                  frag = new Fragment2();
               } else if (itemId == R.id.third) {
                   frag = new Fragment3();             }


                Toast.makeText(getApplicationContext(), menuItem.getTitle(), Toast.LENGTH_SHORT).show();
             if (frag != null) {
                   FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                   transaction.replace(R.id.frame, frag);
                   transaction.commit();
                   drawerLayout.closeDrawers();
                    return true;
                }

                return false;
            }
        });

    }
}
