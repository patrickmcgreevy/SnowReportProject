package com.example.ros_pjmcgreevy.snowreport;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView alpentalSnowData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alpentalSnowData = (TextView) findViewById(R.id.snow_text_view);
        alpentalSnowData.setText("");
        String[] alpentalWeather = {
            "Alpental", "Low: 22", "High: 26", "Base: 100"
        };

        printSnowData(alpentalWeather);
    }

    public void printSnowData(String[] snowData) {
        for(String i : snowData) {
            alpentalSnowData.append(i + "\n");
        }
    }
}
