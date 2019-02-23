package com.practice.olegtojgildin.mvpractice_meet_17;

import android.app.Application;
import android.databinding.DataBindingUtil;

import com.practice.olegtojgildin.mvpractice_meet_17.databinding.AppDataBindingComponent;


public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DataBindingUtil.setDefaultComponent(new AppDataBindingComponent());
    }
}
