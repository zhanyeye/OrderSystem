package com.example.ordersystem.entity;

public class Seat {
    public int id;
    public int count;
    public boolean available;
    public Seat(int id, int count, boolean available) {
        this.id = id;
        this.count = count;
        this.available = available;
    }
}
