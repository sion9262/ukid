package com.example.ukidapp;


import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.EventLogTags;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;

import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.BitSet;

import static android.app.Activity.*;


public class MyPageActivity extends AppCompatActivity {

    TextView userName;
    TextView userAge;
    ImageView img;
    PieChart pieChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);


        pieChart = findViewById(R.id.piechart);
        init();
        pichate();

    }
    private void init(){
        SharedPreferences pref = getSharedPreferences("Auth", Activity.MODE_PRIVATE);
        userName = (TextView) findViewById(R.id.Name);
        userAge = (TextView) findViewById(R.id.Age);
        img = (ImageView)findViewById(R.id.MyImage);
        userName.setText("이름 : " + pref.getString("nickname", ""));
        userAge.setText("나이 : "+ pref.getString("age", "") + "세");
        String gender = pref.getString("gender", "여아");

        if(gender.equals("남아")){
            img.setImageResource(R.drawable.boy_profile2);
        }else if(gender.equals("여아")) {
            img.setImageResource(R.drawable.girl_profile);
        }
    }



    private void pichate(){

        SharedPreferences pref = getSharedPreferences("Auth", Activity.MODE_PRIVATE);

        String language = pref.getString("language", "0");
        String math = pref.getString("math", "0");
        String relationship = pref.getString("relationship", "0");
        String personal = pref.getString("personal", "0");
        String place = pref.getString("place", "0");
        String music = pref.getString("music", "0");
        String physical = pref.getString("physical", "0");
        String nature = pref.getString("nature", "0");
        System.out.println(music);
        ArrayList<Entry> datas = new ArrayList<Entry>();

        datas.add(new Entry(Float.parseFloat(language), 0));
        datas.add(new Entry(Float.parseFloat(math), 1));
        datas.add(new Entry(Float.parseFloat(relationship), 2));
        datas.add(new Entry(Float.parseFloat(personal), 3));
        datas.add(new Entry(Float.parseFloat(place), 4));
        datas.add(new Entry(Float.parseFloat(music), 5));
        datas.add(new Entry(Float.parseFloat(physical), 6));
        datas.add(new Entry(Float.parseFloat(nature), 7));
        PieDataSet dataSet = new PieDataSet(datas, "다중지능");
        dataSet.setValueTextSize(20);
        ArrayList<String> labels = new ArrayList<String>();
        labels.add("언어지능");
        labels.add("논리수학지능");
        labels.add("대인관계지능");
        labels.add("자기성찰지능");
        labels.add("공간지능");
        labels.add("음악지능");
        labels.add("신체운동지능");
        labels.add("자연친화지능");

        PieData data = new PieData(labels, dataSet);
        pieChart.setData(data);
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieChart.animateXY(2000, 2000);
    }
}