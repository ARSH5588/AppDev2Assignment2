package com.example.giftandflowerdeliveryapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

// --------------------------------------------------------------------
// Assignment 2
// Written by: Arshjit Sansoe and 1980293
// For Application Development 2 (Mobile) - Winter 2022
// --------------------------------------------------------------------

public class Checkout extends AppCompatActivity {
    private double total = 0;
    private ArrayList<String> cartPrices = Data.getCartPrices();
    Button confirmBtn;
    TextView textTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        confirmBtn = findViewById(R.id.confirmBtn);
        textTotal = findViewById(R.id.totalCost);

        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Checkout.this, Order.class));
            }
        });
        // Calculate total
        for (int i = 0; i < cartPrices.size(); i++) {
            total += Double.parseDouble(cartPrices.get(i));
        }
        String strTotal = "" + total;
        textTotal.setText(strTotal);

    }
}