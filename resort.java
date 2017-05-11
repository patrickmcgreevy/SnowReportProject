package com.example.ros_pjmcgreevy.snowreport;

/**
 * Created by ros_pjmcgreevy on 4/21/2017.
 */

public class resort {
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
    //returns the data of the resort as a string broken by new lines after each pice of data
    public String getData() {
        String data = lowTemp + "\n" + highTemp + "\n" + weather + "\n" + snowDepth;
        return data;
    }
    //returns the data of the resort as a String array
    public String[] getDataArray() {
        String[] data = {
                resName, " Low: " + lowTemp, " High: " + highTemp, weather, " Base: " + snowDepth
        };
        return data;
    }

    public boolean checkText() {
        return textOn;
    }

    public void toggle() {
        textOn ^= true;
    }
}
