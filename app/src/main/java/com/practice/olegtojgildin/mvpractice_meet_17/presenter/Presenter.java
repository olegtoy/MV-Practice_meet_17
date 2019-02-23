package com.practice.olegtojgildin.mvpractice_meet_17.presenter;

import com.practice.olegtojgildin.mvpractice_meet_17.view.DetailView;
import com.practice.olegtojgildin.mvpractice_meet_17.model.ImageModel;

/**
 * Created by olegtojgildin on 23/02/2019.
 */

public interface Presenter {
    void attachView(DetailView view);

    void setImage(ImageModel imageModel);

}
