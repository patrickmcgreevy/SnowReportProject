package com.example.ros_pjmcgreevy.snowreport;

/**
 * Created by ros_pjmcgreevy on 4/21/2017.
 */

public class resort {
    private String resName;
    private int lowTemp;
    private int highTemp;
    private String weather;
    private int snowDepth;

    public resort(String resName, int lowTemp, int highTemp, String weather, int snowDepth) {
        this.resName = resName;
        this.lowTemp = lowTemp;
        this.highTemp =  highTemp;
        this.weather = weather;
        this.snowDepth = snowDepth;
    }

    public String getResName() {
        return resName;
    }

    public int getLowTemp() {
        return lowTemp;
    }

    public int getHighTemp() {
        return highTemp;
    }

    public String getWeather() {
        return weather;
    }

    public int getSnowDepth() {
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
                resName, "Low: " + lowTemp, "High: " + highTemp, weather, "Base: " + snowDepth
        };
        return data;
    }
}
