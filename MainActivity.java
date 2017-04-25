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
        final resort crystal =  new resort("Crystal", 26, 18, "Snowing", 30);

        alpButton = (Button) findViewById(R.id.alp_button);
        crystalButton = (Button) findViewById(R.id.crystal_button);

        setButton(alpButton, alpental, mainText);
        setButton(crystalButton, crystal, text2);
    }

    //Adds the text of the snow data to the specified TextView by taking a String[] and a TextView as paramteres
    public void printSnowData(String[] snowData, TextView textView) {
        textView.setText("");
        for(String i : snowData) {
            textView.append(i + " ");
        }
        textView.append("\n");
    }

    public void setButton(Button button, final resort res, final TextView textView) {
        button.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View v) {
                printSnowData(res.getDataArray(), textView);
            }
        });
    }
}
