package com.example.ordersystem.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.ordersystem.OrderFragment;
import com.example.ordersystem.entity.Food;
import com.example.ordersystem.entity.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderViewModel extends AndroidViewModel {

    public MutableLiveData<List<Order>> orderLoad = new MutableLiveData<>();

    public OrderViewModel(@NonNull Application application) {
        super(application);
    }

    private void initOrders() {
        new Thread(() -> {
            orderLoad.postValue(listOrder());
        }).start();
    }



    private List<Order> listOrder() {
        List<Food> foods = new ArrayList<>();
        Food f1 = new Food(1, "山芋圆子    ", "非常好吃 非常好吃\n非常好吃 非常好吃\n", 20);
        Food f2 = new Food(2, "红烧肉        ", "非常好吃 非常好吃\n非常好吃 非常好吃\n", 30);
        Food f3 = new Food(3, "炒面            ", "非常好吃 非常好吃\n非常好吃 非常好吃\n", 18);
        Food f4 = new Food(4, "牛肉拉面    ", "非常好吃 非常好吃\n非常好吃 非常好吃\n", 10);
        Food f5 = new Food(5, "大盘鸡        ", "非常好吃 非常好吃\n非常好吃 非常好吃\n", 25);
        Food f6 = new Food(6, "番茄鸡蛋汤", "非常好吃 非常好吃\n非常好吃 非常好吃\n", 15);
        foods.add(f1); foods.add(f2); foods.add(f3); foods.add(f4);foods.add(f5); foods.add(f6);
        Order o1 = new Order(1, foods, 68);
        Order o2 = new Order(2, foods, 68);
        Order o3 = new Order(3, foods, 68);
        Order o4 = new Order(4, foods, 68);
        List<Order> orderList = new ArrayList<>();
        orderList.add(o1);orderList.add(o2);orderList.add(o3);orderList.add(o4);
        return orderList;
    }
}
