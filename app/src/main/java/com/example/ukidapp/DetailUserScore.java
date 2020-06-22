package com.example.ukidapp;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.ukidapp.ui.UserDetail.DetailUserFirst;
import com.example.ukidapp.ui.UserDetail.DetailUserSecond;
import com.example.ukidapp.ui.UserDetail.DetailUserThree;

// 다중지능별 구체적인 내용 설명
public class DetailUserScore extends AppCompatActivity implements View.OnClickListener{
    Button detailFirst;
    Button detailSecond;
    Button detailThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailuserscore);


        detailFirst = (Button) findViewById(R.id.detailFirst);
        detailSecond = (Button) findViewById(R.id.detailSecond);
        detailThree = (Button) findViewById(R.id.detailThree);


        detailFirst.setOnClickListener(this);
        detailSecond.setOnClickListener(this);
        detailThree.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.detailFirst:

                break;
            case R.id.detailSecond:

                break;
            case R.id.detailThree:

                break;
        }
    }


}
