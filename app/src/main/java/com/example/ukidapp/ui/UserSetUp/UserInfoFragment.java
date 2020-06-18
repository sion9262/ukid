package com.example.ukidapp.ui.UserSetUp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ukidapp.R;

import org.json.JSONException;
import org.json.JSONObject;

public class UserInfoFragment extends Fragment {
    View view;
    EditText name;
    EditText age;
    String test;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_setup_userinfo, container, false);

        TextView textView = (TextView)view.findViewById(R.id.test);
        //textView.animate().translationY(400).setDuration(1000);

        name = (EditText)view.findViewById(R.id.name);
        age = (EditText)view.findViewById(R.id.age);




        return view;
    }

    public boolean checkData(){
        String checkname = name.getText().toString();
        String checkage = age.getText().toString();

        checkname = checkname.trim();
        checkage = checkage.trim();
        if (checkname.getBytes().length > 0 && checkage.getBytes().length > 0){
            return true;
        }
        return false;
    }

    public JSONObject getData(){

        JSONObject data = new JSONObject();


        try {
            data.put("name", name.getText().toString());
            data.put("age", Integer.parseInt(age.getText().toString()));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return data;
    }
}
