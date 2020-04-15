package com.example.ukidapp.ui.Logout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.ukidapp.R;
import com.example.ukidapp.ui.StudyScience.StudyScienceViewModel;
import com.example.ukidapp.ui.home.HomeViewModel;
import com.example.ukidapp.R;

public class LogoutFrament extends Fragment {

    private StudyScienceViewModel studyScienceViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        studyScienceViewModel =
                ViewModelProviders.of(this).get(StudyScienceViewModel.class);
        View root = inflater.inflate(R.layout.fragment_study_science, container, false);
        final TextView textView = root.findViewById(R.id.text_study_science);
        studyScienceViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
