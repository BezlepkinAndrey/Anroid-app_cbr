package com.example.a1.InterfaceAPI;

import com.example.a1.Model.LoginAuth;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Auth {
    @POST("login")
    Call<LoginAuth> login(@Query("email") String email,
                          @Query("password") String password);
}
