package com.example.adp_39_eccomerce.Utils;

import com.example.adp_39_eccomerce.Routes.AuthRoutes;

public class ApiUtils {
    public static final String BASE_URL = "";

    public static AuthRoutes login() {
        return RetrofitClient.getClient(BASE_URL).create(AuthRoutes.class);
    }

    public static AuthRoutes register() {
        return RetrofitClient.getClient(BASE_URL).create(AuthRoutes.class);
    }
}
