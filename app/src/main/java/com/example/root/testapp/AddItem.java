package com.example.root.testapp;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;

public class AddItem extends AppCompatActivity {
    boolean topVisible;
    boolean bottomVisible;
    boolean outerwearVisible;
    boolean shoesVisible;
    boolean accessoryVisible;
    RadioGroup color;
    RadioGroup waterResistant;
    RadioGroup type;
    RadioGroup pattern;
    SeekBar warmth;
    SeekBar formality;
    String colorvalue;
    String watervalue;
    String typevalue;
    String patternvalue;
    double warmthvalue;
    double formalityvalue;
    final Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

    }
    public void showError(){
        final Dialog errorDialog = new Dialog(this);
        errorDialog.setContentView(R.layout.error_dialog);

        TextView dialogText = errorDialog.findViewById(R.id.viewErrorText);

        if(dialogText!=null){
            dialogText.setText(checkSelectedValues());
        }
        Button dismissButton = errorDialog.findViewById(R.id.dismissButton);
        dismissButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                errorDialog.dismiss();
            }
        });
        errorDialog.show();
    }
    private void addItem(){
        ClosetItem itemToAdd = null;
        if(topVisible){
            itemToAdd = new ClosetItem("top",typevalue, colorvalue);
        }
        else if(bottomVisible){
            itemToAdd = new ClosetItem("bottom", typevalue, colorvalue);
        }
        else if(shoesVisible){
            itemToAdd = new ClosetItem("shoes", typevalue, colorvalue);
        }
        else if(outerwearVisible){
            itemToAdd = new ClosetItem("outerwear", typevalue, colorvalue);
        }
        else if(accessoryVisible){
            itemToAdd = new ClosetItem("accessory", typevalue, colorvalue);
        }
        else{
            return;
        }
        if(itemToAdd.articleType.equals("accessory")){
            itemToAdd.waterResistant = "N/A";
            itemToAdd.temperature = "N/A";
            itemToAdd.formality = "N/A";
            itemToAdd.pattern = patternvalue;
            itemToAdd.itemColor = colorvalue;
            itemToAdd.itemType = typevalue;
        }
        else {
            itemToAdd.waterResistant = watervalue;
            itemToAdd.pattern = patternvalue;
            itemToAdd.itemColor = colorvalue;
            itemToAdd.itemType = typevalue;
            itemToAdd.formalityInt = formality.getProgress();
            itemToAdd.temperatureInt =  warmth.getProgress();
            itemToAdd.setFormality();
            itemToAdd.setWarmth();
        }

        itemToAdd.findImageSource();

        ClosetList.getInstance().getItems().add(itemToAdd);

    }
    private void clearView(){
        if(bottomVisible){
            color = findViewById(R.id.bottomColor);
            waterResistant = findViewById(R.id.bottomWaterResistant);
            type = findViewById(R.id.bottomLength);
            pattern = findViewById(R.id.bottomPattern);
            warmth = findViewById(R.id.bottomWarmthBar);
            formality = findViewById(R.id.bottomFormalityBar);
        }
        else if(topVisible){
            color = findViewById(R.id.topColor);
            waterResistant = findViewById(R.id.topWaterResistant);
            type = findViewById(R.id.topLength);
            pattern = findViewById(R.id.topPattern);
            warmth = findViewById(R.id.topWarmthBar);
            formality = findViewById(R.id.topFormalityBar);
        }
        else if(shoesVisible){
            color = findViewById(R.id.shoeColor);
            waterResistant = findViewById(R.id.shoeWaterResistant);
            type = findViewById(R.id.shoeType);
            pattern = findViewById(R.id.shoesPattern);
            warmth = findViewById(R.id.shoesWarmthBar);
            formality = findViewById(R.id.shoesFormalityBar);
        }
        else if(outerwearVisible){
            color = findViewById(R.id.outerwearColor);
            waterResistant = findViewById(R.id.outerwearWaterResistant);
            type = findViewById(R.id.outerwearType);
            pattern = findViewById(R.id.outerwearPattern);
            warmth = findViewById(R.id.outerwearWarmthBar);
            formality = findViewById(R.id.outerwearFormalityBar);
        }
        else if(accessoryVisible){
            color = findViewById(R.id.accessoryColor);
            waterResistant = null;
            type = findViewById(R.id.accessoryType);
            pattern = findViewById(R.id.accessoryPattern);
            warmth = null;
            formality = null;

        }
        if(warmth!=null){
            warmth.setProgress(0);
        }
        if(formality!=null){
            formality.setProgress(0);
        }

        if(color!=null){
            if(this.findViewById(color.getCheckedRadioButtonId()) !=null){
                ((RadioButton)this.findViewById(color.getCheckedRadioButtonId())).setChecked(false);
            }
        }
        if(waterResistant!=null){
            if(this.findViewById(waterResistant.getCheckedRadioButtonId()) !=null){
                ((RadioButton)this.findViewById(waterResistant.getCheckedRadioButtonId())).setChecked(false);
            }
        }
        if(type!=null){
            if(this.findViewById(type.getCheckedRadioButtonId()) !=null){
                ((RadioButton)this.findViewById(type.getCheckedRadioButtonId())).setChecked(false);
            }
        }
        if(pattern!=null){
            if(this.findViewById(pattern.getCheckedRadioButtonId()) !=null){
                ((RadioButton)this.findViewById(pattern.getCheckedRadioButtonId())).setChecked(false);
            }
        }
    }

    private void hideAllOtherViews(){
        if(topVisible){
            ScrollView top = findViewById(R.id.addTop);
            top.setVisibility(View.INVISIBLE);
            clearView();
            topVisible = false;
        }
        if(bottomVisible){
            ScrollView bottom = findViewById(R.id.addBottom);
            bottom.setVisibility(View.INVISIBLE);
            clearView();
            bottomVisible = false;
        }
        if(outerwearVisible){
            ScrollView outerWear = findViewById(R.id.addOuterwear);
            outerWear.setVisibility(View.INVISIBLE);
            clearView();
            outerwearVisible = false;
        }
        if(shoesVisible){
            ScrollView shoes = findViewById(R.id.addShoes);
            shoes.setVisibility(View.INVISIBLE);
            clearView();
            shoesVisible = false;
        }
        if(accessoryVisible){
            ScrollView accessory = findViewById(R.id.addAccessory);
            accessory.setVisibility(View.INVISIBLE);
            clearView();
            accessoryVisible = false;
        }
    }
    private void getSelectedValues(){
        colorvalue = null;
        watervalue = null;
        typevalue = null;
        patternvalue = null;

        if(color!=null){
            if(this.findViewById(color.getCheckedRadioButtonId()) !=null){
                colorvalue = ((RadioButton)this.findViewById(color.getCheckedRadioButtonId())).getText().toString();
            }
        }
        if(waterResistant!=null){
            if(this.findViewById(waterResistant.getCheckedRadioButtonId()) !=null){
                watervalue = ((RadioButton)this.findViewById(waterResistant.getCheckedRadioButtonId())).getText().toString();
            }
        }
        if(type!=null){
            if(this.findViewById(type.getCheckedRadioButtonId()) !=null){
                typevalue = ((RadioButton)this.findViewById(type.getCheckedRadioButtonId())).getText().toString();
            }
        }
        if(pattern!=null){
            if(this.findViewById(pattern.getCheckedRadioButtonId()) !=null){
                patternvalue = ((RadioButton)this.findViewById(pattern.getCheckedRadioButtonId())).getText().toString();
            }
        }
        if(warmth!=null){
            warmthvalue = warmth.getProgress();
        }
        if(formality!=null){
            formalityvalue = formality.getProgress();
        }

    }
    private String checkSelectedValues(){
        if(colorvalue==null ){
            return ("Please select a color");

        }
        else if(watervalue==null && !accessoryVisible){
            return ("Please indicate whether the item is water resistant");

        }
        else if(typevalue==null){
            return ("Please indicate the type of item");

        }
        else if(patternvalue==null){
            return ("Please indicate the pattern of the item");

        }
        else{
            return null;
        }
    }
    public void topButtonPressed(View view){
        hideAllOtherViews();
        ScrollView top = findViewById(R.id.addTop);
        top.setVisibility(View.VISIBLE);
        topVisible = true;
        FrameLayout fab = findViewById(R.id.fabContainer);
        fab.setVisibility(View.VISIBLE);

    }
    public void bottomButtonPressed(View view){
        hideAllOtherViews();
        ScrollView bottom = findViewById(R.id.addBottom);
        bottom.setVisibility(View.VISIBLE);
        bottomVisible = true;

        FrameLayout fab = findViewById(R.id.fabContainer);
        fab.setVisibility(View.VISIBLE);
    }

    public void shoesButtonPressed(View view){
        hideAllOtherViews();
        ScrollView shoes = findViewById(R.id.addShoes);
        shoes.setVisibility(View.VISIBLE);
        shoesVisible = true;
        FrameLayout fab = findViewById(R.id.fabContainer);
        fab.setVisibility(View.VISIBLE);

    }
    public void outerwearButtonPressed(View view){
        hideAllOtherViews();
        ScrollView outerWear = findViewById(R.id.addOuterwear);
        outerWear.setVisibility(View.VISIBLE);
        outerwearVisible = true;
        FrameLayout fab = findViewById(R.id.fabContainer);
        fab.setVisibility(View.VISIBLE);

    }
    public void accessoryButtonPressed(View view){
        hideAllOtherViews();
        ScrollView accessory = findViewById(R.id.addAccessory);
        accessory.setVisibility(View.VISIBLE);
        accessoryVisible = true;
        FrameLayout fab = findViewById(R.id.fabContainer);
        fab.setVisibility(View.VISIBLE);
    }


