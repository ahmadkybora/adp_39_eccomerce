package com.example.adp_39_eccomerce.Routes;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AuthRoutes {
    @GET("login/{username}/{password}")
    Call login(@Path("username") String username, @Path("password") String password);

    @GET("register/{username}/{mobile}/{password}/{confirm_password}")
    Call register(@Path("username") String username,
                  @Path("mobile") Integer Mobile,
                  @Path("password") String password,
                  @Path("confirm_password") String confirm_password);
}
