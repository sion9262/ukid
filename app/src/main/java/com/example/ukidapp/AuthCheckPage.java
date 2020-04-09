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

        if(!checkLogin()) {
            Intent LoginPage = new Intent(this, LoginActivity.class);
            startActivity(LoginPage);
            finish();
        }else {
            Intent MainActivity = new Intent(this, MainActivity.class);
            startActivity(MainActivity);
            finish();
        }


    }

    private boolean checkLogin(){
        SharedPreferences pref = getSharedPreferences("Auth", Activity.MODE_PRIVATE);

        String email = pref.getString("email", "");
        String jwt = pref.getString("jwt", "");

        Log.d("email", email + " " + jwt);

        // Login이 안되있을 시 True
        if (email == "" || jwt == "") {
            return false;
        }else{
            return true;
        }
    }


}
