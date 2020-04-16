package com.example.ukidapp;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.ukidapp.ui.UserSetUp.FirstFragment;
import com.example.ukidapp.ui.UserSetUp.SecondFragment;
import com.example.ukidapp.ui.UserSetUp.ThreeFragment;

/*
    Fragment 이용 설문 통해 받기
 */

public class SetUserInfoActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private FirstFragment firstFragment;
    private SecondFragment secondFragment;
    private ThreeFragment threeFragment;

    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

        fragmentManager = getSupportFragmentManager();
        firstFragment = new FirstFragment();
        secondFragment = new SecondFragment();
        threeFragment = new ThreeFragment();

        transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.SetupUserLayout, firstFragment).commitAllowingStateLoss();
    }

    public void clickHandler(View view){
        transaction = fragmentManager.beginTransaction();

        switch (view.getId()){
            case R.id.btn_fragmentA:
                transaction.replace(R.id.SetupUserLayout, firstFragment).commitAllowingStateLoss();
                break;
            case R.id.btn_fragmentB:
                transaction.replace(R.id.SetupUserLayout, secondFragment).commitAllowingStateLoss();
                break;
        }
    }

}