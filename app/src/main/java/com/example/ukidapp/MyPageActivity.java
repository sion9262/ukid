package com.example.ukidapp;


import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;
import java.util.BitSet;


public class MyPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        RadarChart radarChart;
        radarChart = findViewById(R.id.mapsearchdetail_radar_chart);

        RadarDataSet dataSet = new RadarDataSet(dataValue(), "DATA");
        dataSet.setColor(Color.BLUE);

        RadarData data = new RadarData();
        data.addDataSet(dataSet);
        String[] labels =  {"언어지능", "논리수학지능", "인간친화지능",
                "자기성찰지능", "공간지능", "음악지능", "신체운동지능", "자연지능"};
        XAxis xAxis = radarChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(labels));
        radarChart.setData(data);

    }
    private ArrayList<RadarEntry> dataValue(){
        ArrayList<RadarEntry> dataVals = new ArrayList<>();
        BitSet languageList = new BitSet(8);
        BitSet logicalMathematicalList= new BitSet(11);
        BitSet humanFriendlyList = new BitSet(2);
        BitSet introspectiveList = new BitSet(10);
        BitSet spaceList = new BitSet(0);
        BitSet musicList = new BitSet(15);
        BitSet physicalExerciseList = new BitSet(4);
        BitSet naturalList = new BitSet(7);

        dataVals.add(new RadarEntry(languageList.size()));
        dataVals.add(new RadarEntry(logicalMathematicalList.size()));
        dataVals.add(new RadarEntry(humanFriendlyList.size()));
        dataVals.add(new RadarEntry(introspectiveList.size()));
        dataVals.add(new RadarEntry(spaceList.size()));
        dataVals.add(new RadarEntry(musicList.size()));
        dataVals.add(new RadarEntry(physicalExerciseList.size()));
        dataVals.add(new RadarEntry(naturalList.size()));
        return  dataVals;
    }
}