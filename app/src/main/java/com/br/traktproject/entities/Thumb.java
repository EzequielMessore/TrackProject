package com.br.traktproject.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Ezequiel Messore on 23/09/2016.
 * ezequielmessore.developer@gmail.com
 */
public class Thumb implements Parcelable {

    @SerializedName("full")
    private String mFull;
    @SerializedName("medium")
    private String mMedium;

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mFull);
        dest.writeString(this.mMedium);
    }

    public Thumb() {
    }

    protected Thumb(Parcel in) {
        this.mFull = in.readString();
        this.mMedium = in.readString();
    }

    public static final Parcelable.Creator<Thumb> CREATOR = new Parcelable.Creator<Thumb>() {
        @Override
        public Thumb createFromParcel(Parcel source) {
            return new Thumb(source);
        }

        @Override
        public Thumb[] newArray(int size) {
            return new Thumb[size];
        }
    };
}
