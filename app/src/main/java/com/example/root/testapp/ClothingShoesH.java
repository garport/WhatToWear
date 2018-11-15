package com.example.root.testapp;

public class ClothingShoesH {
    public String type;
    public int imageFile;


    public ClothingShoesH(String type, int i) {
        this.type = type;
        this.imageFile = i;
    }


    public void setType(String type) {
        this.type = type;
    }

    public void setImageFile(int imageFile) {
        this.imageFile = imageFile;
    }

    public String getType() {
        return type;
    }

    public int getImageFile() {
        return imageFile;
    }
}