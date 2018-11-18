package com.example.root.testapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;


public class CustomizeActivity extends AppCompatActivity {
    static int top = 3;
    static int bottom = 1;
    static int shoes = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custumize_outfit);
    }

    public void wearItButtonPressed(View view){
        startActivity(new Intent(CustomizeActivity.this, MainActivity.class));

    }
    public void nextTopButtonPressed(View view){
        ImageView customTop= findViewById(R.id.customTop);
        top++;
        switch (top){
            case -1:
                top = 6;
                break;
            case 0:
                customTop.setImageResource(R.drawable.jacket2);
                break;
            case 1:
                customTop.setImageResource(R.drawable.jacket1);
                break;
            case 2:
                customTop.setImageResource(R.drawable.jacket3);
                break;
            case 3:
                customTop.setImageResource(R.drawable.shirt1);
                break;
            case 4:
                customTop.setImageResource(R.drawable.shirt2);
                break;
            case 5:
                customTop.setImageResource(R.drawable.shirt4);
                break;
            case 6:
                customTop.setImageResource(R.drawable.shirt3);
                break;
            case 7:
                top = 0;
                break;
        }
    }

    public void prevTopButtonPressed(View view){
        ImageView customTop= findViewById(R.id.customTop);
        top--;
        switch (top){
            case -1:
                top = 0;
                break;
            case 0:
                customTop.setImageResource(R.drawable.jacket2);
                break;
            case 1:
                customTop.setImageResource(R.drawable.jacket1);
                break;
            case 2:
                customTop.setImageResource(R.drawable.jacket3);
                break;
            case 3:
                customTop.setImageResource(R.drawable.shirt1);
                break;
            case 4:
                customTop.setImageResource(R.drawable.shirt2);
                break;
            case 5:
                customTop.setImageResource(R.drawable.shirt4);
                break;
            case 6:
                customTop.setImageResource(R.drawable.shirt3);
                break;
            case 7:
                top = 0;
                break;
        }
    }

    public void prevBottomButtonPressed(View view){
        ImageView customBottom= findViewById(R.id.customPants);
        bottom--;
        switch (bottom){
            case -1:
                bottom = 1;
                break;
            case 0:
                customBottom.setImageResource(R.drawable.pants1);
                break;
            case 1:
                customBottom.setImageResource(R.drawable.pants2);
                break;

            case 2:
                bottom = 0;
                break;
        }
    }

    public void nextBottomButtonPressed(View view){
        ImageView customBottom= findViewById(R.id.customPants);
        bottom++;
        switch (bottom){
            case -1:
                bottom = 1;
                break;
            case 0:
                customBottom.setImageResource(R.drawable.pants1);
                break;
            case 1:
                customBottom.setImageResource(R.drawable.pants2);
                break;
            case 2:
                bottom = 0;
                break;
        }
    }
    public void nextShoesButtonPressed(View view){
        ImageView customShoes = findViewById(R.id.customShoes);
        shoes++;
        switch(shoes){
            case -1:
                shoes = 3;
                break;
            case 0:
                customShoes.setImageResource(R.drawable.shoes2);
                break;
            case 1:
                customShoes.setImageResource(R.drawable.shoes3);
                break;
            case 2:
                customShoes.setImageResource(R.drawable.shoes1);
                break;
            case 3:
                customShoes.setImageResource(R.drawable.shoes4);
                break;
            case 4:
                shoes = 0;
                break;
        }
    }
    public void prevShoesButtonPressed(View view){
        ImageView customShoes = findViewById(R.id.customShoes);
        shoes--;
        switch(shoes){
            case -1:
                shoes = 3;
                break;
            case 0:
                customShoes.setImageResource(R.drawable.shoes2);
                break;
            case 1:
                customShoes.setImageResource(R.drawable.shoes3);
                break;
            case 2:
                customShoes.setImageResource(R.drawable.shoes1);
                break;
            case 3:
                customShoes.setImageResource(R.drawable.shoes4);
                break;
            case 4:
                shoes = 0;
                break;
        }
    }
}