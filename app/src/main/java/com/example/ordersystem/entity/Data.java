package com.example.ordersystem.entity;

import java.util.ArrayList;
import java.util.List;

public class Data {
    public static int id = 0;
    public static double tmpPrice = 0; // 临时总价
    public static List<Food> foodList = new ArrayList<>();  //菜品清单
    public static Order order = new Order();  //订单
    public static void addFood(String name, double price) {
        tmpPrice += price;
        foodList.add(new Food(name, price));
    }

    public static void checkOut(){
        order.foodlist = foodList;
        order.id = ++id;
        order.totalPrice = tmpPrice;
        tmpPrice = 0;
        foodList = new ArrayList<>();
    }

}
