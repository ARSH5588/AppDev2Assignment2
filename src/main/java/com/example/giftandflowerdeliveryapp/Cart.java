package com.example.giftandflowerdeliveryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

// --------------------------------------------------------------------
// Assignment 2
// Written by: Arshjit Sansoe and 1980293
// For Application Development 2 (Mobile) - Winter 2022
// --------------------------------------------------------------------

public class Cart extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    Button checkoutPageBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerAdapter = new RecyclerAdapter(this, Data.convertArraylistToArray(Data.getCartNames()), Data.convertArraylistToArray(Data.getCartPrices()));
        recyclerView.setAdapter(recyclerAdapter);

        checkoutPageBtn = findViewById(R.id.checkoutPageBtn);
        checkoutPageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Cart.this, Checkout.class));
            }
        });
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.cart:
                startActivity(new Intent(Cart.this, Cart.class));
                return true;
            case R.id.favorite:
                startActivity(new Intent(Cart.this, Favorite.class));
                return true;
        }
        return true;
    }
}