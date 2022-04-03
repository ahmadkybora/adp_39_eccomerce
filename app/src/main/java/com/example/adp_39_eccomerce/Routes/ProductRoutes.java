package com.example.adp_39_eccomerce.Routes;

import com.example.adp_39_eccomerce.Models.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductRoutes {
    @GET("products")
    Call<List<Product>> getProducts();


}
