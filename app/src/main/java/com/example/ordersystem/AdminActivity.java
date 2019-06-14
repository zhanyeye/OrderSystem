package com.example.ordersystem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class AdminActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        textView = findViewById(R.id.act_admin_textview);
        String msg = getIntent().getStringExtra("username");
        textView.setText(textView.getText().toString() + " : " + msg);
    }
}
