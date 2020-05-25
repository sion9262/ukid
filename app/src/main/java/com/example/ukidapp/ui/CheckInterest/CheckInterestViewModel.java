package com.example.ukidapp.ui.CheckInterest;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CheckInterestViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public CheckInterestViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("관심사 확인하기");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
