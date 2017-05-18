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
        final resort baker =  new resort("Baker", "27", "20", "Dumping Snow", "50");
//        alpButton = (Button) findViewById(R.id.alp_button);
//        crystalButton = (Button) findViewById(R.id.crystal_button);
//        setButton(alpButton, alpental, mainText);
//        setButton(crystalButton, crystal, text2);

//        alpentalFile = new File("src\\main\\assets\\alpental.txt");
//        resScanner alpScan = new resScanner("T:\\crystal.txt");

        //final resort alpental = new resort(readFile(resScanner, alpentalFile));
        //final resort crystal = new resort(readFile(resScanner, alpentalFile));
        //final resort crystal = new resort(alpScan.readFile());

        resort[] resArray = new resort[4];
        Button[] buttonArray = new Button[4];
        TextView[] textViewArray = new TextView[4];
        resArray[1] = alpental;
        resArray[2] = crystal;
        resArray[3] = baker;
        for(int i = 1; i <= 3; i++) {
            compileButtonView(resArray[i], i, buttonArray, textViewArray);
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
    //Takes Button button, resort res, TextView textView as parameters and sets the button to
    //modify the textView on click with the data from res
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
    //Currently useless as I can't read files, reads a file and returns a String[] that contains the resort conditions
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
    //Launches openActivity
    public void launchActivity() {
        Intent intent = new Intent(this, openActivity.class);
        startActivity(intent);
    }
    //Takes String name, int n, ant TextView[] tvArray and builds a button, and adds the layout
    public Button buildButton(String name, int n, TextView[] tvArray) {
        Button button = new Button(this);
        //finds the RelativeLayout in activity_main.xml
        RelativeLayout rl = (RelativeLayout) findViewById(R.id.activity_main);
        //creates new LayoutParams for the RelativeLayout rl
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        //If this is the first button created it's aligned BELOW the back button, otherwise it's placed BELOW the previous TextView
        if(n == 1) {
            lp.addRule(RelativeLayout.BELOW, R.id.swapButton);
        } else {
            lp.addRule(RelativeLayout.BELOW, tvArray[n-1].getId());
        }
        //adds the button and the LayoutParams to the RelativeLayout rl
        rl.addView(button, lp);
        button.setText(name);
        button.setId(n);

        return button;
    }
    //Takes int id and Button button as parameters and builds a new TextView
    public TextView buildView(int id, Button button) {
        TextView tv = new TextView(this);
        //finds the RelativeLayout in the activity_main.xml
        RelativeLayout rl = (RelativeLayout) findViewById(R.id.activity_main);
        //creates new LayoutParams for the RelativeLayout rl
        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        //adds the TextView and the LayoutParams to the RelativeLayout rl
        rl.addView(tv, lp);
        //Aligns the TextView BELOW the previous button
        lp.addRule(RelativeLayout.BELOW, button.getId());
        tv.setId(id + 10);

        return tv;
    }
    //Runs buildButton and buildView and compiles them to make the button work using setButton
    public void compileButtonView(resort res, int n, Button[] buttonArray, TextView[] textViewArray) {
        Button button = buildButton(res.getResName(), n, textViewArray);
        TextView tv = buildView(n, button);

        buttonArray[n] = button;
        textViewArray[n] = tv;

        setButton(button, res, tv);
    }
}
