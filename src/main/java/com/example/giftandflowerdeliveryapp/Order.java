package com.example.giftandflowerdeliveryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

// --------------------------------------------------------------------
// Assignment 2
// Written by: Arshjit Sansoe and 1980293
// For Application Development 2 (Mobile) - Winter 2022
// --------------------------------------------------------------------

public class Order extends AppCompatActivity {
    long timeLeftInMilliseconds = 60000;
    CountDownTimer timer;
    TextView textTimer;
    Button urlBtn;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        urlBtn = findViewById(R.id.openURL);
        textTimer = findViewById(R.id.timer);

        timer();

        // open google url
        urlBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uri = Uri.parse("https://www.google.ca/");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
    }

    public void timer() {
        timer = new CountDownTimer(timeLeftInMilliseconds,1000) {
            @Override
            public void onTick(long l) {
                timeLeftInMilliseconds = l;
                updateTimer();
            }

            //when timer finishes the app will go back to welcome page
            @Override
            public void onFinish() {
                Data.setCartNames(new ArrayList<>());
                Data.setCartPrices(new ArrayList<>());
                startActivity(new Intent(Order.this, MainActivity.class));
            }
        }.start();
    }

    public void updateTimer(){
        int minute = (int) timeLeftInMilliseconds / 600000;
        int seconds = (int) timeLeftInMilliseconds % 600000 / 1000;

        String timeLeft;
        timeLeft = "" + minute;
        timeLeft += ":";
        if (seconds < 10) timeLeft += "0";
        timeLeft += seconds;

        textTimer.setText(timeLeft);
    }
}