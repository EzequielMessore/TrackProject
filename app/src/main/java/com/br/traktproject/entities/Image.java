package com.br.traktproject.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ezequiel Messore on 23/09/2016.
 * ezequielmessore.developer@gmail.com
 */

public class Image implements Parcelable {

    @SerializedName("poster")
    Poster mPoster;
    @SerializedName("thumb")
    Thumb mThumb;

    public Poster getPoster() {
        return mPoster;
    }

    public void setPoster(Poster poster) {
        mPoster = poster;
    }

    public Thumb getThumb() {
        return mThumb;
    }

    public void setThumb(Thumb thumb) {
        mThumb = thumb;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.mPoster, flags);
        dest.writeParcelable(this.mThumb, flags);
    }

    public Image() {
    }

    protected Image(Parcel in) {
        this.mPoster = in.readParcelable(Poster.class.getClassLoader());
        this.mThumb = in.readParcelable(Thumb.class.getClassLoader());
    }

    public static final Creator<Image> CREATOR = new Creator<Image>() {
        @Override
        public Image createFromParcel(Parcel source) {
            return new Image(source);
        }

        @Override
        public Image[] newArray(int size) {
            return new Image[size];
        }
    };
}
