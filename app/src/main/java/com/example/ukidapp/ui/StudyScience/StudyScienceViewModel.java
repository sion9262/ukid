package com.example.ukidapp.ui.StudyScience;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class StudyScienceViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public StudyScienceViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("과학 탐구하기");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
