package com.example.ordersystem.adapter;

import android.app.AlertDialog;


import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ordersystem.MainActivity;
import com.example.ordersystem.R;
import com.example.ordersystem.entity.Food;
import com.example.ordersystem.util.MyApplication;


import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.MyViewHolder> {

    private List<Food> foodlist;
    public FoodAdapter(List<Food> foodlist) {
        this.foodlist = foodlist;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item_food, parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        holder.name.setText(foodlist.get(position).name);
        holder.detail.setText(foodlist.get(position).detail);
        holder.price.setText("价格：" + foodlist.get(position).price + "");
        holder.buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.instance); //更具MainActivity.instance 拿到 MainActivity 的上下文
                dialog.setTitle("选购");
                dialog.setMessage("是否选中");

                // 确认按钮回调
                dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MyApplication.getInstance(), "已选中", Toast.LENGTH_SHORT).show();
                    }
                });
                // 取消回调
                dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                dialog.show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return foodlist.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView price;
        TextView detail;
        Button buyButton;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.rec_food_name);
            price = itemView.findViewById(R.id.rec_food_price);
            detail = itemView.findViewById(R.id.rec_food_detail);
            buyButton = itemView.findViewById(R.id.rec_food_buy);
        }



    }
}
