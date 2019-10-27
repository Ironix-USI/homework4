package com.example.assignmentdrawer.ui.our_coffee;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OurCoffeeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public OurCoffeeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is our coffee fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}