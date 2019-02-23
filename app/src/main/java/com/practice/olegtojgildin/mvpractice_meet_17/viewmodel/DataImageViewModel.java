
package com.practice.olegtojgildin.mvpractice_meet_17.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.TextUtils;

import com.practice.olegtojgildin.mvpractice_meet_17.model.ImageModel;

public class DataImageViewModel extends BaseObservable {
    private ImageModel dataModel;

    public DataImageViewModel(ImageModel dataModel) {
        this.dataModel = dataModel;
    }

    @Bindable
    public String getTitle() {
        return  dataModel.getTitle();
    }
}
