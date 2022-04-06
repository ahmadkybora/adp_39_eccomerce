package com.example.adp_39_eccomerce.Utils;

import com.example.adp_39_eccomerce.Models.Product;
import com.example.adp_39_eccomerce.Routes.AuthRoutes;
import com.example.adp_39_eccomerce.Routes.ProductRoutes;

public class ApiUtils {
    public static final String BASE_URL = "https://fakestoreapi.com/";

    public static AuthRoutes login() {
        return RetrofitClient.getClient(BASE_URL).create(AuthRoutes.class);
    }

    public static AuthRoutes register() {
        return RetrofitClient.getClient(BASE_URL).create(AuthRoutes.class);
    }

    public static ProductRoutes getProduct() {
        return RetrofitClient.getClient(BASE_URL).create(ProductRoutes.class);
    }
}
