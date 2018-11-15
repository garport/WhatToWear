package com.example.root.testapp;


public class ClothingTop extends ClosetItem {

    public ClothingTop(String type, String color)  {
        super(type, color);

    }
    public void findImageSource(){
        if(this.itemType.equals("Sleeveless")){
            setImageSource(R.drawable.shirt2);
        }
        else if(this.itemType.equals("Short Sleeve")){
            setImageSource(R.drawable.shirt1);
        }
        else if(this.itemType.equals("Long Sleeve")){
            setImageSource(R.drawable.shirt4);
        }
        else if(this.itemType.equals("Long Sleeve") && this.formality.equals("Very Formal")){
            setImageSource(R.drawable.shirt3);
        }
    }

}