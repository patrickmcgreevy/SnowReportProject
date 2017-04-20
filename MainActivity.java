package com.example.ros_pjmcgreevy.snowreport;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mainText;
    private Button alpButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainText = (TextView) findViewById(R.id.snow_text_view);

        String[] alpentalWeather = {
                "Alpental", "Low: 22", "High: 26", "Base: 100"
        };

        alpButton = (Button) findViewById(R.id.alp_button);
        alpButton.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v) {
               printSnowData(alpentalWeather);
               mainText.append("I work");
           }
        });

        printSnowData(alpentalWeather);
    }

    //Adds the text of the snow data to the TextView
    public void printSnowData(String[] snowData) {
        for(String i : snowData) {
            mainText.append(i + "  ");
        }
    }


}
