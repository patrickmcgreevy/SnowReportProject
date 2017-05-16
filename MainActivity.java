package com.example.ros_pjmcgreevy.snowreport;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    private TextView mainText;
    private Button alpButton;
    private TextView text2;
    private Button crystalButton;
    private Scanner resScanner;
    private File alpentalFile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button switchActivity = (Button) findViewById(R.id.swapButton);
        switchActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                launchActivity();
            }
        });

//        mainText = (TextView) findViewById(R.id.snow_text_view);
//        text2 = (TextView) findViewById(R.id.text2);
        final resort alpental = new resort("Alpental", "33", "26", "Cloudy", "20");
        final resort crystal =  new resort("Crystal", "26", "18", "Snowing", "30");
//        alpButton = (Button) findViewById(R.id.alp_button);
//        crystalButton = (Button) findViewById(R.id.crystal_button);
//        setButton(alpButton, alpental, mainText);
//        setButton(crystalButton, crystal, text2);

//        alpentalFile = new File("src\\main\\assets\\alpental.txt");
//        resScanner alpScan = new resScanner("T:\\crystal.txt");

        //final resort alpental = new resort(readFile(resScanner, alpentalFile));
        //final resort crystal = new resort(readFile(resScanner, alpentalFile));
        //final resort crystal = new resort(alpScan.readFile());

        resort[] resArray = new resort[3];
        resArray[1] = alpental;
        resArray[2] = crystal;
        for(int i = 1; i <= 2; i++) {
            compileButtonView(resArray[i], i);
        }
    }

    //Adds the text of the snow data to the specified TextView by taking a String[] and a TextView as paramteres
    public void printSnowData(String[] snowData, TextView textView) {
        textView.setText("");
        for(String i : snowData) {
            textView.append(i + " ");
        }
        textView.append("\n");
    }

    public void setButton(final Button button, final resort res, final TextView textView) {
        button.setOnClickListener(new View.OnClickListener() {
            //@Override
            public void onClick(View v) {
                res.toggle();
                if(res.checkText()) {
                    textView.setPadding(0,0,0,0);
                    printSnowData(res.getDataArray(), textView);
                }
                else {
                    textView.setPadding(0, 0, 0, 25);
                    textView.setText("");
                }
            }
        });
    }
    //Doesnt appear to be running the for loop
    public String[] readFile(Scanner console, File file) {
        String[] data = new String[5];
        try {
            console = new Scanner(file);
            for(int i = 0; i <= 4; i++) {
                data[i] = console.next();
            }
        }
        catch (FileNotFoundException e) {
            data[0] = "I don't work";
            e.printStackTrace();
        }
        return data;
    }

    public void launchActivity() {
        Intent intent = new Intent(this, openActivity.class);
        startActivity(intent);
    }

    public Button buildButton(String name, int n) {
        Button button = new Button(this);
        RelativeLayout rl = (RelativeLayout) findViewById(R.id.activity_main);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.addRule(RelativeLayout.BELOW, R.id.swapButton);
        rl.addView(button, lp);
        button.setText(name);
        //button.setId(id);

        return button;
    }

    public TextView buildView(int id, Button button) {
        TextView tv = new TextView(this);
        RelativeLayout rl = (RelativeLayout) findViewById(R.id.activity_main);
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.addRule(RelativeLayout.BELOW, button.getId());
        rl.addView(tv, lp);
        tv.setId(id + 10);
        tv.setText("Iwork");

        return tv;
    }

    public void compileButtonView(resort res, int n) {
        Button button = buildButton(res.getResName(), n);
        TextView tv = buildView(n, button);

        setButton(button, res, tv);
    }
}
