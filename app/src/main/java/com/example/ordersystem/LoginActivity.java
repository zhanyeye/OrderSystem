package com.example.ordersystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText usernameInput;
    EditText passwordInput;
    Button button;
    Context that = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usernameInput = findViewById(R.id.act_login_username);
        passwordInput = findViewById(R.id.act_login_password);
        button = findViewById(R.id.act_login_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameInput.getText().toString();
                String password = passwordInput.getText().toString();

                if (username.equals("0001") && password.equals("0001")) {
                    Toast.makeText(that, "管理员登录", Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent(that, AdminActivity.class);
                    intent.putExtra("username", username);
                    startActivity(intent);

                } else if (username.equals("0002") && password.equals("0002")) {
                    Toast.makeText(that, "服务员登录", Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent(that, MainActivity.class);
                    intent.putExtra("username", username);
                    startActivity(intent);

                } else {
                    Toast.makeText(that, "用户账号或密码错误", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
