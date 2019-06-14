package com.example.ordersystem;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ordersystem.adapter.SeatAdapter;
import com.example.ordersystem.entity.Seat;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class SeatFragment extends Fragment {


    private RecyclerView recyclerView;
    private SeatAdapter seatAdapter;

    public SeatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_seat, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.frag_seat_recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());// 指定一个默认的布局管理器
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),LinearLayoutManager.VERTICAL));// 指定item分割线
        seatAdapter = new SeatAdapter(listSeat());
        recyclerView.setAdapter(seatAdapter); // 指定适配器

    }

    private List<Seat> listSeat() {
        Seat s1 = new Seat(1, 5, true);
        Seat s2 = new Seat(2, 5, true);
        Seat s3 = new Seat(3, 5, true);
        Seat s4 = new Seat(4, 5, true);
        Seat s5 = new Seat(5, 5, true);
        Seat s6 = new Seat(6, 5, true);
        Seat s7 = new Seat(7, 5, true);
        Seat s8 = new Seat(8, 5, true);
        Seat s9 = new Seat(9, 5, true);
        Seat s10 = new Seat(10, 5, true);
        Seat s11 = new Seat(11, 5, true);
        Seat s12 = new Seat(12, 5, true);
        Seat s13 = new Seat(13, 5, true);

        List<Seat> seats = new ArrayList<>();
        seats.add(s1);seats.add(s2);seats.add(s3);seats.add(s4);seats.add(s5);seats.add(s6);
        seats.add(s7);seats.add(s8);seats.add(s9);seats.add(s10);seats.add(s11);seats.add(s12);
        return seats;
    }
}
