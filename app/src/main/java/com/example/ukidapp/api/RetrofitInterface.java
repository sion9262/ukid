package com.example.ukidapp.api;

import com.example.ukidapp.api.Model.AuthModel;
import com.google.gson.JsonObject;

import org.json.JSONObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface RetrofitInterface {

    @POST("login")
    @Headers({"Content-Type: application/json;charset=UTF-8"})
    Call<JsonObject> login(@Body JsonObject data);


}
