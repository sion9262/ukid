package com.example.ukidapp;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.ukidapp.ui.UserSetUp.FirstFragment;
import com.example.ukidapp.ui.UserSetUp.SecondFragment;
import com.example.ukidapp.ui.UserSetUp.ThreeFragment;

import org.json.JSONException;
import org.json.JSONObject;

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

        setFrag(1);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.nextButton:
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
                if (firstFragment.getData()) {
                    prev.setVisibility(View.VISIBLE);
                    tran.replace(R.id.SetUser, this.secondFragment);
                    tran.commit();
                }else {
                    pageIndex--;
                    Toast toast = Toast.makeText(getApplicationContext(), "정보를 입력해주세요.", Toast.LENGTH_LONG);
                    toast.show();
                }

                break;
            case 3 :
                if(secondFragment.checkData()) {
                    next.setVisibility(View.INVISIBLE);
                    tran.replace(R.id.SetUser, this.threeFragment);
                    tran.commit();
                }else{
                    pageIndex--;
                    Toast toast = Toast.makeText(getApplicationContext(), "정보를 입력해주세요.", Toast.LENGTH_LONG);
                    toast.show();
                }

                break;
        }
    }





}
    