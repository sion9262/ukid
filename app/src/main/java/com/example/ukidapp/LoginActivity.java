package com.example.ukidapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

    public  void loginBtn(View view){
        EditText email_ET = (EditText)findViewById(R.id.email);
        EditText password_ET = (EditText)findViewById(R.id.password);

        String email = email_ET.getText().toString();
        String password = password_ET.getText().toString();

        SharedPreferences prefs = getSharedPreferences("Auth", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("email", email);
        editor.putString("jwt", password);

        editor.commit();

        Intent LoginPage = new Intent(this, MainActivity.class);
        startActivity(LoginPage);
        finish();



    }


}