package com.example.adp_39_eccomerce.Auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.adp_39_eccomerce.MainActivity;
import com.example.adp_39_eccomerce.R;
import com.example.adp_39_eccomerce.Routes.AuthRoutes;
import com.example.adp_39_eccomerce.Utils.ApiUtils;
import com.example.adp_39_eccomerce.Validations.AuthValidation;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginController extends AppCompatActivity {
    private EditText username, password;
    private Button btn_login, btn_register;
    private AuthRoutes authRoutes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        init();
    }

    private void init() {
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        btn_login = findViewById(R.id.btn_login);
        btn_register = findViewById(R.id.btn_register);
//        login = ApiUtils.login();

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernameVal = username.getText().toString();
                String passwordVal = password.getText().toString();

                if(AuthValidation.validateLogin(usernameVal, passwordVal)) {
                    doLogin(usernameVal, passwordVal);
                } else {
                    Toast.makeText(LoginController.this, "wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginController.this, RegisterController.class));
            }
        });
    }

    private void doLogin(String usernameVal, String passwordVal) {
        Call call = authRoutes.login(usernameVal, passwordVal);
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                if(response.isSuccessful()){
                    Intent intent = new Intent(LoginController.this, MainActivity.class);
                    intent.putExtra("username", usernameVal);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginController.this, "", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(LoginController.this, "", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
