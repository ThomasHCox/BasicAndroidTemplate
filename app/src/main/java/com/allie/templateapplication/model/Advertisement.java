package com.allie.templateapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by tcox on 10/20/17.
 */

public class Advertisement implements Parcelable {
    private String mBackgroundColor;

    public Advertisement(String color){
        mBackgroundColor = color;
    }

    private void setColor(String color){
        mBackgroundColor = color;
    }

    public String getColor(){
        return mBackgroundColor;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mBackgroundColor);
    }

    protected Advertisement(Parcel in) {
        this.mBackgroundColor = in.readString();
    }

    public static final Creator<Advertisement> CREATOR = new Creator<Advertisement>() {
        @Override
        public Advertisement createFromParcel(Parcel source) {
            return new Advertisement(source);
        }

        @Override
        public Advertisement[] newArray(int size) {
            return new Advertisement[size];
        }
    };
}
