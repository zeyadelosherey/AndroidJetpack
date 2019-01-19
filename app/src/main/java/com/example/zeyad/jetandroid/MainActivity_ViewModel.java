package com.example.zeyad.jetandroid;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import java.util.Random;

public class MainActivity_ViewModel extends ViewModel {
    private MutableLiveData<String>  RandomNamber ;

    public MutableLiveData<String> getRandomNamber(){

        Log.e("getnumber" , "created");
        if (RandomNamber == null){
            RandomNamber =new MutableLiveData<>();
            CreateNumber();
        }
        return RandomNamber ;
    }
    public void CreateNumber (){
        Log.e("getnumber" , "re");

        Random random = new Random();

        RandomNamber.setValue("your number is " + String.valueOf((random.nextInt(10-1) +1)));   ;

    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
