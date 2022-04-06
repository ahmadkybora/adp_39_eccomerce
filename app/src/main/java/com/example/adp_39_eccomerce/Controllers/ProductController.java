package com.example.adp_39_eccomerce.Controllers;

import androidx.recyclerview.widget.RecyclerView;

import com.example.adp_39_eccomerce.Adapters.ProductAdapter;
import com.example.adp_39_eccomerce.Models.Product;
import com.example.adp_39_eccomerce.Routes.ProductRoutes;
import com.example.adp_39_eccomerce.Utils.ApiUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductController {

    private RecyclerView recyclerView;
    private List<Product> productList;
    private ProductRoutes apiProduct;
    private ProductAdapter productAdapter;

    public void getAllProduct() {
        apiProduct = ApiUtils.getProduct();
        Call<List<Product>> call = apiProduct.getProducts();
        call.enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                productList = response.body();
                productAdapter = new ProductAdapter(productList);
                recyclerView.setAdapter(productAdapter);
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {

            }
        });
    }
}
