package com.teccart.exohitball;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StartScreen startScreen = new StartScreen(this);
        //startScreen.setKeepScreenOn(true);

        setContentView(startScreen);
    }
}

