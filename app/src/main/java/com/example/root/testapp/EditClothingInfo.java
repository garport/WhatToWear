package com.example.root.testapp;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;

public class EditClothingInfo extends AppCompatActivity {
    ClosetItem item;

    boolean editingTop;
    boolean editingBottom;
    boolean editingShoes;
    boolean editingOuterwear;

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

        Bundle extras = getIntent().getExtras();
        item = (ClosetItem) getIntent().getSerializableExtra("item");

        if(extras.getString("article").equals("top")){
            editingTop = true;
            LinearLayout topLayout = findViewById(R.id.editTop);
            topLayout.setVisibility(View.VISIBLE);
            color = findViewById(R.id.editTopColor);
            waterResistant = findViewById(R.id.editTopWaterResistant);
            type = findViewById(R.id.editTopLength);
            pattern = findViewById(R.id.topPattern);
            warmth = findViewById(R.id.editTopWarmthBar);
            formality = findViewById(R.id.editTopFormalityBar);

            setDefaults();
        }
        else if(extras.getString("article").equals("bottom")){
            editingBottom = true;
            LinearLayout bottomLayout = findViewById(R.id.editBottom);
            bottomLayout.setVisibility(View.VISIBLE);
            color = findViewById(R.id.editBottomColor);
            waterResistant = findViewById(R.id.editBottomWaterResistant);
            type = findViewById(R.id.editBottomLength);
            pattern = findViewById(R.id.bottomPattern);
            warmth = findViewById(R.id.editBottomWarmthBar);
            formality = findViewById(R.id.editBottomFormalityBar);

            setDefaults();
        }
        else if(extras.getString("article").equals("shoes")){
            editingShoes = true;
            LinearLayout shoesLayout = findViewById(R.id.editShoes);
            shoesLayout.setVisibility(View.VISIBLE);
            color = findViewById(R.id.editShoeColor);
            waterResistant = findViewById(R.id.editShoeWaterResistant);
            type = findViewById(R.id.editShoeType);
            pattern = findViewById(R.id.shoesPattern);
            warmth = findViewById(R.id.editShoesWarmthBar);
            formality = findViewById(R.id.editShoesFormalityBar);

            setDefaults();
        }
        else if(extras.getString("article").equals("outerwear")){
            editingOuterwear = true;
            LinearLayout outerwearLayout = findViewById(R.id.editOuterwear);
            outerwearLayout.setVisibility(View.VISIBLE);
            color = findViewById(R.id.editOuterwearColor);
            waterResistant = findViewById(R.id.editOuterwearWaterResistant);
            type = findViewById(R.id.editOuterwearType);
            pattern = findViewById(R.id.outerwearPattern);
            warmth = findViewById(R.id.editOuterwearWarmthBar);
            formality = findViewById(R.id.editOuterwearFormalityBar);

            setDefaults();
        }
    }
    private void saveEdits(){
        int itemIndex = ClosetActivity.closetItems.indexOf(item);

        if(editingOuterwear){
            ClothingOuterwear listItem = (ClothingOuterwear) ClosetActivity.closetItems.get(itemIndex);
            listItem.itemType = typevalue;
            listItem.itemColor = colorvalue;
            listItem.formalityInt = formalityvalue;
            listItem.temperatureInt = warmthvalue;
            listItem.pattern = patternvalue;
            listItem.waterResistant = watervalue;
            listItem.findImageSource();
            listItem.setWarmth();
            listItem.setFormality();
        }
        else if(editingShoes){
            ClothingShoes listItem = (ClothingShoes) ClosetActivity.closetItems.get(itemIndex);
            listItem.itemType = typevalue;
            listItem.itemColor = colorvalue;
            listItem.formalityInt = formalityvalue;
            listItem.temperatureInt = warmthvalue;
            listItem.pattern = patternvalue;
            listItem.waterResistant = watervalue;
            listItem.findImageSource();
            listItem.setWarmth();
            listItem.setFormality();
        }
        else if(editingTop){
            ClothingTop listItem= (ClothingTop) ClosetActivity.closetItems.get(itemIndex);
            listItem.itemType = typevalue;
            listItem.itemColor = colorvalue;
            listItem.formalityInt = formalityvalue;
            listItem.temperatureInt = warmthvalue;
            listItem.pattern = patternvalue;
            listItem.waterResistant = watervalue;
            listItem.findImageSource();
            listItem.setWarmth();
            listItem.setFormality();
        }
        else if(editingBottom){
            ClothingBottom listItem = (ClothingBottom) ClosetActivity.closetItems.get(itemIndex);listItem.itemType = typevalue;
            listItem.itemColor = colorvalue;
            listItem.formalityInt = formalityvalue;
            listItem.temperatureInt = warmthvalue;
            listItem.pattern = patternvalue;
            listItem.waterResistant = watervalue;
            listItem.findImageSource();
            listItem.setWarmth();
            listItem.setFormality();
        }
    }
    private void setDefaults(){
        for(int i = 0; i < color.getChildCount(); i++){
            RadioButton rButton = (RadioButton) color.getChildAt(i);
            if(rButton.getText().toString().equals(item.itemColor)){
                rButton.setChecked(true);
            }
        }
        for(int i = 0; i < waterResistant.getChildCount(); i++){
            RadioButton rButton = (RadioButton) waterResistant.getChildAt(i);
            if(rButton.getText().toString().equals(item.waterResistant)){
                rButton.setChecked(true);
            }
        }
        for(int i = 0; i < type.getChildCount(); i++){
            RadioButton rButton = (RadioButton) type.getChildAt(i);
            if(rButton.getText().toString().equals(item.itemType)){
                rButton.setChecked(true);
            }

        }
        for(int i = 0; i < pattern.getChildCount(); i++){
            RadioButton rButton = (RadioButton) pattern.getChildAt(i);
            if(rButton.getText().toString().equals(item.pattern)){
                rButton.setChecked(true);
            }
        }
        warmth.setProgress((int)item.temperatureInt);
        formality.setProgress((int)item.formalityInt);
        editImage.setImageResource(item.imageSource);
    }
    public void saveEditsButton(View view){

        colorvalue = ((RadioButton)this.findViewById(color.getCheckedRadioButtonId())).getText().toString();
        watervalue = ((RadioButton)this.findViewById(waterResistant.getCheckedRadioButtonId())).getText().toString();
        typevalue = ((RadioButton)this.findViewById(type.getCheckedRadioButtonId())).getText().toString();
        patternvalue = ((RadioButton)this.findViewById(pattern.getCheckedRadioButtonId())).getText().toString();
        warmthvalue = warmth.getProgress();
        formalityvalue = formality.getProgress();
        if(colorvalue!=null && watervalue!=null && typevalue!=null){
            saveEdits();
            finish();
        }
    }
    public void deleteItemButton(View view){
        ClosetActivity.closetItems.remove(item);
        finish();
    }
}
