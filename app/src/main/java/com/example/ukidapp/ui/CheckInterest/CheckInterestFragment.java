package com.example.ukidapp.ui.CheckInterest;

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
import com.example.ukidapp.ui.home.HomeViewModel;

public class CheckInterestFragment extends Fragment {
    private CheckInterestViewModel checkInterestViewModelModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        checkInterestViewModelModel =
                ViewModelProviders.of(this).get(CheckInterestViewModel.class);
        View root = inflater.inflate(R.layout.fragment_check_interest, container, false);
        final TextView textView = root.findViewById(R.id.text_check_interest);
        checkInterestViewModelModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
