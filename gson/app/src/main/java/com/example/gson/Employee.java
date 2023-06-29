package com.example.gson;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Employee {
//if json key name and calss names dosent match use
    @SerializedName("first_name")
    private String firstName;
    private  int age;
    private String mail;

    @SerializedName("address")
    private Address maddress;

    @SerializedName("family")
    private List<FamilyMember>  mFamily;

    private transient  String password; // this is used if some field that must not be included in the json

    @Expose(serialize = false,deserialize = true)
    private String uid;
    public  Employee(String firstName,int age,String mail,Address address,List<FamilyMember> family)
    {
        this.firstName = firstName;
        this.age = age;
        this.mail = mail;
        maddress = address;

        mFamily = family;
    }
}
