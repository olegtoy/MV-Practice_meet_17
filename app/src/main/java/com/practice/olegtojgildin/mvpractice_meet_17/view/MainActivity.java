package com.practice.olegtojgildin.mvpractice_meet_17.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.practice.olegtojgildin.mvpractice_meet_17.R;
import com.practice.olegtojgildin.mvpractice_meet_17.adapter.DataAdapter;
import com.practice.olegtojgildin.mvpractice_meet_17.databinding.ActivityMainBinding;
import com.practice.olegtojgildin.mvpractice_meet_17.model.ImageModel;
import com.practice.olegtojgildin.mvpractice_meet_17.viewmodel.DataViewModel;

import static android.support.v7.widget.LinearLayoutManager.VERTICAL;

public class MainActivity extends AppCompatActivity implements DataAdapter.OnImageListener {
    private RecyclerView mRecyclerView;
    private GridLayoutManager mManager;
    private DataViewModel dataViewModel;
    ActivityMainBinding mActivityBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        dataViewModel = new DataViewModel(this);
        mActivityBinding.setViewModel(dataViewModel);
        initRecyclerView();

    }

    @Override
    protected void onResume() {
        super.onResume();
        dataViewModel.setData();
    }

    private void initRecyclerView() {
        mRecyclerView = findViewById(R.id.data_recycler_view);
        mManager=new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mManager);
        mRecyclerView.addItemDecoration(new DividerItemDecoration(mRecyclerView.getContext(), VERTICAL));
    }

    @Override
    public void onImageClick(int position) {
        Intent intent = DetailActivity.newIntent(this);
        intent.putExtra(ImageModel.class.getCanonicalName(), dataViewModel.getData().get(position));
        startActivity(intent);
    }
}
