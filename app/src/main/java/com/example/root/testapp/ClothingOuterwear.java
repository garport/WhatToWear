package com.example.root.testapp;

public class ClothingOuterwear extends ClosetItem {
    public ClothingOuterwear(String type, String color) {
        super(type, color);

    }
    public void findImageSource(){
        if(this.itemType.equals("Light Jacket")){
            setImageSource(R.drawable.jacket3);
        }
        else if(this.itemType.equals("Jacket")){
            setImageSource(R.drawable.jacket1);
        }
        else if(this.itemType.equals("Parka")){
            setImageSource(R.drawable.jacket2);
        }
    }
}
