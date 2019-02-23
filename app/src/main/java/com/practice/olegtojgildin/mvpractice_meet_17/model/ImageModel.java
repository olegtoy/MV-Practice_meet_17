
package com.practice.olegtojgildin.mvpractice_meet_17.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;

public class ImageModel implements Parcelable{
    private String title;

    protected ImageModel(Parcel in) {
        title = in.readString();
        urlImage = in.readString();
    }

    public static final Creator<ImageModel> CREATOR = new Creator<ImageModel>() {
        @Override
        public ImageModel createFromParcel(Parcel in) {
            return new ImageModel(in);
        }

        @Override
        public ImageModel[] newArray(int size) {
            return new ImageModel[size];
        }
    };

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    private String urlImage;

    public ImageModel() {
    }

    @Nullable
    public String getTitle() {
        return title;
    }

    public void setTitle(@Nullable String title) {
        this.title = title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeString(urlImage);
    }
}
