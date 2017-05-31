package com.example.ros_pjmcgreevy.snowreport;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class openActivity extends AppCompatActivity {
    Button swapMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open);
        //Sets the button to run launchActivity() on click
        swapMain = (Button) findViewById(R.id.swap);
        swapMain.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                launchMainActivity();
            }
        });

        Button swapNewRes = (Button) findViewById(R.id.newResBut);
        swapNewRes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                launchNewResActivity();
            }
        });
    }
    //Launches the MainActivity
    private void launchMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void launchNewResActivity() {
        Intent intent = new Intent(this, newResort.class);
        startActivity(intent);
    }
}
