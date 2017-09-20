package com.example.ashraf.sqlightdb;

/**
 * Created by Trainer on 9/10/2017.
 */

public class Student {
    private int id;
    private String name;
    private String phoneNumber;


    public Student(int id, String name, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Student(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;

    }

    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    @Override
    public String toString() {
        return name+" "+phoneNumber;
    }


}
