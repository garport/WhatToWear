package com.example.root.testapp;

public class ClothingShoes extends ClosetItem {

    public ClothingShoes(String type, String color) {
        super(type, color);

    }
    public void findImageSource(){
        if(this.itemType.equals("Flat Shoe") && this.formality.equals("Casual")){
            setImageSource(R.drawable.shoes1);
        }
        else if(this.itemType.equals("Boot")){
            setImageSource(R.drawable.shoes2);
        }
        else if(this.itemType.equals("Heeled Shoe") && this.formality.equals("Very Formal")){
            setImageSource(R.drawable.shoes3);
        }
        else if(this.itemType.equals("Heeled Shoe")){
            setImageSource(R.drawable.shoes4);
        }
    }

}