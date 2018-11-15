package com.example.root.testapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class OutfitDetail extends AppCompatActivity {

    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outfit_detail);

        ImageView outfitImage;
        TextView date;
        TextView topType;
        TextView topColor;
        TextView topTemp;
        TextView topForm;
        TextView bottomType;
        TextView bottomColor;
        TextView bottomTemp;
        TextView bottomForm;
        TextView shoeType;

        outfitImage = findViewById(R.id.outfitImage);
        date = findViewById(R.id.outfitDate);
        topType = findViewById(R.id.topType);
        topColor = findViewById(R.id.topColor);
        topTemp = findViewById(R.id.topTemp);
        topForm = findViewById(R.id.topFormality);
        bottomType = findViewById(R.id.bottomType);
        bottomColor = findViewById(R.id.bottomColor);
        bottomTemp = findViewById(R.id.bottomTemp);
        bottomForm = findViewById(R.id.bottomFormality);
        shoeType = findViewById(R.id.shoeType);

        Bundle mBundle = getIntent().getExtras();
        if (mBundle != null) {
            position = mBundle.getInt("position");
            Outfit outfit = HistoryActivity.outfitHistory.get(position);

            outfitImage.setImageResource(outfit.getImageFile());
            date.setText(outfit.getDate());

            topType.setText(outfit.getTop().getType());
            topForm.setText(outfit.getTop().getFormality());
            topColor.setText(outfit.getTop().getColor());
            topTemp.setText(outfit.getTop().getTemperature());

            bottomType.setText(outfit.getBottom().getType());
            bottomForm.setText(outfit.getBottom().getFormality());
            bottomColor.setText(outfit.getBottom().getColor());
            bottomTemp.setText(outfit.getBottom().getTemperature());

            shoeType.setText(outfit.getShoes().getType());
        }
    }
}