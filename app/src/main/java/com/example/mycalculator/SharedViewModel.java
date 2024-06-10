package com.example.mycalculator;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SharedViewModel extends ViewModel {
    private MutableLiveData<Integer> currentImageResId = new MutableLiveData<>(R.drawable.img_1);

    public void setImageResId(int resId) {
        currentImageResId.setValue(resId);
    }

    public LiveData<Integer> getCurrentImageResId() {
        return currentImageResId;
    }
}
