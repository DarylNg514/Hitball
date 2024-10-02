package com.teccart.exohitball;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class GameOn extends AppCompatActivity {
    private AlienSolarSystem alienSolarSystem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_game_on);

        alienSolarSystem = new AlienSolarSystem(this);

        setContentView(alienSolarSystem);
    }
}

