package com.example.ukidapp.ui.StudyLanguage;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class StudyLanguageViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public StudyLanguageViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("물체 학습하기");
    }

    public LiveData<String> getText() {
        return mText;
    }
}