package com.example.bottomnavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentTransitionImpl;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bnView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bnView = findViewById(R.id.bnView);



      bnView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
          @Override
          public boolean onNavigationItemSelected(@NonNull MenuItem item) {
              int id = item.getItemId();

              if(id == R.id.nav_home)
              {
                  loadFragment(new fragmentA(),false);
                  return true;
              }
              else if(id == R.id.nav_search)
              {
                  loadFragment(new fragmentB(),true);
                  return true;
              }
              else if(id == R.id.nav_utilities)
              {
                  loadFragment(new fragmentC(),true);
                  return true;
              }
              else if(id == R.id.nav_contact)
              {
                  loadFragment(new fragmentD(),true);
                  return true;
              }
              else
              {
                  loadFragment(new fragmentE(),true);
                  return  true;
              }

          }
      });

        bnView.setSelectedItemId(R.id.nav_home);// use only after the listener  and this line makes default selected as home
    }

    public void loadFragment(Fragment fragment,boolean flag)
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        if(!flag)
            ft.add(R.id.container,fragment);
        else
            ft.replace(R.id.container,fragment);
        ft.commit();
    }
}