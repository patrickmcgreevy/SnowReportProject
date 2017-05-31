package com.example.ros_pjmcgreevy.snowreport;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by ros_pjmcgreevy on 4/21/2017.
 */

public class resort implements Parcelable{
    private String resName;
    private String lowTemp;
    private String highTemp;
    private String weather;
    private String snowDepth;
    private boolean textOn = false;

    //public resort(String resName, int lowTemp, int highTemp, String weather, int snowDepth) {
    public resort(String[] resData) {
        this.resName = resData[0];
        this.lowTemp = resData[1];
        this.highTemp =  resData[2];
        this.weather = resData[3];
        this.snowDepth = resData[4];
    }

    public resort(String resName, String lowTemp, String highTemp, String weather, String snowDepth) {
        this.resName = resName;
        this.lowTemp = lowTemp;
        this.highTemp = highTemp;
        this.weather = weather;
        this.snowDepth = snowDepth;
    }

    public String getResName() {
        return resName;
    }

    public String getLowTemp() {
        return lowTemp;
    }

    public String getHighTemp() {
        return highTemp;
    }

    public String getWeather() {
        return weather;
    }

    public String getSnowDepth() {
        return snowDepth;
    }
    //returns the data of the resort as a string broken by new lines after each piece of data
    public String getData() {
        return lowTemp + "\n" + highTemp + "\n" + weather + "\n" + snowDepth;
    }
    //returns the data of the resort as a String array
    public String[] getDataArray() {
        return new String[]{
                resName, " Low: " + lowTemp, " High: " + highTemp, weather, " Base: " + snowDepth
        };
    }

    public boolean checkText() {
        return textOn;
    }
    //Switches the boolean state of textOn
    public void toggle() {
        textOn ^= true;
    }

    private int mData;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(mData);
    }

    public static final Parcelable.Creator<resort> CREATOR = new Parcelable.Creator<resort>() {
        public resort createFromParcel(Parcel in) {
            return new resort(in);
        }

        public resort[] newArray(int size) {
            return new resort[size];
        }
    };

    private resort(Parcel in) {
        mData = in.readInt();
    }
}
