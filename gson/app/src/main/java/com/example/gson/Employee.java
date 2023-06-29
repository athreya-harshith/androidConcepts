package com.example.gson;

import com.google.gson.annotations.SerializedName;

public class Employee {
//if json key name and calss names dosent match use
    @SerializedName("first_name")
    private String firstName;
    private  int age;
    private String mail;

    @SerializedName("address")
    private Address maddress;
    public  Employee(String firstName,int age,String mail,Address address)
    {
        this.firstName = firstName;
        this.age = age;
        this.mail = mail;
        maddress = address;
    }
}
