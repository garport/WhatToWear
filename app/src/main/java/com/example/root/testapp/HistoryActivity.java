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
        recyclerView = findViewById(R.id.recyclerView);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(HistoryActivity.this, 2);
        recyclerView.setLayoutManager(mGridLayoutManager);

        recyclerView.setAdapter(new OutfitHistoryAdapter(HistoryActivity.this, outfitHistory));

    }


}