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

        String[] alpentalWeather = {
            "Aplental", "22", "26", "100"
        };
    }

    public void printSnowData() {

    }
}
