package com.example.ukidapp;



import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.ukidapp.api.Model.SetUser;
import com.example.ukidapp.api.RetrofitSender;
import com.example.ukidapp.src.SetUpDataManager;
import com.example.ukidapp.ui.UserSetUp.FirstFragment;
import com.example.ukidapp.ui.UserSetUp.SecondFragment;
import com.example.ukidapp.ui.UserSetUp.ThreeFragment;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/*
* 로그인 후 첫 유저가 등록했을 시
* 설문 조사 및 정보 입력받는 곳
* */
public class SetUserInfoActivity extends AppCompatActivity implements View.OnClickListener {

    private int mPage = 3;
    private int pageIndex = 1;

    Button next;
    Button prev;
    FragmentManager fm;
    FragmentTransaction tran;
    FirstFragment firstFragment;
    SecondFragment secondFragment;
    ThreeFragment threeFragment;

    SetUpDataManager User;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

        next = (Button)findViewById(R.id.nextButton);
        prev = (Button)findViewById(R.id.prevButton);
        next.setOnClickListener(this);
        prev.setOnClickListener(this);
        firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();
        threeFragment = new ThreeFragment();
        fm = getSupportFragmentManager();

        User = new SetUpDataManager();
        setFrag(1);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.nextButton:
                if (next.getText() == "완료"){

                    if (checkAllData()) {
                        System.out.println("ok");
                        postUserInfo();

                    }else {
                        errToast();
                    }
                }
                if (mPage > pageIndex) {
                    pageIndex++;
                    setFrag(pageIndex);
                }
                break;
            case R.id.prevButton:
                if (pageIndex > 0){
                    pageIndex--;
                    setFrag(pageIndex);
                }
        }
    }

    public void setFrag(int n){

        tran = fm.beginTransaction();

        switch (n) {
            case 1 :
                prev.setVisibility(View.INVISIBLE);
                next.setVisibility(View.VISIBLE);
                tran.replace(R.id.SetUser, this.firstFragment);
                tran.commit();
                break;
            case 2 :
                if (next.getText() == "완료") { next.setText("다음 >");}
                if (firstFragment.checkData()) {
                    prev.setVisibility(View.VISIBLE);
                    tran.replace(R.id.SetUser, this.secondFragment);
                    tran.commit();
                }else {
                    pageIndex--;
                    errToast();
                }

                break;
            case 3 :
                if(secondFragment.checkData()) {
                    next.setText("완료");
                    tran.replace(R.id.SetUser, this.threeFragment);
                    tran.commit();
                }else{
                    pageIndex--;
                    errToast();
                }

                break;
        }
    }

    private void errToast(){
        Toast toast = Toast.makeText(getApplicationContext(), "정보를 입력해주세요.", Toast.LENGTH_LONG);
        toast.show();
    }

    private boolean checkAllData(){
        // 모든 fragment의 데이터 가져오는 부분.
        JSONObject initUserData = firstFragment.getData();

        try {
            User.setName(initUserData.getString("name"));
            User.setAge(Integer.parseInt(initUserData.getString("age")));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        User.setLanguage(secondFragment.getData());

        return true;
    }


    private void postUserInfo() {
        SharedPreferences pref = getSharedPreferences("Auth", Activity.MODE_PRIVATE);

        User.setId(pref.getString("id", ""));
        // http 통신 시작
        RetrofitSender.getServer().setupuser(User).enqueue(new Callback<SetUser>() {
            @Override
            public void onResponse(Call<SetUser> call, Response<SetUser> response) {
                if (response.isSuccessful()){
                    SetUser result = response.body();
                    System.out.println(result.getResultCode());
                    if (result.getResultCode() == 200) {
                        SharedPreferences pref = getSharedPreferences("Auth", Activity.MODE_PRIVATE);
                        SharedPreferences.Editor editor = pref.edit();
                        editor.putString("checkSetUp", "SetUp");
                        editor.commit();

                        Intent MainPage = new Intent(SetUserInfoActivity.this, MainActivity.class);
                        startActivity(MainPage);
                        finish();
                    }
                }else{
                    errToast();
                }

            }
            @Override
            public void onFailure(Call<SetUser> call, Throwable t) {
                System.out.println("서버 꺼짐");
            }
        });
    }

}
    