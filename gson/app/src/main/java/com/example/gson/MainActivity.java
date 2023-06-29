package com.example.gson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        Employee employee = new Employee("Athreya",21,"athreya@gmail.com");
        Gson gson = new Gson();
//        String json = gson.toJson(employee);

        String RJson = "{\"age\":21,\"first_name\":\"Athreya\",\"mail\":\"athreya@gmail.com\"}";
        Employee employee1 = gson.fromJson(RJson,Employee.class);

    }
}