package com.example.ros_pjmcgreevy.snowreport;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class newResort extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_resort);

        Button back = (Button) findViewById(R.id.toOpen);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                launchActivity();
            }
        });

        Button addRes = (Button) findViewById(R.id.newRes);
        addRes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView test = (TextView) findViewById(R.id.testView);

                test.append("I work");
            }
        });

        resort testRes = new resort("tesResort", "0", "32", "Sunny bb", "1000");
    }

    public void launchActivity() {
        Intent intent = new Intent(this, openActivity.class);
        startActivity(intent);
    }
}
