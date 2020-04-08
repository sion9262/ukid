package com.example.ukidapp.api;

import com.example.ukidapp.api.RetrofitInterface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSender {

    public static final String BASE_URL = "";
    private static Retrofit retrofit = null;
    private static RetrofitInterface server = null;

    public static RetrofitInterface getServer(){
        if (server == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://10.0.2.2:8000/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            server = retrofit.create(RetrofitInterface.class);
        }

        return server;
    }

}
