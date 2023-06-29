package com.example.gson;

import com.google.gson.annotations.SerializedName;

public class Employee {
//if json key name and calss names dosent match use
    @SerializedName("first_name")
    private String firstName;
    private  int age;
    private String mail;

    public  Employee(String firstName,int age,String mail)
    {
        this.firstName = firstName;
        this.age = age;
        this.mail = mail;
    }
}
