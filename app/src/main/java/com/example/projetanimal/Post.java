package com.example.projetanimal;

public class Post {
    String name;
    String type;
    String age;
    String address;
    int phone;

    public Post(String name, String type, String age, String address, int phone) {
        this.name = name;
        this.type = type;
        this.age = age;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public int getPhone() {
        return phone;
    }
}
