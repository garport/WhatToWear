package com.example.root.testapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;

public class AddItem extends AppCompatActivity {
    boolean addingTop;
    boolean addingBottom;
    boolean addingOuterwear;
    boolean addingShoes;
    RadioGroup color;
    RadioGroup waterResistant;
    RadioGroup type;
    RadioGroup pattern;
    SeekBar warmth;
    SeekBar formality;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
    }
    public void topButtonPressed(View view){
        addingTop = true;
        LinearLayout top = findViewById(R.id.addTop);
        top.setVisibility(View.VISIBLE);
        FrameLayout fab = findViewById(R.id.fabContainer);
        fab.setVisibility(View.VISIBLE);

    }
    public void bottomButtonPressed(View view){
        addingBottom = true;
        LinearLayout top = findViewById(R.id.addBottom);
        top.setVisibility(View.VISIBLE);
        FrameLayout fab = findViewById(R.id.fabContainer);
        fab.setVisibility(View.VISIBLE);
    }

    public void shoesButtonPressed(View view){
        addingShoes = true;
        LinearLayout top = findViewById(R.id.addShoes);
        top.setVisibility(View.VISIBLE);
        FrameLayout fab = findViewById(R.id.fabContainer);
        fab.setVisibility(View.VISIBLE);

    }
    public void outerwearButtonPressed(View view){
        addingOuterwear = true;
        LinearLayout top = findViewById(R.id.addOuterwear);
        top.setVisibility(View.VISIBLE);
        FrameLayout fab = findViewById(R.id.fabContainer);
        fab.setVisibility(View.VISIBLE);

    }
    public void accessoryButtonPressed(View view){
        LinearLayout top = findViewById(R.id.addAccessory);
        top.setVisibility(View.VISIBLE);
        FrameLayout fab = findViewById(R.id.fabContainer);
        fab.setVisibility(View.VISIBLE);
    }

