package com.example.ukidapp.ui.StudyMath;

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

public class StudyMathFragment extends Fragment {

    private StudyMathViewModel studyMathViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        studyMathViewModel =
                ViewModelProviders.of(this).get(StudyMathViewModel.class);
        View root = inflater.inflate(R.layout.fragment_study_math, container, false);
        final TextView textView = root.findViewById(R.id.text_study_math);
        studyMathViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
