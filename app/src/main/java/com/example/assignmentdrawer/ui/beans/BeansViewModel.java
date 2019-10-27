package com.example.assignmentdrawer.ui.beans;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BeansViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public BeansViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is behind the beans fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}