package com.example.giftandflowerdeliveryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

// --------------------------------------------------------------------
// Assignment 2
// Written by: Arshjit Sansoe and 1980293
// For Application Development 2 (Mobile) - Winter 2022
// --------------------------------------------------------------------

public class MainActivity extends AppCompatActivity {
    Button flowerBtn;
    Button giftBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        giftBtn = findViewById(R.id.giftBtn);
        flowerBtn = findViewById(R.id.flowerBtn);

        giftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Change this activity to Gift activity
                startActivity(new Intent(MainActivity.this, Gift.class));
            }
        });

        flowerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Change this activity to Gift activity
                startActivity(new Intent(MainActivity.this, Flower.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.cart:
                startActivity(new Intent(MainActivity.this, Cart.class));
                return true;
            case R.id.favorite:
                startActivity(new Intent(MainActivity.this, Favorite.class));
                return true;
        }
        return true;
    }
}