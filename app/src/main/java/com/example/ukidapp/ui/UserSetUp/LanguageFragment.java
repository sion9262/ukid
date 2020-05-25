package com.example.ukidapp.ui.UserSetUp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;


import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ukidapp.R;

import java.util.ArrayList;

public class LanguageFragment extends Fragment {
    View view;

    RadioGroup R1;
    RadioGroup R2;
    RadioGroup R3;
    RadioButton radioButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_setup_language, container, false);
        R1 = (RadioGroup)view.findViewById(R.id.Language1);
        R2 = (RadioGroup)view.findViewById(R.id.Language2);
        R3 = (RadioGroup)view.findViewById(R.id.Language3);
        return view;
    }

    //라디오 버튼이 체크되어있는지 확인 -> 추후 동적으로 바꿔야함.
    public boolean checkData(){

        // 체크가 안될 시 -1 반환
        int r1 = R1.getCheckedRadioButtonId();
        int r2 = R2.getCheckedRadioButtonId();
        int r3 = R3.getCheckedRadioButtonId();

        if (r1 != -1 && r2 != -1 && r3 != -1) {
            return true;
        }
        return false;
    }
    public int getData(){

        int score = 0;

        ArrayList<Integer> IDs= new ArrayList<Integer>();

        IDs.add(R1.getCheckedRadioButtonId());
        IDs.add(R2.getCheckedRadioButtonId());
        IDs.add(R3.getCheckedRadioButtonId());

        for(int i=0; i<IDs.size(); i++){
            radioButton = (RadioButton)view.findViewById(IDs.get(i));
            score += Integer.parseInt(radioButton.getText().toString());
        }

        return score;
    }
}

