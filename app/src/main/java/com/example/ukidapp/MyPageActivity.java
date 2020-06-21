package com.example.ukidapp;


import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.BitSet;

import static android.app.Activity.*;


public class MyPageActivity extends AppCompatActivity {

    TextView userName;
    TextView userAge;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);
        init();
        PieChart pieChart;
        pieChart = findViewById(R.id.piechart);

        pieChart.setUsePercentValues(true);
        Description description = new Description();
        description.setText("다중지능"); //라벨
        description.setTextSize(15);
        pieChart.setDescription(description);


        PieDataSet dataSet = new PieDataSet(dataValue(),"");
        PieData data = new PieData((dataSet));
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieChart.animateXY(2000, 2000);
        pieChart.setData(data);
    }
    private void init(){
        SharedPreferences pref = getSharedPreferences("Auth", Activity.MODE_PRIVATE);
        userName = (TextView) findViewById(R.id.Name);
        userAge = (TextView) findViewById(R.id.Age);
        userName.setText("이름 : " + pref.getString("nickname", ""));
        userAge.setText("나이 : "+ pref.getString("age", "") + "세");
    }



    private ArrayList<PieEntry> dataValue(){
        ArrayList<PieEntry> dataVals = new ArrayList<>();
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
        dataVals.add(new PieEntry(Float.parseFloat(language), "언어지능"));
        dataVals.add(new PieEntry(Float.parseFloat(math), "수학지능"));
        dataVals.add(new PieEntry(Float.parseFloat(relationship), "인간관계지능"));
        dataVals.add(new PieEntry(Float.parseFloat(personal), "개인성찰지능"));
        dataVals.add(new PieEntry(Float.parseFloat(place), "공간지능"));
        dataVals.add(new PieEntry(Float.parseFloat(music), "음악지능"));
        dataVals.add(new PieEntry(Float.parseFloat(physical), "신체운동지능"));
        dataVals.add(new PieEntry(Float.parseFloat(nature), "자연친화지능"));
        return  dataVals;
    }
}