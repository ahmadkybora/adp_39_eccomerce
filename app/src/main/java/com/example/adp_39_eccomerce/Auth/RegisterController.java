package com.example.adp_39_eccomerce.Auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.adp_39_eccomerce.R;
import com.example.adp_39_eccomerce.Routes.AuthRoutes;
import com.example.adp_39_eccomerce.Validations.AuthValidation;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterController extends AppCompatActivity{

    private EditText username, mobile, password, confirm_password;
    private Button btn_login, btn_register;
    private AuthRoutes authRoutes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        init();
    }

    private void init(){
        username = findViewById(R.id.username);
        mobile = findViewById(R.id.mobile);
        password = findViewById(R.id.password);
        confirm_password = findViewById(R.id.confirm_password);
        btn_register = findViewById(R.id.btn_register);
        btn_login = findViewById(R.id.btn_login);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernameVal = username.getText().toString();
                Integer mobileVal = mobile.getText().length();
                String passwordVal = password.getText().toString();
                String password_confirmVal = confirm_password.getText().toString();

                if(AuthValidation.validateRegister(usernameVal, mobileVal, passwordVal, password_confirmVal)) {
                    doRegister(usernameVal, mobileVal, passwordVal, password_confirmVal);
                } else {
                    Toast.makeText(RegisterController.this, "", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterController.this, LoginController.class));
            }
        });
    }

    private void doRegister(String usernameVal, Integer mobileVal, String passwordVal, String password_confirmVal) {
        Call call = authRoutes.register(usernameVal, mobileVal, passwordVal, password_confirmVal);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if(response.isSuccessful()) {

                } else {
                    Toast.makeText(RegisterController.this, "", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(RegisterController.this, "", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
