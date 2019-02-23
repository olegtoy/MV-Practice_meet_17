package com.practice.olegtojgildin.mvpractice_meet_17.data;

import com.google.gson.annotations.SerializedName;
import com.practice.olegtojgildin.mvpractice_meet_17.model.Hit;

import java.util.List;

/**
 * Created by olegtojgildin on 09/02/2019.
 */

public class ResponsePixabay {
    @SerializedName("hits")
    private List<Hit> imageHits;

    @SerializedName("total")
    private int total;

    @SerializedName("totalHits")
    private int totalHits;

    public List<Hit> getImageHits(){
        return imageHits;
    }

    public int getTotal(){
        return total;
    }

    public int getTotalHits(){
        return totalHits;
    }
}
