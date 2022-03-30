package com.example.adp_39_eccomerce;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.adp_39_eccomerce.Auth.LoginController;
import com.example.adp_39_eccomerce.Auth.RegisterController;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn_login, btn_register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        btn_login = findViewById(R.id.btn_login);
        btn_register = findViewById(R.id.btn_register);

        btn_login.setOnClickListener(this);
        btn_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                startActivity(new Intent(this, LoginController.class));
                break;

            case R.id.btn_register:
                startActivity(new Intent(this, RegisterController.class));
                break;
        }
    }
}