package com.example.ros_pjmcgreevy.snowreport;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by ros_pjmcgreevy on 5/2/2017.
 */

public class resScanner {
    File file;
    Scanner scan;
    BufferedReader br;
    String[] data = new String[5];
    public resScanner(String fileLoc) {
        this.file = new File(fileLoc);

        try {
            br = new BufferedReader(new FileReader(file));
            String line;
            int i = 0;
            for(int w = 0; w <= 4; w++) {
                data[w] = "4Loop No Work";
            }
            while((line = br.readLine()) != null) {
                data[i] = line;
                data[i] = "4Loop Work";
                i++;
            }
        }
        catch(FileNotFoundException e) {
            data[0] = "FileNotFoundBro";
        }
        catch (IOException e) {
            data[1] = "IOException";
        }
    }

//    public String[] readFile() {
//        String[] data = new String[5];
//        for(int i = 0; i <= 4; i++) {
//            data[i] = scan.nextLine();
//        }
//        return data;
//    }
    public String[] readFile() {
        return data;
    }
}

