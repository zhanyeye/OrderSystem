package com.example.ordersystem.adapter;

import android.graphics.Color;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ordersystem.R;
import com.example.ordersystem.entity.Seat;

import java.util.List;

public class SeatAdapter extends RecyclerView.Adapter<SeatAdapter.MyViewHolder> {

    private List<Seat> seats;
    public SeatAdapter(List<Seat> seats) {
        this.seats = seats;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item_seat, parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        holder.id.setText("餐桌号：" + String.valueOf(seats.get(position).id));
        holder.available.setText(seats.get(position).available ? "可用" : "不可用");
        holder.available.setBackgroundColor(Color.parseColor(seats.get(position).available ? "#00FF7F" : "#FF6347"));
        holder.cnt.setText("座位数：" + seats.get(position).count);
        holder.open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.available.setBackgroundColor(Color.parseColor("#FF6347"));
                holder.available.setText("不可用");
            }
        });
        holder.clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.available.setBackgroundColor(Color.parseColor("#00FF7F"));
                holder.available.setText("可用");
            }
        });
        holder.change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.available.setBackgroundColor(Color.parseColor("#87CEFA"));
                holder.available.setText("换桌中");
            }
        });
    }

    @Override
    public int getItemCount() {
        return seats.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView id;
        TextView available;
        TextView cnt;
        Button open;
        Button clean;
        Button change;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.rec_seat_id);
            available = itemView.findViewById(R.id.rec_seat_available);
            cnt = itemView.findViewById(R.id.rec_seat_cnt);
            open = itemView.findViewById(R.id.rec_seat_open);
            clean = itemView.findViewById(R.id.rec_seat_clean);
            change = itemView.findViewById(R.id.rec_seat_change);
        }



    }
}
