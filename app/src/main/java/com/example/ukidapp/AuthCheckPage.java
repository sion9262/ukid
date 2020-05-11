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

/*
* 로딩 후 activity 정해주는 것.
*
* */
public class AuthCheckPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int check = checkLogin();
        if(check == 1) {
            Intent LoginPage = new Intent(this, LoginActivity.class);
            startActivity(LoginPage);
            finish();
        } else if (check == 2) {
            Intent SetUpPage = new Intent(this, SetUserInfoActivity.class);
            startActivity(SetUpPage);
            finish();
        } else {
            Intent MainActivity = new Intent(this, MainActivity.class);
            startActivity(MainActivity);
            finish();
        }


    }

    private int checkLogin(){
        SharedPreferences pref = getSharedPreferences("Auth", Activity.MODE_PRIVATE);

        String email = pref.getString("email", "");
        String jwt = pref.getString("jwt", "");
        String checkSetUp = pref.getString("checkSetUp", "");

        Log.d("email", email + " " + jwt);

        /*
        * 로그인이 안되있다면 1
        * 로그인이 됬다면 초기 셋팅 안했다면 2
         * 그게 아니면 0
        * */
        if (email == "" || jwt == "") {
            return 1;
        } else{
            if ( checkSetUp == ""){
                return 2;
            }
            return 0;
        }
    }


}
