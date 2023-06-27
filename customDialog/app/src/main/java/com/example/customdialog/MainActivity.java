package com.example.customdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Dialog d = new Dialog(MainActivity.this);

        d.setContentView(R.layout.custom_dialog);
        d.setCancelable(false);
        Button btnOkay = d.findViewById(R.id.btnOkay);

        btnOkay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Closed",Toast.LENGTH_SHORT).show();
                d.dismiss();
            }
        });
        d.show();
    }
}