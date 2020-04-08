package com.example.ukidapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class LoadingActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_loading);
        startLoading();
    }

    private void startLoading(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run(){
                Intent intent = new Intent(LoadingActivity.this, AuthCheckPage.class);
                startActivity(intent);

                finish();
            }
        }, 2000);
    }

}
