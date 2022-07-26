package com.example.myapplication.Domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.load.engine.Resource;

public class Artist implements Parcelable {
    private String name, url;

    public Artist(String name, String url) {
        this.name = name;
        this.url = url;
    }

    protected Artist(Parcel in) {
        name = in.readString();
        url = in.readString();
    }

    public static final Creator<Artist> CREATOR = new Creator<Artist>() {
        @Override
        public Artist createFromParcel(Parcel in) {
            return new Artist(in);
        }

        @Override
        public Artist[] newArray(int size) {
            return new Artist[size];
        }
    };

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(url);
    }
}
