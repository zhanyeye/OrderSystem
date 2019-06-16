package com.example.ordersystem.entity;

public class Food {
    public int id;
    public String picAdress;
    public String name;
    public String detail;
    public double price;

    public Food(int id, String name, String detail, double price) {
        this.id = id;
        this.name = name;
        this.detail = detail;
        this.price = price;
    }

}
