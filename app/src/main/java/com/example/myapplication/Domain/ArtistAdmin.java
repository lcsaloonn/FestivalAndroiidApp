package com.example.myapplication.Domain;

import android.os.Parcel;
import android.os.Parcelable;

public class ArtistAdmin implements Parcelable {
    private String name;

    public ArtistAdmin(String name) {
        this.name = name;
    }

    protected ArtistAdmin(Parcel in) {
        name = in.readString();
    }

    public static final Creator<ArtistAdmin> CREATOR = new Creator<ArtistAdmin>() {
        @Override
        public ArtistAdmin createFromParcel(Parcel in) {
            return new ArtistAdmin(in);
        }

        @Override
        public ArtistAdmin[] newArray(int size) {
            return new ArtistAdmin[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
    }
}
