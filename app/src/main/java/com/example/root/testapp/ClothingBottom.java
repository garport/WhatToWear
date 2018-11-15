package com.example.root.testapp;

public class ClothingBottom extends ClosetItem {
    public ClothingBottom(String type, String color) {
        super(type, color);

    }
    public void findImageSource(){
        if(this.itemType.equals("Short Length")){
            setImageSource(R.drawable.pants1);
        }
        else if(this.itemType.equals("Long Pants")){
            setImageSource(R.drawable.pants2);
        }
    }
}