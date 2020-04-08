package com.example.ukidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.example.ukidapp.api.RetrofitSender;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AuthCheckPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(checkLogin()) {
            Intent LoginPage = new Intent(this, LoginActivity.class);
            startActivity(LoginPage);
            finish();
        }else {
            Intent LoginPage = new Intent(this, MainActivity.class);
            startActivity(LoginPage);
            finish();
        }


    }

    private boolean checkLogin(){
        SharedPreferences pref = getSharedPreferences("Auth", Activity.MODE_PRIVATE);

        String email = pref.getString("email", "");
        String jwt = pref.getString("jwt", "");

        Log.d("email", email + " " + jwt);

        if (email == "" || jwt == "") {
            return true;
        }else{
            return false;
        }
    }

    private void login(){

        JsonObject user = new JsonObject();
        user.addProperty("email", "test@test.com");
        user.addProperty("password", "test12345");



        RetrofitSender.getServer().login(user).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                Log.e("result", response.toString());

                if (response.body() != null) {
                    Log.d("result : ", response.body().toString());
                }else {
                    Log.d("reulst : ", "비어있다.");
                }

            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Log.e("model", t.getMessage());
            }
        });
    }
}
