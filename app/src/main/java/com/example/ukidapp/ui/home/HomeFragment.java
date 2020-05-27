package com.example.ukidapp.ui.home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.ukidapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private FloatingActionButton fab, fab2, fab3, fab4, fab5, fab6, fab7, fab8;
    private Animation fab_open, fab_close;
    private Context mContext;
    private boolean isFabOpen = false;
    View root;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.fragment_home, container, false);
        init();

        return root;
    }

    private void init(){
        mContext = getActivity();
        fab_open = AnimationUtils.loadAnimation(mContext, R.anim.fab_open);
        fab_close = AnimationUtils.loadAnimation(mContext, R.anim.fab_close);

        fab = (FloatingActionButton)root.findViewById(R.id.fab);
        fab2 = (FloatingActionButton)root.findViewById(R.id.fab2);
        fab3 = (FloatingActionButton)root.findViewById(R.id.fab3);
        fab4 = (FloatingActionButton)root.findViewById(R.id.fab4);
        fab5 = (FloatingActionButton)root.findViewById(R.id.fab5);
        fab6 = (FloatingActionButton)root.findViewById(R.id.fab6);
        fab7 = (FloatingActionButton)root.findViewById(R.id.fab7);
        fab8 = (FloatingActionButton)root.findViewById(R.id.fab8);

        fab.setOnClickListener(this);
        fab2.setOnClickListener(this);
        fab3.setOnClickListener(this);
        fab4.setOnClickListener(this);
        fab5.setOnClickListener(this);
        fab6.setOnClickListener(this);
        fab7.setOnClickListener(this);
        fab8.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab:
                toggleFab();
                break;
        }
    }

    private void toggleFab() {
        if (isFabOpen) {

            fab2.startAnimation(fab_close);
            fab3.startAnimation(fab_close);
            fab4.startAnimation(fab_close);
            fab5.startAnimation(fab_close);
            fab6.startAnimation(fab_close);
            fab7.startAnimation(fab_close);
            fab8.startAnimation(fab_close);

            fab2.setClickable(false);
            fab3.setClickable(false);
            fab4.setClickable(false);
            fab5.setClickable(false);
            fab6.setClickable(false);
            fab7.setClickable(false);
            fab8.setClickable(false);
            isFabOpen = false;

        } else {


            fab2.startAnimation(fab_open);
            fab3.startAnimation(fab_open);
            fab4.startAnimation(fab_open);
            fab5.startAnimation(fab_open);
            fab6.startAnimation(fab_open);
            fab7.startAnimation(fab_open);
            fab8.startAnimation(fab_open);

            fab2.setClickable(true);
            fab3.setClickable(true);
            fab4.setClickable(true);
            fab5.setClickable(true);
            fab6.setClickable(true);
            fab7.setClickable(true);
            fab8.setClickable(true);

            isFabOpen = true;

        }

    }
}
