package com.example.root.testapp;

import android.app.Application;

public class CustomApp extends Application {

    //This class is used to add test outfit history only once per app launch.

    @Override
    public void onCreate() {
        super.onCreate();

        // test data for history
        ClothingTopH top = new ClothingTopH("Red","Cool","Informal","Short-Sleeve",R.drawable.shirt1);
        ClothingBottomH bottom = new ClothingBottomH("Blue","Cool","Informal","Shorts",R.drawable.pants1);
        ClothingShoesH shoes = new ClothingShoesH("Sneakers",R.drawable.shoes1);
        Outfit outfit1 = new Outfit(top, bottom, shoes, "11/12/18", R.drawable.outfit1);
        Outfit outfit2 = new Outfit(top, bottom, shoes, "11/11/18", R.drawable.outfit1);
        Outfit outfit3 = new Outfit(top, bottom, shoes, "11/10/18", R.drawable.outfit1);
        Outfit outfit4 = new Outfit(top, bottom, shoes, "11/9/18", R.drawable.outfit1);
        Outfit outfit5 = new Outfit(top, bottom, shoes, "11/8/18", R.drawable.outfit1);
        Outfit outfit6 = new Outfit(top, bottom, shoes, "11/7/18", R.drawable.outfit1);
        Outfit outfit7 = new Outfit(top, bottom, shoes, "11/6/18", R.drawable.outfit1);
        HistoryActivity.outfitHistory.add(outfit1);
        HistoryActivity.outfitHistory.add(outfit2);
        HistoryActivity.outfitHistory.add(outfit3);
        HistoryActivity.outfitHistory.add(outfit4);
        HistoryActivity.outfitHistory.add(outfit5);
        HistoryActivity.outfitHistory.add(outfit6);
        HistoryActivity.outfitHistory.add(outfit7);
    }
}
