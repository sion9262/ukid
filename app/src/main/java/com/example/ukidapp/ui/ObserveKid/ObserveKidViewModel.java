package com.example.ukidapp.ui.ObserveKid;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ObserveKidViewModel extends ViewModel{
    private MutableLiveData<String> mText;

    public ObserveKidViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("아이 관찰하기");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
