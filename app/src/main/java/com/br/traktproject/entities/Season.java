package com.br.traktproject.entities;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Ezequiel Messore on 23/09/2016.
 * ezequielmessore.developer@gmail.com
 */

public class Season implements Parcelable {

    @SerializedName("number")
    private Integer mNumber;
    @SerializedName("rating")
    private Double mRating;
    @SerializedName("votes")
    private Integer mVotes;
    @SerializedName("episode_count")
    private Integer mEpisodeCount;
    @SerializedName("aired_episodes")
    private Integer mAiredEpisodes;
    @SerializedName("overview")
    private String mOverview;
    @SerializedName("first_aired")
    private Date mFirstAired;
    @SerializedName("episodes")
    private List<Episode> mEpisodeList;
    @SerializedName("images")
    private Image mImage;

    public Integer getNumber() {
        return mNumber;
    }

    public void setNumber(Integer number) {
        mNumber = number;
    }

    public Double getRating() {
        return mRating;
    }

    public void setRating(Double rating) {
        mRating = rating;
    }

    public Integer getVotes() {
        return mVotes;
    }

    public void setVotes(Integer votes) {
        mVotes = votes;
    }

    public Integer getEpisodeCount() {
        return mEpisodeCount;
    }

    public void setEpisodeCount(Integer episodeCount) {
        mEpisodeCount = episodeCount;
    }

    public Integer getAiredEpisodes() {
        return mAiredEpisodes;
    }

    public void setAiredEpisodes(Integer airedEpisodes) {
        mAiredEpisodes = airedEpisodes;
    }

    public String getOverview() {
        return mOverview;
    }

    public void setOverview(String overview) {
        mOverview = overview;
    }

    public List<Episode> getEpisodeList() {
        return mEpisodeList;
    }

    public void setEpisodeList(List<Episode> episodeList) {
        mEpisodeList = episodeList;
    }

    public Image getImage() {
        return mImage;
    }

    public void setImage(Image image) {
        mImage = image;
    }

    public Date getFirstAired() {
        return mFirstAired;
    }

    public void setFirstAired(Date firstAired) {
        mFirstAired = firstAired;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.mNumber);
        dest.writeValue(this.mRating);
        dest.writeValue(this.mVotes);
        dest.writeValue(this.mEpisodeCount);
        dest.writeValue(this.mAiredEpisodes);
        dest.writeString(this.mOverview);
        dest.writeLong(this.mFirstAired != null ? this.mFirstAired.getTime() : -1);
        dest.writeTypedList(this.mEpisodeList);
        dest.writeParcelable(this.mImage, flags);
    }

    public Season() {
    }

    protected Season(Parcel in) {
        this.mNumber = (Integer) in.readValue(Integer.class.getClassLoader());
        this.mRating = (Double) in.readValue(Double.class.getClassLoader());
        this.mVotes = (Integer) in.readValue(Integer.class.getClassLoader());
        this.mEpisodeCount = (Integer) in.readValue(Integer.class.getClassLoader());
        this.mAiredEpisodes = (Integer) in.readValue(Integer.class.getClassLoader());
        this.mOverview = in.readString();
        long tmpMFirstAired = in.readLong();
        this.mFirstAired = tmpMFirstAired == -1 ? null : new Date(tmpMFirstAired);
        this.mEpisodeList = in.createTypedArrayList(Episode.CREATOR);
        this.mImage = in.readParcelable(Image.class.getClassLoader());
    }

    public static final Creator<Season> CREATOR = new Creator<Season>() {
        @Override
        public Season createFromParcel(Parcel source) {
            return new Season(source);
        }

        @Override
        public Season[] newArray(int size) {
            return new Season[size];
        }
    };
}
