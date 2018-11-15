package com.example.root.testapp;

public class ClothingBottomH {
    public String color;
    public String temperature;
    public String formality;
    public String type;
    public int imageFile;

    public ClothingBottomH(String color, String temp, String formal, String type, int i) {
        this.color = color;
        this.temperature = temp;
        this.formality = formal;
        this.type = type;
        this.imageFile = i;
    }



    public String getColor() {
        return color;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getFormality() {
        return formality;
    }

    public String getType() {
        return type;
    }

    public int getImageFile() {
        return imageFile;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setFormality(String formality) {
        this.formality = formality;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setImageFile(int imageFile) {
        this.imageFile = imageFile;
    }
}