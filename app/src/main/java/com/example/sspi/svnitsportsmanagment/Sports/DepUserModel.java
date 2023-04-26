package com.example.sspi.svnitsportsmanagment.Models;

public class DepUserModel {
    private String name;
    private String adm_no;
    private int age;
    private String gender;
    private String dept;
    private int year;

    //needed empty constructor
    DepUserModel(){ }

    public DepUserModel(String name, String adm_no, int age, String gender, String dept, int year) {
        this.name = name;
        this.adm_no = adm_no;
        this.age = age;
        this.gender = gender;
        this.dept = dept;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdm_no() {
        return adm_no;
    }

    public void setAdm_no(String adm_no) {
        this.adm_no = adm_no;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
