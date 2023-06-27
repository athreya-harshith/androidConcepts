package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnNext = (Button) findViewById(R.id.btnNext);

        Intent itn = new Intent(MainActivity.this,SecondActivity.class);
       itn.putExtra("title","home");
       itn.putExtra("name","Athreya");
       itn.putExtra("RollNo",051);
        btnNext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(itn);
            }
        });
    }
}