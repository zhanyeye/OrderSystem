package com.example.ordersystem.entity;

import java.util.List;

public class Order {
    public int id;
    public List<Food> foodlist;
    public double totalPrice;

    public Order() {

    }

    public Order(int id, List<Food> foodlist, double totalPrice) {
        this.id = id;
        this.foodlist = foodlist;
        this.totalPrice = totalPrice;
    }
}
