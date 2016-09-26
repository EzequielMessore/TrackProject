package com.br.traktproject.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ezequiel Messore on 23/09/2016.
 * ezequielmessore.developer@gmail.com
 */
public class Poster implements Parcelable {

    @SerializedName("full")
    private String mFull;
    @SerializedName("medium")
    private String mMedium;
    @SerializedName("thumb")
    private String mThumb;

    public String getFull() {
        return mFull;
    }

    public void setFull(String full) {
        mFull = full;
    }

    public String getMedium() {
        return mMedium;
    }

    public void setMedium(String medium) {
        mMedium = medium;
    }

    public String getThumb() {
        return mThumb;
    }

    public void setThumb(String thumb) {
        mThumb = thumb;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mFull);
        dest.writeString(this.mMedium);
        dest.writeString(this.mThumb);
    }

    public Poster() {
    }

    protected Poster(Parcel in) {
        this.mFull = in.readString();
        this.mMedium = in.readString();
        this.mThumb = in.readString();
    }

    public static final Parcelable.Creator<Poster> CREATOR = new Parcelable.Creator<Poster>() {
        @Override
        public Poster createFromParcel(Parcel source) {
            return new Poster(source);
        }

        @Override
        public Poster[] newArray(int size) {
            return new Poster[size];
        }
    };
}
