package com.example.ukidapp.ui.StudyObject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class StudyObjectModel extends ViewModel {

    private MutableLiveData<String> mText;

    public StudyObjectModel() {
        mText = new MutableLiveData<>();
        mText.setValue("물체 학습하기");
    }

    public LiveData<String> getText() {
        return mText;
    }
}