//    public void otherButtonPressed(View view){
//
//        FrameLayout fab = (FrameLayout) findViewById(R.id.fabContainer);
//        fab.setVisibility(View.VISIBLE);
//    }

    public void addButtonPressed(View view){
        if(topVisible){
            color = findViewById(R.id.topColor);
            waterResistant = findViewById(R.id.topWaterResistant);
            type = findViewById(R.id.topLength);
            pattern = findViewById(R.id.topPattern);
            warmth = findViewById(R.id.topWarmthBar);
            formality = findViewById(R.id.topFormalityBar);

            getSelectedValues();
            if(checkSelectedValues()!=null){
                showError();
            }
            else
            {
                addItem();
                clearView();
                topVisible = false;

                ScrollView top = findViewById(R.id.addTop);
                top.setVisibility(View.INVISIBLE);
                FrameLayout fab = findViewById(R.id.fabContainer);
                fab.setVisibility(View.INVISIBLE);
            }
        }
        else if(bottomVisible){
            color = findViewById(R.id.bottomColor);
            waterResistant = findViewById(R.id.bottomWaterResistant);
            type = findViewById(R.id.bottomLength);
            pattern = findViewById(R.id.bottomPattern);
            warmth = findViewById(R.id.bottomWarmthBar);
            formality = findViewById(R.id.bottomFormalityBar);

            getSelectedValues();
            if(checkSelectedValues()!=null){
                showError();
            }
            else{
                addItem();
                clearView();
                bottomVisible = false;

                ScrollView bottom = findViewById(R.id.addBottom);
                bottom.setVisibility(View.INVISIBLE);
                FrameLayout fab = findViewById(R.id.fabContainer);
                fab.setVisibility(View.INVISIBLE);
            }

        }
        else if(outerwearVisible){
            color = findViewById(R.id.outerwearColor);
            waterResistant = findViewById(R.id.outerwearWaterResistant);
            type = findViewById(R.id.outerwearType);
            pattern = findViewById(R.id.outerwearPattern);
            warmth = findViewById(R.id.outerwearWarmthBar);
            formality = findViewById(R.id.outerwearFormalityBar);

            getSelectedValues();
            if(checkSelectedValues()!=null){
                showError();
            }
            else
            {
                addItem();
                clearView();
                outerwearVisible = false;

                ScrollView outerwear = findViewById(R.id.addOuterwear);
                outerwear.setVisibility(View.INVISIBLE);
                FrameLayout fab = findViewById(R.id.fabContainer);
                fab.setVisibility(View.INVISIBLE);
            }
        }
        else if(shoesVisible){
            color = findViewById(R.id.shoeColor);
            waterResistant = findViewById(R.id.shoeWaterResistant);
            type = findViewById(R.id.shoeType);
            pattern = findViewById(R.id.shoesPattern);
            warmth = findViewById(R.id.shoesWarmthBar);
            formality = findViewById(R.id.shoesFormalityBar);

            getSelectedValues();
            if(checkSelectedValues()!=null){
                showError();
            }
            else
            {
                addItem();
                clearView();
                shoesVisible = false;

                ScrollView shoes = findViewById(R.id.addShoes);
                shoes.setVisibility(View.INVISIBLE);
                FrameLayout fab = findViewById(R.id.fabContainer);
                fab.setVisibility(View.INVISIBLE);
            }
        }
        else if(accessoryVisible){
            color = findViewById(R.id.accessoryColor);
            type = findViewById(R.id.accessoryType);
            pattern = findViewById(R.id.accessoryPattern);

            getSelectedValues();

            if(checkSelectedValues()!=null){
                showError();
            }
            else
            {
                addItem();
                clearView();
                accessoryVisible = false;

                ScrollView shoes = findViewById(R.id.addAccessory);
                shoes.setVisibility(View.INVISIBLE);
                FrameLayout fab = findViewById(R.id.fabContainer);
                fab.setVisibility(View.INVISIBLE);
            }
        }
    }
}
