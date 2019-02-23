package com.practice.olegtojgildin.mvpractice_meet_17.view;

import com.practice.olegtojgildin.mvpractice_meet_17.model.ImageModel;

/**
 * Created by olegtojgildin on 23/02/2019.
 */

public interface DetailView {
    void refreshData();
    void showProgress();
    void hideProgress();
    void showImageData(ImageModel imageModel);
}
