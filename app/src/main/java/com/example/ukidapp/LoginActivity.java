package com.example.ukidapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ukidapp.api.Model.AuthModel;
import com.example.ukidapp.api.RetrofitSender;
import com.example.ukidapp.src.Auth;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView textView = (TextView)findViewById(R.id.registerText);
        textView.setText(Html.fromHtml("<font color=\"#eeac99\" ><u>회원가입</u></font>"));
    }

    public void login_button(View view){

        TextInputLayout emailLayout = findViewById(R.id.email);
        TextInputLayout passwordLayout = findViewById(R.id.password);
        String email = emailLayout.getEditText().getText().toString();
        String password = passwordLayout.getEditText().getText().toString();

        Auth user = new Auth(email, password);
        try{
            login(user);
        } catch (Exception e) {
            e.printStackTrace();
        }

        


    }

    private void login(Auth user){
        /*
            로그인 로직
            이메일 검증
            패스워드 검증

         */
        if ( !user.CheckEmail()){
            System.out.println("email 틀림");
        }

        if ( !user.CheckPassword()) {
            System.out.println("password 틀림");
        }

        RetrofitSender.getServer().login(user).enqueue(new Callback<AuthModel>() {
            @Override
            public void onResponse(Call<AuthModel> call, Response<AuthModel> response) {
                if (response.isSuccessful()){
                    AuthModel result = response.body();
                    System.out.println(result.getResultCode());
                    if (result.getResultCode() == 200) {
                        /*
                            로그인 성공 로직
                         */

                        SharedPreferences prefs = getSharedPreferences("Auth", MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();

                        try {
                            System.out.println("성공?");
                            System.out.println(result.getResultCode());
                            editor.putString("email", result.getEmail());
                            editor.putString("jwt", result.getJwt());
                            editor.putString("username", result.getUsername());

                            editor.commit();

                            Intent MainPage = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(MainPage);
                            finish();


                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }else {
                        System.out.println("알맞지 않은 정보입니다.");
                    }
                }else{
                    System.out.println("실패");
                }



            }
            @Override
            public void onFailure(Call<AuthModel> call, Throwable t) {
                System.out.println("서버 꺼짐");
            }
        });

    }



}