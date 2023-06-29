package com.example.gson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        List<FamilyMember> family = new ArrayList<>();

        family.add(new FamilyMember("Brother",18));
        family.add(new FamilyMember("Cousin",25));
//        Address address = new Address("India","Bangalore");
//        Employee employee = new Employee("Athreya",21,"athreya@gmail.com",address,family);
        Gson gson = new Gson();
//        String json = gson.toJson(employee);

        String familyJson = gson.toJson(family);
//        String RJson ="{\"age\":21,\"first_name\":\"Athreya\",\"address\":{\"city\":\"Mysore\",\"country\":\"India\"},\"mail\":\"athreya@gmail.com\"}";
//        Employee employee1 = gson.fromJson(RJson,Employee.class);
        Type familyType = new TypeToken<ArrayList<FamilyMember>>(){}.getType();
        String RFamilyJson = "[{\"age\":18,\"role\":\"Brother\"},{\"age\":25,\"role\":\"Cousin\"}]";

        List<FamilyMember> jsonToFailyList = gson.fromJson(RFamilyJson,familyType);
    }
}