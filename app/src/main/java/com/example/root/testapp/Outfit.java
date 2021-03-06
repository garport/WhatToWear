package com.example.root.testapp;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Outfit {

    private ClothingBottomH bottom;
    private ClothingTopH top;
    private ClothingShoesH shoes;
    private ArrayList<ClosetItem> acc; // accessory list
    private String date;
    private int imageFile;

    public Outfit(ClothingTopH t, ClothingBottomH b, ClothingShoesH s, String d, int i) {
        this.top = t;
        this.bottom = b;
        this.shoes = s;
        this.date = d;
        this.imageFile = i;
    }

    public Outfit(ClothingTopH t, ClothingBottomH b, ClothingShoesH s, ArrayList<ClosetItem> a, String d, int i) {
        this.top = t;
        this.bottom = b;
        this.shoes = s;
        this.date = d;
        this.acc = a;
        this.imageFile = i;
    }


    public void setBottom(ClothingBottomH bottom) {
        this.bottom = bottom;
    }

    public void setShoes(ClothingShoesH shoes) {
        this.shoes = shoes;
    }

    public void setTop(ClothingTopH top) {
        this.top = top;
    }

    public ClothingTopH getTop() {
        return top;
    }

    public ClothingBottomH getBottom() {
        return bottom;
    }

    public ClothingShoesH getShoes() {
        return shoes;
    }

    public ArrayList<ClosetItem> getAcc() {
        return acc;
    }

    public String getDate() { return date; }

    public int getImageFile() { return imageFile;
    }
}