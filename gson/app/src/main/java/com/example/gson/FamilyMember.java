package com.example.gson;

import com.google.gson.annotations.SerializedName;

public class FamilyMember {

    @SerializedName("role")
    private String mrole;

    @SerializedName("age")
    private  int mage;

    public FamilyMember(String role,int age)
    {
        mrole = role;
        mage = age;
    }
}
