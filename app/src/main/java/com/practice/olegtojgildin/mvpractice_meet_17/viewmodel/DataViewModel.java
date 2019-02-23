
package com.practice.olegtojgildin.mvpractice_meet_17.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.AsyncTask;
import android.util.Log;


import com.practice.olegtojgildin.mvpractice_meet_17.BR;
import com.practice.olegtojgildin.mvpractice_meet_17.Callback;
import com.practice.olegtojgildin.mvpractice_meet_17.adapter.DataAdapter;
import com.practice.olegtojgildin.mvpractice_meet_17.data.ApiMapper;
import com.practice.olegtojgildin.mvpractice_meet_17.data.RetrofitHelper;
import com.practice.olegtojgildin.mvpractice_meet_17.model.ImageModel;
import com.practice.olegtojgildin.mvpractice_meet_17.model.Hit;
import com.practice.olegtojgildin.mvpractice_meet_17.model.ImageMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class DataViewModel extends BaseObservable {
    private static String TAG="DataViewModel";
    private DataAdapter adapter;
    private List<ImageModel> data;

    public DataViewModel(DataAdapter.OnImageListener listener) {
        data = new ArrayList<>();
        adapter = new DataAdapter(listener);
    }

    @Bindable
    public List<ImageModel> getData() {
        return this.data;
    }

    @Bindable
    public DataAdapter getAdapter() {
        return this.adapter;
    }

    public void setData() {
            new AsyncTaskForecast(new Callback<List<ImageModel>>() {
                @Override
                public void callback(List<ImageModel> value) {
                    data.addAll(value);
                    notifyPropertyChanged(BR.data);
                }
            }).execute();

    }

    public class AsyncTaskForecast extends AsyncTask<Void, Void, List<Hit>> {
        private final Callback<List<ImageModel>> mCallback;

        public AsyncTaskForecast(Callback<List<ImageModel>> callback) {
            mCallback = callback;
        }

        @Override
        protected List<Hit> doInBackground(Void... voids) {
            ApiMapper mApiMapper = new ApiMapper(new RetrofitHelper());
            return mApiMapper.getImagesSync();
        }

        @Override
        protected void onPostExecute(List<Hit> images) {
            final List<ImageModel> mImages = ImageMapper.maptoImages(images);
            mCallback.callback(mImages);

        }
    }
}
