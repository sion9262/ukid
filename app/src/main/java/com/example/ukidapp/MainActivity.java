package com.example.ukidapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;


import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity{

    private AppBarConfiguration mAppBarConfiguration;
    SharedPreferences prefs;
    NavigationView navigationView;
    Button settingBtn;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        init();

        navigationView.getMenu().findItem(R.id.logout).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                logout();
                return false;
            }
        });

        navigationView.getMenu().findItem(R.id.nav_study_object).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Intent DetectorAtcitivy = new Intent(MainActivity.this, DetectorActivity.class);
                startActivity(DetectorAtcitivy);
                return false;
            }
        });

        settingBtn.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent MainPage = new Intent(MainActivity.this, MyPageActivity.class);
                startActivity(MainPage);
            }
        });
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_study_object, R.id.nav_study_math, R.id.nav_study_science, R.id.nav_check_interest,
                R.id.nav_observe_kid, R.id.nav_study_image, R.id.logout)
                .setDrawerLayout(drawer)
                .build();


        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);

        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    private void init(){
        prefs = getSharedPreferences("Auth", MODE_PRIVATE);
        try{
            String nickname = prefs.getString("nickname", "");
            String gender = prefs.getString("gender", "여아");
            View navHeader = navigationView.inflateHeaderView(R.layout.nav_header_main);
            img = (ImageView)navHeader.findViewById(R.id.nav_image);
            if(gender.equals("남아")){
                img.setImageResource(R.drawable.boy_profile2);
            }else if(gender.equals("여아")) {
                img.setImageResource(R.drawable.girl_profile);
            }
            TextView tv = (TextView)navHeader.findViewById(R.id.nickName);
            settingBtn = (Button)navHeader.findViewById(R.id.settingBtn);
            tv.setText(nickname + "님 환영합니다.");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private void logout(){
        /*
        * 로그아웃시 prefs 에 저장한 Auth를 지우고 로그인페이지로 이동
        *
        * */

        SharedPreferences.Editor editor = prefs.edit();
        editor.clear();
        editor.commit();

        Intent LoginPage = new Intent(this, LoginActivity.class);
        startActivity(LoginPage);
        finish();
    }


    @Override
    public boolean onSupportNavigateUp() {

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }



}