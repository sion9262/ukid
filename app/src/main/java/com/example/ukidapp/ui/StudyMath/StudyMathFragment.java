package com.example.ukidapp.ui.StudyMath;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.ukidapp.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.util.Random;

public class StudyMathFragment extends Fragment implements View.OnClickListener{

    private StudyMathViewModel studyScienceViewModel;
    View root;
    TextView num1, num2;
    TextView result1, result2, score;
    TextView sign;
    Context mContext;
    Button button0, button1, button2, button3, button4, button5
            , button6, button7, button8, button9;
    Button report, Mathprev;
    Random rand;

    int resultNum;
    int position;
    int answerCount;
    int tryCount;
    int failCount;
    private InterstitialAd mInterstitialAd;
    private AdView mAdview;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        studyScienceViewModel =
                ViewModelProviders.of(this).get(StudyMathViewModel.class);
        root = inflater.inflate(R.layout.calculator_play, container, false);
        init();
        SettingCalculator();
        MobileAds.initialize(getContext(), "ca-app-pub-8924705805317182/9158573756");

        mAdview = root.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdview.loadAd(adRequest);
        return root;
    }

    public void init(){
        answerCount = 0;
        tryCount = 0;
        failCount = 0;
        mContext = root.getContext();
        rand = new Random();
        position = 0;
        num1 = (TextView)root.findViewById(R.id.num1);
        num2 = (TextView)root.findViewById(R.id.num2);
        result1 = (TextView)root.findViewById(R.id.result1);
        result2 = (TextView)root.findViewById(R.id.result2);
        score = (TextView)root.findViewById(R.id.score);
        sign = (TextView)root.findViewById(R.id.sign);

        button0 = (Button)root.findViewById(R.id.button0);
        button1 = (Button)root.findViewById(R.id.button1);
        button2 = (Button)root.findViewById(R.id.button2);
        button3 = (Button)root.findViewById(R.id.button3);
        button4 = (Button)root.findViewById(R.id.button4);
        button5 = (Button)root.findViewById(R.id.button5);
        button6 = (Button)root.findViewById(R.id.button6);
        button7 = (Button)root.findViewById(R.id.button7);
        button8 = (Button)root.findViewById(R.id.button8);
        button9 = (Button)root.findViewById(R.id.button9);
        report = (Button)root.findViewById(R.id.report);
        Mathprev = (Button)root.findViewById(R.id.Mathprev);

        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        report.setOnClickListener(this);
        Mathprev.setOnClickListener(this);
    }
    public void answerReset(){
        position = 0;
        result1.setText("");
        result2.setText("");
        SettingCalculator();
    }
    // 기호 및 랜덤한 숫자 가져오기.
    public void SettingCalculator(){
        int a, b, signCheck, temp;
        tryCount++;

        signCheck = rand.nextInt(2);

        a = rand.nextInt(10);
        b = rand.nextInt(10);
        System.out.println();
        // a가 큰수로 오게.
        if (a < b){
            temp = b;
            b = a;
            a = temp;
        }
        // 랜덤으로 +, - 기호정하기
        if (signCheck == 1 ){
            sign.setText("+");
            resultNum = a+b;
        }else{
            sign.setText("-");
            resultNum = a-b;
        }
        // 10보다 결과가 작으면 0셋팅
        if (resultNum < 10) {
            position++;
            result1.setText("0");
        }
        num1.setText(String.valueOf(a));
        num2.setText(String.valueOf(b));

    }

    public void setNumView(int num){
        if (position == 0) {
            result1.setText(String.valueOf(num));
            position = 1;
        }else {
            result2.setText(String.valueOf(num));
            position = 2;
        }
    }
    public void reportNum(){
        if (position == 2) {

            int temp1 = Integer.parseInt(result1.getText().toString()) * 10;
            int temp2 = Integer.parseInt(result2.getText().toString());
            //맞췄을때
            if (resultNum == temp1+temp2){
                ShowToast("정답입니다!!!");
                answerCount++;
                score.setText("맞은 개수 : " + answerCount);
                answerReset();
            }else {
                ShowToast("틀렸습니다!!!");
                failCount--;
            }
        }else {
            ShowToast("숫자를 전부 입력해주세요!!!");
        }
    }
    public void deleteNum(){
        if (position == 1) {
            if (result1.getText().toString().equals("0")){

            }else{
                result1.setText("");
                position--;
            }

        }else if (position == 2){
            result2.setText("");
            position--;
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button0:
                setNumView(0);
                break;
            case R.id.button1:
                setNumView(1);
                break;
            case R.id.button2:
                setNumView(2);
                break;
            case R.id.button3:
                setNumView(3);
                break;
            case R.id.button4:
                setNumView(4);
                break;
            case R.id.button5:
                setNumView(5);
                break;
            case R.id.button6:
                setNumView(6);
                break;
            case R.id.button7:
                setNumView(7);
                break;
            case R.id.button8:
                setNumView(8);
                break;
            case R.id.button9:
                setNumView(9);
                break;
            case R.id.report:
                reportNum();
                break;
            case R.id.Mathprev:
                deleteNum();
                break;

        }
    }
    private void ShowToast(String s){
        Toast toast = Toast.makeText(mContext, s, Toast.LENGTH_LONG);
        toast.show();
    }


}
