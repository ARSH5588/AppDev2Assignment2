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
import android.widget.TextView;

import java.util.ArrayList;

// --------------------------------------------------------------------
// Assignment 2
// Written by: Arshjit Sansoe and 1980293
// For Application Development 2 (Mobile) - Winter 2022
// --------------------------------------------------------------------

public class Options extends AppCompatActivity {
    TextView itemName;
    TextView itemPrice;
    Button addToFavoriteBtn;
    Button addToCartBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);

        itemName = findViewById(R.id.itemName);
        itemPrice = findViewById(R.id.itemPrice);

        addToFavoriteBtn = findViewById(R.id.addToFavorite);
        addToCartBtn = findViewById(R.id.addToCart);

        Intent intent = getIntent();

        String strItemName = intent.getStringExtra("itemName");
        String strItemPrice = intent.getStringExtra("itemPrice");

        itemName.setText(strItemName);
        itemPrice.setText(strItemPrice);

        //add to favorite
        addToFavoriteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> favoriteNames = Data.getFavoriteNames();
                ArrayList<String> favoritePrices = Data.getFavoriteNames();

                favoriteNames.add(itemName.getText().toString());
                favoritePrices.add(itemPrice.getText().toString());

                Data.setFavoriteNames(favoriteNames);
                Data.setFavoritePrices(favoritePrices);

                finish();
                startActivity(getIntent());
            }
        });
        //add to cart
        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> cartNames = Data.getCartNames();
                ArrayList<String> cartPrices = Data.getCartPrices();

                cartNames.add(itemName.getText().toString());
                cartPrices.add(itemPrice.getText().toString());

                Data.setCartNames(cartNames);
                Data.setCartPrices(cartPrices);

                finish();
                startActivity(getIntent());
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
                startActivity(new Intent(Options.this, Cart.class));
                return true;
            case R.id.favorite:
                startActivity(new Intent(Options.this, Favorite.class));
                return true;
        }
        return true;
    }
}