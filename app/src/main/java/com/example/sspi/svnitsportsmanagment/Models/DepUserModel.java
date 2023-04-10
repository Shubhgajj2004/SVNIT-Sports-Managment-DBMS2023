package com.example.sspi.svnitsportsmanagment.Models;

public class DepUserModel {
    String name, rollNo;

    //needed empty constructor
    DepUserModel(){ }

    public DepUserModel(String name, String rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }
}
