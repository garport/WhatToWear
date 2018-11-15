package com.example.root.testapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {

    public static List<Outfit> outfitHistory = new ArrayList<>();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        //setSupportActionBar(toolbar);
        /*DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
*/

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
        outfitHistory.add(outfit1);
        outfitHistory.add(outfit2);
        outfitHistory.add(outfit3);
        outfitHistory.add(outfit4);
        outfitHistory.add(outfit5);
        outfitHistory.add(outfit6);
        outfitHistory.add(outfit7);


        recyclerView = findViewById(R.id.recyclerView);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(HistoryActivity.this, 2);
        recyclerView.setLayoutManager(mGridLayoutManager);

        recyclerView.setAdapter(new OutfitHistoryAdapter(HistoryActivity.this, outfitHistory));

    }


}