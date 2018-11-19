package com.example.root.testapp;

import android.app.Application;

import java.util.ArrayList;

public class CustomApp extends Application {

    //This class is used to add test outfit history only once per app launch.

    @Override
    public void onCreate() {
        super.onCreate();

        // test data for history
        ClothingTopH top = new ClothingTopH("Red","Cool","Informal","Jacket",R.drawable.shirt1);
        ClothingBottomH bottom = new ClothingBottomH("Blue","Cool","Informal","Long Pants",R.drawable.pants1);
        ClothingShoesH shoes = new ClothingShoesH("Sneakers",R.drawable.shoes1);
        Outfit outfit1 = new Outfit(top, bottom, shoes, "11/18/18", R.drawable.outfitcasualcool);

        top = new ClothingTopH("Blue","Cold","Informal","Parka",R.drawable.jacket2);
        bottom = new ClothingBottomH("Tan","Cold", "Informal","Long Pants",R.drawable.pants1);
        shoes = new ClothingShoesH("Boots",R.drawable.shoes1);
        ClosetItem hat = new ClosetItem("accessory","Winter Hat","Red");
        ClosetItem scarf = new ClosetItem("accessory","Scarf","Gray");
        ClosetItem mittens = new ClosetItem("accessory","Mittens","Black");
        ArrayList<ClosetItem> accessories = new ArrayList<>();
        accessories.add(hat);
        accessories.add(scarf);
        accessories.add(mittens);
        Outfit outfit2 = new Outfit(top, bottom, shoes, accessories,"11/17/18", R.drawable.outfitcold);

        top = new ClothingTopH("Black","Cool","Very Formal","Suit Jacket",R.drawable.jacket2);
        bottom = new ClothingBottomH("Black","Cool", "Very Formal","Long Pants",R.drawable.pants1);
        shoes = new ClothingShoesH("Flat Shoes",R.drawable.shoes1);
        Outfit outfit3 = new Outfit(top, bottom, shoes, "11/16/18", R.drawable.outfitformal);


        top = new ClothingTopH("Green","Warm","Informal","Shirt",R.drawable.shirtcasual);
        bottom = new ClothingBottomH("Blue","Warm", "Informal","Shorts",R.drawable.pantsshorts);
        shoes = new ClothingShoesH("Sneakers",R.drawable.shoes1);
        Outfit outfit4 = new Outfit(top, bottom, shoes, "11/15/18", R.drawable.outfitcasualwarm);

        top = new ClothingTopH("White","Warm","Informal","Tank Top",R.drawable.shirtcasual);
        bottom = new ClothingBottomH("Blue","Warm", "Informal","Shorts",R.drawable.pantsshorts);
        shoes = new ClothingShoesH("Sneakers",R.drawable.shoes1);
        Outfit outfit5 = new Outfit(top, bottom, shoes, "11/14/18", R.drawable.outfitcasualtanktop);

        HistoryActivity.outfitHistory.add(outfit1);
        HistoryActivity.outfitHistory.add(outfit2);
        HistoryActivity.outfitHistory.add(outfit3);
        HistoryActivity.outfitHistory.add(outfit4);
        HistoryActivity.outfitHistory.add(outfit5);
    }
}
