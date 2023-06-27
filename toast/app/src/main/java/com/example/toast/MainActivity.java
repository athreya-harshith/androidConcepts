package com.example.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnToast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnToast = findViewById(R.id.btnToast);

        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(),"This is my first toast",Toast.LENGTH_SHORT).show();

                Toast toast = new Toast(MainActivity.this);
                View v = getLayoutInflater().inflate(R.layout.custom_toast,(ViewGroup) findViewById(R.id.toastViewGroup));

                toast.setView(v);

                TextView toastMessage = v.findViewById(R.id.toastMessage);
                toastMessage.setText("This is a custom toast !!!!! ");
                toast.setDuration(Toast.LENGTH_SHORT);
                //toast.setGravity();
                toast.show();
            }
        });
    }
}