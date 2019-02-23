package com.practice.olegtojgildin.mvpractice_meet_17.data;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by olegtojgildin on 09/02/2019.
 */

public interface PixabayApiService {
        @GET("api/")
        Call<ResponsePixabay> getImages(@Query("key") String key,
                                        @Query("q") String q,
                                        @Query("lang") String lang,
                                        @Query("image_type") String image_type,
                                        @Query("per_page") int per_page);


}
