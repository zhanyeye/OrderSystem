package com.example.ordersystem.adapter;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ordersystem.MainActivity;
import com.example.ordersystem.R;
import com.example.ordersystem.entity.Food;
import com.example.ordersystem.entity.Order;
import com.example.ordersystem.util.MyApplication;

import java.util.List;


public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.MyViewHolder> {

    private List<Order> orderlist;
    public OrderAdapter(List<Order> orderlist) {
        this.orderlist = orderlist;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item_order, parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        holder.orderId.setText("订单号" + orderlist.get(position).id);
        holder.price.setText("总价：" + orderlist.get(position).totalPrice + " 元");
        String str = "";
        for (Food f : orderlist.get(position).foodlist) {
            str += (f.name + " ............ " + f.price + "\n");
        }
        holder.content.setText(str);
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.instance); //更具MainActivity.instance 拿到 MainActivity 的上下文
                dialog.setTitle("结账");
                dialog.setMessage("是否结账");

                // 确认按钮回调
                dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MyApplication.getInstance(), "加载中", Toast.LENGTH_SHORT).show();
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
        return orderlist.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView orderId;
        TextView content;
        TextView price;
        Button button;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            orderId = itemView.findViewById(R.id.rec_order_id);
            content = itemView.findViewById(R.id.rec_order_content);
            price = itemView.findViewById(R.id.rec_order_price);
            button = itemView.findViewById(R.id.rec_order_buy);
        }



    }
}
