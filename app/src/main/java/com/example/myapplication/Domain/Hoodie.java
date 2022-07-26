package com.example.myapplication.Domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

public class Hoodie implements Parcelable {
    private String hoodieType, description, hoodiePic;
    private double fee;

    public Hoodie(String hoodieType, String description, double fee, String hoodiePic) {
        this.hoodieType = hoodieType;
        this.fee = fee;
        this.description = description;
        this.hoodiePic = hoodiePic;
    }

    protected Hoodie(Parcel in) {
        hoodieType = in.readString();
        description = in.readString();
        fee = in.readDouble();
        hoodiePic = in.readString();
    }

    public static final Parcelable.Creator<Hoodie> CREATOR = new Parcelable.Creator<Hoodie>() {
        @Override
        public Hoodie createFromParcel(Parcel in) {
            return new Hoodie(in);
        }

        @Override
        public Hoodie[] newArray(int size) {
            return new Hoodie[size];
        }
    };

    public String getHoodieType() {
        return hoodieType;
    }
    public void setHoodieType(String hoodieType) {
        this.hoodieType = Hoodie.this.hoodieType;
    }

    public double getFee() {
        return fee;
    }
    public void setFee(double fee) {
        this.fee = fee;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getHoodiePic() {
        return hoodiePic;
    }
    public void setHoodiePic(String hoodiePic) {
        this.hoodiePic = hoodiePic;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(hoodieType);
        dest.writeString(description);
        dest.writeDouble(fee);
        dest.writeString(hoodiePic);
    }
}
