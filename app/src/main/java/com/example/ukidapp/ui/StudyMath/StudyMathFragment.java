package com.example.ukidapp.ui.StudyMath;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.ukidapp.MainActivity;
import com.example.ukidapp.MyPageActivity;
import com.example.ukidapp.R;

import java.lang.reflect.Array;
import java.util.Random;

public class StudyMathFragment extends Fragment{

    TextView num1, num2;
    EditText result1, result2;
    Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button0, report;
    View root;
    SharedPreferences prefs;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.calculator_play, container, false);

        init();
        randnum_generate();

        return root;
    }


    private void randnum_generate() {
        Random random = new Random();
        num1 = root.findViewById(R.id.num1);
        num2 = root.findViewById(R.id.num2);
        result1 = root.findViewById(R.id.result1);
        result2 = root.findViewById(R.id.result2);

        int number1 = random.nextInt(9)+1;
        int number2 = random.nextInt(9)+1;

        int arr[] = new int[2];

        if(number1 + number2 >= 10){
            arr[0] = (number1 + number2) / 10;
            arr[1] = (number1 + number2) - arr[0]*10;
        }else{
            arr[0] = 0;
            arr[1] = number1 + number2;
        }

        num1.setText(String.valueOf(number1));
        num2.setText(String.valueOf(number2));
        //result1.setText(String.valueOf(arr[0]));
        //result2.setText(String.valueOf(arr[1]));


    }


    private void init() {
        button0 = root.findViewById(R.id.button0);
        button1 = root.findViewById(R.id.button1);
        button2 = root.findViewById(R.id.button2);
        button3 = root.findViewById(R.id.button3);
        button4 = root.findViewById(R.id.button4);
        button5 = root.findViewById(R.id.button5);
        button6 = root.findViewById(R.id.button6);
        button7 = root.findViewById(R.id.button7);
        button8 = root.findViewById(R.id.button8);
        button9 = root.findViewById(R.id.button9);

    }


}
