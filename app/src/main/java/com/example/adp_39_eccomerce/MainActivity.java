package com.example.adp_39_eccomerce;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.adp_39_eccomerce.Adapters.ProductAdapter;
import com.example.adp_39_eccomerce.Auth.LoginController;
import com.example.adp_39_eccomerce.Auth.RegisterController;
import com.example.adp_39_eccomerce.Controllers.ProductController;
import com.example.adp_39_eccomerce.Models.Product;
import com.example.adp_39_eccomerce.Routes.ProductRoutes;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    RecyclerView recyclerView;
    List<Product> productList;
    ProductAdapter adapter;
    LinearLayoutManager layoutManager;
    private TextView textViewResult;
    private Button btn_login, btn_register;
    private ProductRoutes productRoutes;
    private ProductController productController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        initRecyclerView();
        productController = new ProductController();
        productController.getAllProduct();
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

//    public void getProducts(){
//        Call<List<Product>> call = productRoutes.getProducts();
//        call.enqueue(new Callback<List<Product>>() {
//            @Override
//            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
//                if(!response.isSuccessful()) {
//                    textViewResult.setText("Code :" + response.code());
//                    return;
//                } else {
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Product>> call, Throwable t) {
//
//            }
//        });
//    }

//    private void initData() {
//        productList = new ArrayList<>();
//        productList.add(new Product(R.drawable.ic_launcher_background, "viz", "00", "11", "22"));
//        productList.add(new Product(R.drawable.ic_launcher_foreground, "viz", "00", "11", "22"));
//    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ProductAdapter(productList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}