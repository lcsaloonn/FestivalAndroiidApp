package com.example.myapplication.Domain;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Ticket implements Parcelable{
    private String ticketType, date, ticketPic;
    private double fee;

    public Ticket(String ticketType, String date, double fee, String ticketPic) {
        this.ticketType = ticketType;
        this.fee = fee;
        this.date = date;
        this.ticketPic = ticketPic;
    }

    protected Ticket(Parcel in) {
        ticketType = in.readString();
        date = in.readString();
        fee = in.readDouble();
        ticketPic = in.readString();
    }

    public static final Parcelable.Creator<Ticket> CREATOR = new Parcelable.Creator<Ticket>() {
        @Override
        public Ticket createFromParcel(Parcel in) {
            return new Ticket(in);
        }

        @Override
        public Ticket[] newArray(int size) {
            return new Ticket[size];
        }
    };

    public String getTicketType() {
        return ticketType;
    }
    public void setTicketType(String ticketType) {
        this.ticketType = Ticket.this.ticketType;
    }

    public double getFee() {
        return fee;
    }
    public void setFee(double fee) {
        this.fee = fee;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getTicketPic() {
        return ticketPic;
    }
    public void setTicketPic(String ticketPic) {
        this.ticketPic = ticketPic;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(ticketType);
        dest.writeString(date);
        dest.writeDouble(fee);
        dest.writeString(ticketPic);
    }
}
