package com.example.ukidapp.api;

import com.example.ukidapp.api.Model.AuthModel;
import com.example.ukidapp.api.Model.SetUser;
import com.example.ukidapp.src.Auth;
import com.example.ukidapp.api.Model.Movies;
import com.example.ukidapp.src.SetUpDataManager;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface RetrofitInterface {

    @POST("login")
    @Headers({"Content-Type: application/json;charset=UTF-8"})
    Call<AuthModel> login(@Body Auth user);

    @POST("register")
    @Headers({"Content-Type: application/json;charset=UTF-8"})
    Call<AuthModel> register(@Body Auth user);

    @POST("setupuser")
    @Headers({"Content-Type: application/json;charset=UTF-8"})
    Call<SetUser> setupuser(@Body SetUpDataManager user);

    @GET("movies")
    @Headers({"Content-Type: application/json;charset=UTF-8"})
    Call<Movies> getMovies();


}
