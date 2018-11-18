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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class ClosetActivity extends AppCompatActivity {
    GridLayout gridLayout;
    Context context = this;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mycloset);
        gridLayout= findViewById(R.id.mainGrid);
        spinner = findViewById(R.id.filter);
        String[] filters = {"All", "Tops", "Bottoms", "Shoes", "Outerwear", "Accessories"};
        ArrayAdapter<String> adapter0 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, filters);
        adapter0.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter0);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener () {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String selected =  parentView.getItemAtPosition(position).toString();
                updateCards(gridLayout, selected);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                updateCards(gridLayout, "All");
            }

        });



        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context, AddItem.class));
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
    public void updateCards(final GridLayout gridLayout, String filter){
        final String finalFilter = filter;
        final ArrayList<ClosetItem> displayItems;
        if(filter.equals("All")){
            displayItems = ClosetList.getInstance().getItems();
        }
        else if(filter.equals("Tops")){
            displayItems = ClosetList.getInstance().getTops();
        }
        else if(filter.equals("Bottoms")){
            displayItems = ClosetList.getInstance().getBottoms();
        }
        else if(filter.equals("Outerwear")){
            displayItems = ClosetList.getInstance().getOuterwear();
        }
        else if(filter.equals("Shoes")){
            displayItems = ClosetList.getInstance().getShoes();
        }
        else{
            displayItems = ClosetList.getInstance().getAccessories();
        }
        for(int i = 0; i<6; i++){
            if(i < displayItems.size()){
                final int finali = i;
                final ClosetItem item = displayItems.get(i);
                CardView cardView=(CardView)gridLayout.getChildAt(i);
                ImageView cardImage;
                if(i==0){
                    cardImage = cardView.findViewById(R.id.cardView0);
                }
                else if(i==1){
                    cardImage = cardView.findViewById(R.id.cardView1);
                }
                else if(i==2){
                    cardImage = cardView.findViewById(R.id.cardView2);
                }
                else if(i==3){
                    cardImage = cardView.findViewById(R.id.cardView3);
                }
                else if(i==4){
                    cardImage = cardView.findViewById(R.id.cardView4);
                }
                else{
                    cardImage = cardView.findViewById(R.id.cardView5);
                }
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
                        TextView patternView = dialog.findViewById(R.id.viewPattern);

                        typeView.setText(item.itemType);
                        colorView.setText(item.itemColor);
                        if(item.articleType.equals("accessory")){
                            warmthView.setText("N/A");
                            formalityView.setText("N/A");
                        }
                        else{
                            warmthView.setText(item.temperature);
                            formalityView.setText(item.formality);
                        }
                        patternView.setText(item.pattern);
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
                                Intent intent = new Intent(context, EditClothingInfo.class);
                                intent.putExtra("item", item);
                                intent.putExtra("itemIndex", finali);
                                context.startActivity(intent);
                                updateCards(gridLayout, finalFilter);
                                dialog.dismiss();
                            }
                        });
                        dialog.show();
                    }
                });
            }
            else{
                return;
            }

        }

    }
}

