package com.example.ordersystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.ordersystem.entity.Data;
import com.example.ordersystem.entity.Food;

import java.util.List;

public class CheckOutActivity extends AppCompatActivity {

    private TextView namelist;
    private TextView pricelist;
    private TextView totalprice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);
        namelist = findViewById(R.id.act_checkout_name);
        pricelist = findViewById(R.id.act_checkout_price);
        totalprice = findViewById(R.id.act_checkout_totalprice);
        List<Food> foodList = Data.order.foodlist;
        String name = "";
        String price = "";
        for (Food f : foodList) {
            name += f.name + "\n";
            price += (".....    " +  f.price + "元\n");
        }
        namelist.setText(name);
        pricelist.setText(price);
        totalprice.setText("总价" + Data.order.totalPrice + "元");
    }
}
