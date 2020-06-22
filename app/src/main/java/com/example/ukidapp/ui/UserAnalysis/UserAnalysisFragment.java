package com.example.ukidapp.ui.UserAnalysis;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.ukidapp.R;
import com.example.ukidapp.src.UserScore;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Arrays;

import static com.github.mikephil.charting.utils.ColorTemplate.COLORFUL_COLORS;


public class UserAnalysisFragment extends Fragment {

    private UserAnalysisViewModel studyMathViewModel;
    Context mContext;
    BarChart barChart;
    TextView userScoreBoard;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        studyMathViewModel =
                ViewModelProviders.of(this).get(UserAnalysisViewModel.class);
        View root = inflater.inflate(R.layout.fragment_useranalysis, container, false);
        mContext = getActivity();
        barChart = (BarChart) root.findViewById(R.id.userTopbrainchart);
        userScoreBoard = (TextView)root.findViewById(R.id.userScoreText);
        init();
        return root;
    }

    private void init(){

        // 유저 스코어를 가져와 Top3 bar 표현
        SharedPreferences pref = mContext.getSharedPreferences("Auth", Activity.MODE_PRIVATE);
        String name = pref.getString("nickname", "");
        String language = pref.getString("language", "0");
        String math = pref.getString("math", "0");
        String relationship = pref.getString("relationship", "0");
        String personal = pref.getString("personal", "0");
        String place = pref.getString("place", "0");
        String music = pref.getString("music", "0");
        String physical = pref.getString("physical", "0");
        String nature = pref.getString("nature", "0");

        UserScore[] score = new UserScore[8];
        score[0] = new UserScore("언어지능", Integer.parseInt(language));
        score[1] = new UserScore("논리수학지능", Integer.parseInt(math));
        score[2] = new UserScore("대인간관계지능", Integer.parseInt(relationship));
        score[3] = new UserScore("자기성찰지능", Integer.parseInt(personal));
        score[4] = new UserScore("공간지능", Integer.parseInt(place));
        score[5] = new UserScore("음악지능", Integer.parseInt(music));
        score[6] = new UserScore("신체운동지능", Integer.parseInt(physical));
        score[7] = new UserScore("자연친화지능", Integer.parseInt(nature));
        Arrays.sort(score);

        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(score[7].getScore(), 0));
        entries.add(new BarEntry(score[6].getScore(), 1));
        entries.add(new BarEntry(score[5].getScore(), 2));

        ArrayList<String> labels = new ArrayList<>();
        labels.add(score[7].getCategory());
        labels.add(score[6].getCategory());
        labels.add(score[5].getCategory());

        BarDataSet dataSet = new BarDataSet(entries, "다중지능");
        dataSet.setValueTextSize(20);
        BarData data = new BarData(labels, dataSet);

        barChart.animateY(1000);


        barChart.setData(data);
        String userText = name + "어린이는 8가지 다중지능 중\n" + score[7].getCategory() + ", " +
                score[6].getCategory() + ", " + score[5].getCategory() + "\n을 가장 선호하는 것으로 나타났습니다.";
        userScoreBoard.setText(userText);
    }


}
