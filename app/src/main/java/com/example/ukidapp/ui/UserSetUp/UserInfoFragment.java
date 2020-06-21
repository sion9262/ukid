package com.example.ukidapp.ui.UserSetUp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ukidapp.R;
import com.example.ukidapp.SetUserInfoActivity;

import org.json.JSONException;
import org.json.JSONObject;

public class UserInfoFragment extends Fragment {

    RadioGroup rg;
    RadioButton m;
    RadioButton f;
    ImageView img;
    ImageView a;

    View view;
    EditText name;
    EditText age;
    String test;
    Button Firstnext;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_setup_userinfo, container, false);
        TextView textView = (TextView)view.findViewById(R.id.test);
        rg = (RadioGroup)view.findViewById(R.id.setupSecondR1);
        m = (RadioButton) view.findViewById(R.id.female);
        f = (RadioButton) view.findViewById(R.id.male);
        img = (ImageView)view.findViewById(R.id.profile_image);

        name = (EditText)view.findViewById(R.id.name);
        age = (EditText)view.findViewById(R.id.age);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rd = (RadioButton)view.findViewById(rg.getCheckedRadioButtonId());
                String gender = rd.getText().toString();
                if(checkedId == R.id.male){
                    img.setImageResource(R.drawable.boy_profile2);
                }else if(checkedId == R.id.female) {
                    img.setImageResource(R.drawable.girl_profile);
                }
            }
        });

        Firstnext = (Button)view.findViewById(R.id.FirstnextButton);
        Firstnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((SetUserInfoActivity)getActivity()).setFrag(2);
            }
        });

        return view;
    }

    public boolean checkData(){
        String checkname = name.getText().toString();
        String checkage = age.getText().toString();
        int r1 = rg.getCheckedRadioButtonId();

        checkname = checkname.trim();
        checkage = checkage.trim();
        if (checkname.getBytes().length > 0 && checkage.getBytes().length > 0 && r1 != -1){
            try{
                Double.parseDouble(checkage);
                return true;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public JSONObject getData(){

        JSONObject data = new JSONObject();
        RadioButton rd = (RadioButton)view.findViewById(rg.getCheckedRadioButtonId());


        try {
            data.put("name", name.getText().toString());
            data.put("age", Integer.parseInt(age.getText().toString()));
            data.put("gender", rd.getText().toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return data;
    }

}
