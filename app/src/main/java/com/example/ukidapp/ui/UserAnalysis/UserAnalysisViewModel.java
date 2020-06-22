package com.example.ukidapp.ui.UserAnalysis;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UserAnalysisViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public UserAnalysisViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("다중지능 분석하기");
    }

    public LiveData<String> getText() {
        return mText;
    }
}