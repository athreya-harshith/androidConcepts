package com.example.fragments1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.provider.DocumentsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnfragA,btnfragB,btnfragC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnfragA = findViewById(R.id.btnFragA);
        btnfragB = findViewById(R.id.btnFragB);
        btnfragC = findViewById(R.id.btnFragC);

        loadFragment(new fragmentB(),false);//default fragment
        btnfragA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new fragmentA(),true);
            }
        });

        btnfragB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(new fragmentB(),true);
            }
        });

        btnfragC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadFragment(fragmentC.getInstance("Athreya" ,51),true);
            }
        });

    }

    public  void loadFragment(Fragment fragment,boolean flag)
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

//        passing data to the fragment from main activity

//        Bundle bundle = new Bundle();
//        bundle.putString("Argu1","Raman");
//        bundle.putInt("Argu2",10);
//
//        fragment.setArguments(bundle);

        if(!flag) {
            ft.add(R.id.container, fragment);//add the first fragment

            fm.popBackStack(fragment.getId(), FragmentManager.POP_BACK_STACK_INCLUSIVE);
            //ft.addToBackStack(fragment.getString(fragment.getId()));
        }
        else
            ft.replace(R.id.container,fragment);//replace for all others except thr first

        ft.addToBackStack(null);//on back press goes to the previous fragment
        ft.commit();
    }

    public void callFromFragment()
    {
        Log.d("In the MainActivity ","Called from the fragment");
    }

}