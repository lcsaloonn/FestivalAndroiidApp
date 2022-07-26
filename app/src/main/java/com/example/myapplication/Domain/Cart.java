package com.example.myapplication.Domain;

import android.os.Parcel;
import android.os.Parcelable;

public class Cart implements Parcelable {
    private String pic, title, numberOrder, priceForOne, totalPrice;

    public Cart(String pic, String title, String numberOrder, String priceForOne, String totalPrice) {
        this.pic = pic;
        this.title = title;
        this.numberOrder = numberOrder;
        this.priceForOne = priceForOne;
        this.totalPrice = totalPrice;
    }

    protected Cart(Parcel in) {
        pic = in.readString();
        title = in.readString();
        numberOrder = in.readString();
        priceForOne = in.readString();
        totalPrice = in.readString();
    }

    public static final Parcelable.Creator<Cart> CREATOR = new Parcelable.Creator<Cart>() {
        @Override
        public Cart createFromParcel(Parcel in) {
            return new Cart(in);
        }

        @Override
        public Cart[] newArray(int size) {
            return new Cart[size];
        }
    };

    public String getPic() {
        return pic;
    }
    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getNumberOrder() {
        return numberOrder;
    }
    public void setNumberOrder(String numberOrder) {
        this.numberOrder = numberOrder;
    }

    public String getPriceForOne() {
        return priceForOne;
    }
    public void setPriceForOne(String priceForOne) {
        this.priceForOne = priceForOne;
    }

    public String getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(pic);
        dest.writeString(title);
        dest.writeString(numberOrder);
        dest.writeString(priceForOne);
        dest.writeString(totalPrice);
    }
}
