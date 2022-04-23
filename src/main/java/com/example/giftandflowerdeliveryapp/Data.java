package com.example.giftandflowerdeliveryapp;

import java.util.ArrayList;

// --------------------------------------------------------------------
// Assignment 2
// Written by: Arshjit Sansoe and 1980293
// For Application Development 2 (Mobile) - Winter 2022
// --------------------------------------------------------------------

public class Data {
    private final static String[] names = {
            "Asus Gaming Computer",
            "Iphone 13",
            "SteelSeries headset",
            "Samsung TV 4K Resolution",
            "Watch",
            "Designer Shirt",
            "Perfume",
            "Mechanical Keyboard",
            "Rose",
            "Tulip",
            "Orchid",
            "Peruvian Lily",
            "Chrysanthemum",
            "Hyacinth",
            "Lily",
            "Carnation"
    };
    private final static String[] prices = {
            "3000.00",
            "1500.00",
            "300.00",
            "1000.00",
            "150.00",
            "150.00",
            "70.00",
            "100.00",
            "20.00",
            "10.00",
            "6.00",
            "15.00",
            "4.00",
            "25.00",
            "13.00",
            "18.00",
    };
    private static ArrayList<String> cartNames = new ArrayList<>();
    private static ArrayList<String> cartPrices = new ArrayList<>();
    private static ArrayList<String> favoriteNames = new ArrayList<>();
    private static ArrayList<String> favoritePrices = new ArrayList<>();

    public static String[] getNames() {
        return names;
    }

    public static String[] getPrices() {
        return prices;
    }

    public static String[] getGiftNames() {
        int counter = 0;
        String[] giftNames = new String[8];
        for (int i = 0; i < 8; i++) {
            giftNames[counter] = names[i];
            counter++;
        }
        return giftNames;
    }

    public static String[] getFlowerNames() {
        int counter = 0;
        String[] flowerNames = new String[8];
        for (int i = 8; i < names.length; i++) {
            flowerNames[counter] = names[i];
            counter++;
        }
        return flowerNames;
    }

    public static String[] getGiftPrices() {
        int counter = 0;
        String[] giftPrices = new String[8];
        for (int i = 0; i < 8; i++) {
            giftPrices[counter] = prices[i];
            counter++;
        }
        return giftPrices;
    }

    public static String[] getFlowerPrices() {
        int counter = 0;
        String[] flowerPrices = new String[8];
        for (int i = 8; i < prices.length; i++) {
            flowerPrices[counter] = prices[i];
            counter++;
        }
        return flowerPrices;
    }

    public static ArrayList<String> getCartNames() {
        return cartNames;
    }

    public static void setCartNames(ArrayList<String> cartNames) {
        Data.cartNames = cartNames;
    }

    public static ArrayList<String> getCartPrices() {
        return cartPrices;
    }

    public static void setCartPrices(ArrayList<String> cartPrices) {
        Data.cartPrices = cartPrices;
    }

    public static ArrayList<String> getFavoriteNames() {
        return favoriteNames;
    }

    public static void setFavoriteNames(ArrayList<String> favoriteNames) {
        Data.favoriteNames = favoriteNames;
    }

    public static ArrayList<String> getFavoritePrices() {
        return favoritePrices;
    }

    public static void setFavoritePrices(ArrayList<String> favoritePrices) {
        Data.favoritePrices = favoritePrices;
    }

    // Convert ArrayList to Array
    public static String[] convertArraylistToArray(ArrayList<String> arrayList) {
        String[] newArr = new String[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            newArr[i] = arrayList.get(i);
        }
        return newArr;
    }
}
