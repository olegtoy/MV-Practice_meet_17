package com.practice.olegtojgildin.mvpractice_meet_17.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.practice.olegtojgildin.mvpractice_meet_17.presenter.ImagePresenter;
import com.practice.olegtojgildin.mvpractice_meet_17.presenter.Presenter;
import com.practice.olegtojgildin.mvpractice_meet_17.R;
import com.practice.olegtojgildin.mvpractice_meet_17.model.ImageModel;
import com.squareup.picasso.Picasso;

/**
 * Created by olegtojgildin on 23/02/2019.
 */

public class DetailActivity extends AppCompatActivity implements DetailView {

    Presenter mPresenter;
    ImageModel mImageModel;
    ImageView mImageView;
    TextView mUserName;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);
        mImageView = findViewById(R.id.image_view_detail);
        mUserName = findViewById(R.id.username_detail);
        mPresenter = new ImagePresenter(this);
        ImageModel image = getIntent().getParcelableExtra(ImageModel.class.getCanonicalName());
        mPresenter.setImage(image);

    }

    @Override
    public void refreshData() {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showImageData(ImageModel imageModel) {
        mImageModel = imageModel;
        mUserName.setText(imageModel.getTitle());
        Picasso.get()
                .load(imageModel.getUrlImage())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_foreground)
                .into(mImageView);

    }
    public static final Intent newIntent(Context context) {
        Intent intent = new Intent(context, DetailActivity.class);
        return intent;
    }

}
