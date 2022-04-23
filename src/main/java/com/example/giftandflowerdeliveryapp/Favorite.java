package com.example.giftandflowerdeliveryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

// --------------------------------------------------------------------
// Assignment 2
// Written by: Arshjit Sansoe and 1980293
// For Application Development 2 (Mobile) - Winter 2022
// --------------------------------------------------------------------

public class Favorite extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    ArrayList<String> favoriteNames = Data.getFavoriteNames();
    ArrayList<String> favoritePrices = Data.getFavoritePrices();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerAdapter = new RecyclerAdapter(this, Data.convertArraylistToArray(favoriteNames), Data.convertArraylistToArray(favoritePrices));
        recyclerView.setAdapter(recyclerAdapter);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.cart:
                startActivity(new Intent(Favorite.this, Cart.class));
                return true;
            case R.id.favorite:
                startActivity(new Intent(Favorite.this, Favorite.class));
                return true;
        }
        return true;
    }
}