package com.example.ashraf.sqlightdb;

/**
 * Created by Trainer on 9/10/2017.
 */

public class Student {
    private int id;
    private String name;
    private String phoneNumber;
    private String address,profession;

    public Student(int id, String name, String phoneNumber, String address, String profession) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.profession = profession;
    }

    public Student(String name, String phoneNumber, String address, String profession) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.profession = profession;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    @Override
    public String toString() {
        return name+" "+phoneNumber;
    }


}
