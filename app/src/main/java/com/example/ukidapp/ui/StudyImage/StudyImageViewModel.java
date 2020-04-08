package com.example.ukidapp.ui.StudyImage;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class StudyImageViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public StudyImageViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("이미지 학습하기");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
