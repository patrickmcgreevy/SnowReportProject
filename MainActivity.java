package com.example.ros_pjmcgreevy.snowreport;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mainText;
    private Button alpButton;
    private TextView text2;
    private Button crystalButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainText = (TextView) findViewById(R.id.snow_text_view);
        text2 = (TextView) findViewById(R.id.text2);
        final resort alpental = new resort("Alpental", 33, 26, "Cloudy", 20);
        alpButton = (Button) findViewById(R.id.alp_button);

        //sets the button's onclick function. Runs the printSnowData() method
        alpButton.setOnClickListener(new View.OnClickListener() {
           public void onClick(View v) {
               printSnowData(alpental.getDataArray());
           }
        });
        //uncomment to work on making the setButton method work. Uncommenting breaks code.
        //setButton(crystalButton, alpental);
    }

    //Adds the text of the snow data to the TextView by taking the resort.getDataArray() method as a parameter
    public void printSnowData(String[] snowData) {
        for(String i : snowData) {
            mainText.append(i + "\n");
        }
    }

    public void setButton(Button button, final resort resort) {
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                printSnowData(resort.getDataArray());
            }
        });
    }
}