//    public void otherButtonPressed(View view){
//
//        FrameLayout fab = (FrameLayout) findViewById(R.id.fabContainer);
//        fab.setVisibility(View.VISIBLE);
//    }

    public void addButtonPressed(View view){
        if(addingTop){
            color = findViewById(R.id.topColor);
            waterResistant = findViewById(R.id.topWaterResistant);
            type = findViewById(R.id.topLength);
            pattern = findViewById(R.id.topPattern);
            warmth = findViewById(R.id.topWarmthBar);
            formality = findViewById(R.id.topFormalityBar);

            String colorvalue = ((RadioButton)this.findViewById(color.getCheckedRadioButtonId())).getText().toString();
            String watervalue = ((RadioButton)this.findViewById(waterResistant.getCheckedRadioButtonId())).getText().toString();
            String lengthvalue = ((RadioButton)this.findViewById(type.getCheckedRadioButtonId())).getText().toString();
            String patternvalue = ((RadioButton)this.findViewById(pattern.getCheckedRadioButtonId())).getText().toString();
            double warmthvalue = warmth.getProgress();
            double formalityvalue = formality.getProgress();

            if(colorvalue!=null && watervalue!=null && lengthvalue!=null){
                ClothingTop itemToAdd = new ClothingTop(lengthvalue, colorvalue);

                itemToAdd.temperatureInt = warmthvalue;
                itemToAdd.formalityInt = formalityvalue;
                itemToAdd.waterResistant = watervalue;
                itemToAdd.pattern = patternvalue;
                itemToAdd.setFormality();
                itemToAdd.setWarmth();
                itemToAdd.findImageSource();


                ClosetActivity.closetItems.add(itemToAdd);

                addingTop = false;

                LinearLayout top = findViewById(R.id.addTop);
                top.setVisibility(View.INVISIBLE);
                FrameLayout fab = findViewById(R.id.fabContainer);
                fab.setVisibility(View.INVISIBLE);
            }
        }
        else if(addingBottom){
            color = findViewById(R.id.bottomColor);
            waterResistant = findViewById(R.id.bottomWaterResistant);
            type = findViewById(R.id.bottomLength);
            pattern = findViewById(R.id.bottomPattern);
            warmth = findViewById(R.id.bottomWarmthBar);
            formality = findViewById(R.id.bottomFormalityBar);

            String colorvalue = ((RadioButton)this.findViewById(color.getCheckedRadioButtonId())).getText().toString();
            String watervalue = ((RadioButton)this.findViewById(waterResistant.getCheckedRadioButtonId())).getText().toString();
            String lengthvalue = ((RadioButton)this.findViewById(type.getCheckedRadioButtonId())).getText().toString();
            String patternvalue = ((RadioButton)this.findViewById(pattern.getCheckedRadioButtonId())).getText().toString();
            double warmthvalue = warmth.getProgress();
            double formalityvalue = formality.getProgress();

            if( colorvalue!=null && watervalue!=null && lengthvalue!=null){
                ClothingBottom itemToAdd = new ClothingBottom(lengthvalue, colorvalue);

                itemToAdd.temperatureInt = warmthvalue;
                itemToAdd.formalityInt = formalityvalue;
                itemToAdd.pattern = patternvalue;
                itemToAdd.waterResistant = watervalue;
                itemToAdd.setFormality();
                itemToAdd.setWarmth();
                itemToAdd.findImageSource();


                ClosetActivity.closetItems.add(itemToAdd);

                addingBottom = false;

                LinearLayout bottom = findViewById(R.id.addBottom);
                bottom.setVisibility(View.INVISIBLE);
                FrameLayout fab = findViewById(R.id.fabContainer);
                fab.setVisibility(View.INVISIBLE);
            }
        }
        else if(addingOuterwear){
            color = findViewById(R.id.outerwearColor);
            waterResistant = findViewById(R.id.outerwearWaterResistant);
            type = findViewById(R.id.outerwearType);
            pattern = findViewById(R.id.outerwearPattern);
            warmth = findViewById(R.id.outerwearWarmthBar);
            formality = findViewById(R.id.outerwearFormalityBar);

            String colorvalue = ((RadioButton)this.findViewById(color.getCheckedRadioButtonId())).getText().toString();
            String watervalue = ((RadioButton)this.findViewById(waterResistant.getCheckedRadioButtonId())).getText().toString();
            String typevalue = ((RadioButton)this.findViewById(type.getCheckedRadioButtonId())).getText().toString();
            String patternvalue = ((RadioButton)this.findViewById(pattern.getCheckedRadioButtonId())).getText().toString();
            double warmthvalue = warmth.getProgress();
            double formalityvalue = formality.getProgress();

            if(colorvalue!=null && watervalue!=null && typevalue!=null){
                ClothingOuterwear itemToAdd = new ClothingOuterwear(typevalue, colorvalue);

                itemToAdd.temperatureInt = warmthvalue;
                itemToAdd.formalityInt = formalityvalue;
                itemToAdd.pattern = patternvalue;
                itemToAdd.waterResistant = watervalue;
                itemToAdd.setFormality();
                itemToAdd.setWarmth();
                itemToAdd.findImageSource();


                ClosetActivity.closetItems.add(itemToAdd);

                addingOuterwear = false;

                LinearLayout outerwear = findViewById(R.id.addOuterwear);
                outerwear.setVisibility(View.INVISIBLE);
                FrameLayout fab = findViewById(R.id.fabContainer);
                fab.setVisibility(View.INVISIBLE);
            }
        }
        else if(addingShoes){
            color = findViewById(R.id.shoeColor);
            waterResistant = findViewById(R.id.shoeWaterResistant);
            type = findViewById(R.id.shoeType);
            pattern = findViewById(R.id.shoesPattern);
            warmth = findViewById(R.id.shoesWarmthBar);
            formality = findViewById(R.id.shoesFormalityBar);

            String colorvalue = ((RadioButton)this.findViewById(color.getCheckedRadioButtonId())).getText().toString();
            String watervalue = ((RadioButton)this.findViewById(waterResistant.getCheckedRadioButtonId())).getText().toString();
            String typevalue = ((RadioButton)this.findViewById(type.getCheckedRadioButtonId())).getText().toString();
            String patternvalue = ((RadioButton)this.findViewById(pattern.getCheckedRadioButtonId())).getText().toString();
            double warmthvalue = warmth.getProgress();
            double formalityvalue = formality.getProgress();

            if(colorvalue!=null && watervalue!=null && typevalue!=null){
                ClothingShoes itemToAdd = new ClothingShoes(typevalue, colorvalue);

                itemToAdd.temperatureInt = warmthvalue;
                itemToAdd.formalityInt = formalityvalue;
                itemToAdd.pattern = patternvalue;
                itemToAdd.waterResistant = watervalue;
                itemToAdd.setFormality();
                itemToAdd.setWarmth();
                itemToAdd.findImageSource();


                ClosetActivity.closetItems.add(itemToAdd);

                addingShoes = false;

                LinearLayout shoes = findViewById(R.id.addShoes);
                shoes.setVisibility(View.INVISIBLE);
                FrameLayout fab = findViewById(R.id.fabContainer);
                fab.setVisibility(View.INVISIBLE);
            }
        }
    }
}
