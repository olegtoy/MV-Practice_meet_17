package com.practice.olegtojgildin.mvpractice_meet_17.data;

import android.util.Log;
import com.practice.olegtojgildin.mvpractice_meet_17.model.Hit;
import java.io.IOException;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by olegtojgildin on 09/02/2019.
 */

public class ApiMapper {
    private RetrofitHelper helper;
    private List<Hit> mListHit;

    public ApiMapper(RetrofitHelper helper) {
        this.helper = helper;
    }

    public List<Hit> getImagesAsync() {
        helper.getService().getImages(ApiParams.KEY,ApiParams.API_QUERY,ApiParams.LANG,ApiParams.API_IMAGE_TYPE,ApiParams.API_IMAGES_PER_PAGE).enqueue(new Callback<ResponsePixabay>() {
            @Override
            public void onResponse(Call<ResponsePixabay> call, Response<ResponsePixabay> response) {
                mListHit = response.body().getImageHits();
            }

            @Override
            public void onFailure(Call<ResponsePixabay> call, Throwable t) {
                Log.d("ApiMapperFailure", t.getMessage());
            }
        });
        return mListHit;
    }

    public List<Hit> getImagesSync() {
        Response<ResponsePixabay> response = null;
        try {
            response = helper.getService().getImages(ApiParams.KEY,ApiParams.API_QUERY,ApiParams.LANG,ApiParams.API_IMAGE_TYPE,ApiParams.API_IMAGES_PER_PAGE).execute();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return response.body().getImageHits();
    }

}
