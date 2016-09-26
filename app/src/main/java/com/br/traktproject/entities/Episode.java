package com.br.traktproject.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Ezequiel Messore on 23/09/2016.
 * ezequielmessore.developer@gmail.com
 */
public class Episode implements Parcelable {

    @SerializedName("season")
    private Integer mSeason;
    @SerializedName("number")
    private Integer mNumber;
    @SerializedName("title")
    private String mTitle;

    public Integer getSeason() {
        return mSeason;
    }

    public void setSeason(Integer season) {
        mSeason = season;
    }

    public Integer getNumber() {
        return mNumber;
    }

    public void setNumber(Integer number) {
        mNumber = number;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.mSeason);
        dest.writeValue(this.mNumber);
        dest.writeString(this.mTitle);
    }

    public Episode() {
    }

    protected Episode(Parcel in) {
        this.mSeason = (Integer) in.readValue(Integer.class.getClassLoader());
        this.mNumber = (Integer) in.readValue(Integer.class.getClassLoader());
        this.mTitle = in.readString();
    }

    public static final Parcelable.Creator<Episode> CREATOR = new Parcelable.Creator<Episode>() {
        @Override
        public Episode createFromParcel(Parcel source) {
            return new Episode(source);
        }

        @Override
        public Episode[] newArray(int size) {
            return new Episode[size];
        }
    };
}
