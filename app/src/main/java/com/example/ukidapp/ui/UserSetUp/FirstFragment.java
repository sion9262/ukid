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

public class FirstFragment extends Fragment {
    View view;
    EditText name;
    EditText age;
    String test;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_setup_first, container, false);

        TextView textView = (TextView)view.findViewById(R.id.test);
        //textView.animate().translationY(400).setDuration(1000);

        name = (EditText)view.findViewById(R.id.name);
        age = (EditText)view.findViewById(R.id.age);


        Fragment seconde = new SecondFragment();
        Bundle bundle = new Bundle();
        bundle.putString("name", name.getText().toString());
        bundle.putString("age", age.getText().toString());
        seconde.setArguments(bundle);

        return view;
    }

    public String getName(){
        return name.getText().toString();
    }
}
