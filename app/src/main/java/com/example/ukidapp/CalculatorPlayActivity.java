package com.example.ukidapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class CalculatorPlayActivity extends AppCompatActivity {

    TextView result;
    EditText num1, num2;
    Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button0, report;
    View root;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.calculator_play, container, false);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        result = findViewById(R.id.result1);

        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        report = findViewById(R.id.report);

        result.setText("왜안돼이시발");

        int rand1 = new Random().nextInt(8)*2;
        int rand2 = new Random().nextInt(8)*2;
        num1.setText(String.valueOf(rand1));
        num2.setText(String.valueOf(rand2));


        return root;

    }

}