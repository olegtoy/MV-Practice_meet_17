package com.practice.olegtojgildin.mvpractice_meet_17.presenter;

import com.practice.olegtojgildin.mvpractice_meet_17.view.DetailView;
import com.practice.olegtojgildin.mvpractice_meet_17.model.ImageModel;

/**
 * Created by olegtojgildin on 23/02/2019.
 */

public class ImagePresenter implements Presenter {
    public DetailView detailView;

    public void attachView(DetailView view){
        detailView=view;
    }
    public ImagePresenter(DetailView detailView){
        attachView(detailView);
    }
    public void setImage(ImageModel imageModel){
        detailView.showImageData(imageModel);
    }
}
