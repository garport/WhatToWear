package com.example.root.testapp;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ClosetActivity extends AppCompatActivity {
    public static ArrayList<ClosetItem> closetItems = new ArrayList<ClosetItem>();
    GridLayout gridLayout;
    final Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mycloset);
        gridLayout= findViewById(R.id.mainGrid);
        updateCards(gridLayout);
        //setSingleEvent(gridLayout);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ClosetActivity.this, AddItem.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void addClosetItem(ClosetItem item){
        closetItems.add(item);
        updateCards(gridLayout);
    }
    public void updateCards(GridLayout gridLayout){
        for(int i = 0; i<closetItems.size(); i++){
            final ClosetItem item = closetItems.get(i);
            final CardView cardView=(CardView)gridLayout.getChildAt(i);
            ImageView cardImage = (ImageView) cardView.getChildAt(0);
            cardImage.setImageResource(item.imageSource);
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final Dialog dialog = new Dialog(context);
                    dialog.setContentView(R.layout.view_clothing_info);
                    Button doneButton = dialog.findViewById(R.id.doneButton);
                    TextView typeView = dialog.findViewById(R.id.viewType);
                    TextView colorView = dialog.findViewById(R.id.viewColor);
                    TextView warmthView = dialog.findViewById(R.id.viewWarmth);
                    TextView formalityView = dialog.findViewById(R.id.viewFormality);

                    typeView.setText(item.itemType);
                    colorView.setText(item.itemColor);
                    warmthView.setText(item.temperature);
                    formalityView.setText(item.formality);

                    ImageView img = dialog.findViewById(R.id.image);
                    img.setImageResource(item.imageSource);
                    doneButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                    Button editButton = dialog.findViewById(R.id.editButton);
                    editButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(item instanceof ClothingTop){
                                Intent i = new Intent(getBaseContext(), EditClothingInfo.class);
                                i.putExtra("article", "top");
                                i.putExtra("item", item);
                                context.startActivity(i);
                            }
                            else if(item instanceof ClothingBottom){
                                Intent i = new Intent(getBaseContext(), EditClothingInfo.class);
                                i.putExtra("article", "bottom");
                                i.putExtra("item", item);
                                context.startActivity(i);
                            }
                            else if(item instanceof ClothingOuterwear){
                                Intent i = new Intent(getBaseContext(), EditClothingInfo.class);
                                i.putExtra("article","outerwear");
                                i.putExtra("item", item);
                                context.startActivity(i);
                            }
                            else if(item instanceof ClothingShoes){
                                Intent i = new Intent(getBaseContext(), EditClothingInfo.class);
                                i.putExtra("article","shoes");
                                i.putExtra("item", item);
                                context.startActivity(i);
                            }

                        }
                    });
                    dialog.show();
                }
            });
        }

    }
}

