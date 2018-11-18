package com.example.root.testapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.SeekBar;

public class EditClothingInfo extends AppCompatActivity {
    ClosetItem item;
    int itemIndex;

    boolean editingTop;
    boolean editingBottom;
    boolean editingShoes;
    boolean editingOuterwear;
    boolean editingAccessory;

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

    ImageView editImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_clothing_info);

        editImage = findViewById(R.id.editImage);

        item = (ClosetItem) getIntent().getSerializableExtra("item");
        itemIndex = getIntent().getIntExtra("itemIndex", -1);

        if(item.articleType.equals("top")){
            editingTop = true;
            ScrollView topLayout = findViewById(R.id.editTop);
            topLayout.setVisibility(View.VISIBLE);
            color = findViewById(R.id.editTopColor);
            waterResistant = findViewById(R.id.editTopWaterResistant);
            type = findViewById(R.id.editTopLength);
            pattern = findViewById(R.id.editTopPattern);
            warmth = findViewById(R.id.editTopWarmthBar);
            formality = findViewById(R.id.editTopFormalityBar);

            setDefaults();
        }
        else if(item.articleType.equals("bottom")){
            editingBottom = true;
            ScrollView bottomLayout = findViewById(R.id.editBottom);
            bottomLayout.setVisibility(View.VISIBLE);
            color = findViewById(R.id.editBottomColor);
            waterResistant = findViewById(R.id.editBottomWaterResistant);
            type = findViewById(R.id.editBottomLength);
            pattern = findViewById(R.id.editBottomPattern);
            warmth = findViewById(R.id.editBottomWarmthBar);
            formality = findViewById(R.id.editBottomFormalityBar);

            setDefaults();
        }
        else if(item.articleType.equals("shoes")){
            editingShoes = true;
            ScrollView shoesLayout = findViewById(R.id.editShoes);
            shoesLayout.setVisibility(View.VISIBLE);
            color = findViewById(R.id.editShoeColor);
            waterResistant = findViewById(R.id.editShoeWaterResistant);
            type = findViewById(R.id.editShoeType);
            pattern = findViewById(R.id.editShoesPattern);
            warmth = findViewById(R.id.editShoesWarmthBar);
            formality = findViewById(R.id.editShoesFormalityBar);

            setDefaults();
        }
        else if(item.articleType.equals("outerwear")){
            editingOuterwear = true;
            ScrollView outerwearLayout = findViewById(R.id.editOuterwear);
            outerwearLayout.setVisibility(View.VISIBLE);
            color = findViewById(R.id.editOuterwearColor);
            waterResistant = findViewById(R.id.editOuterwearWaterResistant);
            type = findViewById(R.id.editOuterwearType);
            pattern = findViewById(R.id.editOuterwearPattern);
            warmth = findViewById(R.id.editOuterwearWarmthBar);
            formality = findViewById(R.id.editOuterwearFormalityBar);

            setDefaults();
        }
        else if(item.articleType.equals("accessory")){
            editingAccessory = true;
            ScrollView accessoryLayout = findViewById(R.id.editAccessory);
            accessoryLayout.setVisibility(View.VISIBLE);
            color = findViewById(R.id.editAccessoryColor);
            waterResistant = null;
            type = findViewById(R.id.editAccessoryType);
            warmth = null;
            formality = null;
            pattern = findViewById(R.id.editAccessoryPattern);

            setDefaults();
        }
    }
    private void saveEdits(){
        ClosetList.getInstance().getItems().get(itemIndex).itemType = typevalue;
        ClosetList.getInstance().getItems().get(itemIndex).itemColor = colorvalue;
        ClosetList.getInstance().getItems().get(itemIndex).formalityInt = formalityvalue;
        ClosetList.getInstance().getItems().get(itemIndex).temperatureInt = warmthvalue;
        ClosetList.getInstance().getItems().get(itemIndex).pattern = patternvalue;
        ClosetList.getInstance().getItems().get(itemIndex).waterResistant = watervalue;
        ClosetList.getInstance().getItems().get(itemIndex).setWarmth();
        ClosetList.getInstance().getItems().get(itemIndex).setFormality();
        ClosetList.getInstance().getItems().get(itemIndex).findImageSource();
    }
    private void setDefaults(){
        if(color!=null){
            for(int i = 0; i < color.getChildCount(); i++){
                RadioButton rButton = (RadioButton) color.getChildAt(i);
                if(rButton.getText().toString().equals(item.itemColor)){
                    rButton.setChecked(true);
                }
            }
        }
        if(waterResistant!=null){
            for(int i = 0; i < waterResistant.getChildCount(); i++){
                RadioButton rButton = (RadioButton) waterResistant.getChildAt(i);
                if(rButton.getText().toString().equals(item.waterResistant)){
                    rButton.setChecked(true);
                }
            }
        }
        if(type!=null){
            for(int i = 0; i < type.getChildCount(); i++){
                RadioButton rButton = (RadioButton) type.getChildAt(i);
                if(rButton.getText().toString().equals(item.itemType)){
                    rButton.setChecked(true);
                }

            }
        }
        if(pattern!=null){
            for(int i = 0; i < pattern.getChildCount(); i++){
                RadioButton rButton = (RadioButton) pattern.getChildAt(i);
                if(rButton.getText().toString().equals(item.pattern)){
                    rButton.setChecked(true);
                }
            }
        }
        if(warmth!=null){
            warmth.setProgress((int)item.temperatureInt);
        }
        if(formality!=null){
            formality.setProgress((int)item.formalityInt);
        }
        editImage.setImageResource(item.imageSource);
    }
    public void saveEditsButton(View view){
        if(color!=null){
            colorvalue = ((RadioButton)this.findViewById(color.getCheckedRadioButtonId())).getText().toString();
        }
        if(waterResistant!=null){
            watervalue = ((RadioButton)this.findViewById(waterResistant.getCheckedRadioButtonId())).getText().toString();
        }
        if(type!=null){
            typevalue = ((RadioButton)this.findViewById(type.getCheckedRadioButtonId())).getText().toString();
        }
        if(patternvalue!=null){
            patternvalue = ((RadioButton)this.findViewById(pattern.getCheckedRadioButtonId())).getText().toString();
        }
        if(warmth!=null){
            warmthvalue = warmth.getProgress();
        }
        if(formality!=null){
            formalityvalue = formality.getProgress();
        }
        saveEdits();
        Intent i = new Intent(getBaseContext(), ClosetActivity.class);
        this.startActivity(i);

    }
    public void deleteItemButton(View view){
        ClosetList.getInstance().getItems().remove(itemIndex);
        Intent i = new Intent(getBaseContext(), ClosetActivity.class);
        this.startActivity(i);
    }
    public void cancelButton(View view){
        Intent i = new Intent(getBaseContext(), ClosetActivity.class);
        this.startActivity(i);
    }
}