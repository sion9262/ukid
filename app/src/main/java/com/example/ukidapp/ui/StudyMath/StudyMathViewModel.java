package com.example.ukidapp.ui.StudyMath;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class StudyMathViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public StudyMathViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("수리 학습하기");
    }

    public LiveData<String> getText() {
        return mText;
    }
}