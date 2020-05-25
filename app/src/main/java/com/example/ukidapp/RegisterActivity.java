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
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {

    private TextInputLayout errEmail;
    private TextInputLayout errPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

    }
    /*
        로그인 버튼 클릭하면 Auth 클래스 생성하여 로그인
     */
    public void register_button(View view){

        TextInputLayout emailLayout = findViewById(R.id.email);
        TextInputLayout passwordLayout = findViewById(R.id.password);
        String email = emailLayout.getEditText().getText().toString();
        String password = passwordLayout.getEditText().getText().toString();

        Auth user = new Auth(email, password);
        try{
            register(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void register(Auth user){
        /*
            로그인 로직
            이메일 검증
            패스워드 검증



         */
        errEmail = (TextInputLayout) findViewById(R.id.email);
        errPassword = (TextInputLayout) findViewById(R.id.password);

        if ( !user.CheckEmail()){
            // editText 에 오류났다고 표시하는 부분
            errEmail.setErrorEnabled(true);
            errEmail.setError("올바른 이메일을 입력해주세요.");
        }else{
            errEmail.setErrorEnabled(false);
        }

        if ( !user.CheckPassword()) {
            errPassword.setErrorEnabled(true);
            errPassword.setError("비밀번호가 너무 짧습니다.");
        }else {errPassword.setErrorEnabled(false);}

        // http 통신 시작
        RetrofitSender.getServer().login(user).enqueue(new Callback<AuthModel>() {
            @Override
            public void onResponse(Call<AuthModel> call, Response<AuthModel> response) {
                if (response.isSuccessful()){
                    AuthModel result = response.body();
                    System.out.println(result.getResultCode());
                    if (result.getResultCode() == 200) {
                        // 로그인 성공시 prefs에 데이터를 넣어줌
                        try {

                            SharedPreferences prefs = getSharedPreferences("Auth", MODE_PRIVATE);
                            SharedPreferences.Editor editor = prefs.edit();
                            editor.putString("email", result.getEmail());
                            editor.putString("jwt", result.getJwt());
                            editor.putString("username", result.getUsername());

                            editor.commit();


                            finish();


                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }else {
                        View contextView = findViewById(R.id.password);

                        Snackbar.make(contextView, "올바른 정보를 입력해주세요.", Snackbar.LENGTH_SHORT)
                                .show();
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