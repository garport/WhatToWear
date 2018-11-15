package com.example.root.testapp;

import java.io.Serializable;

public class ClosetItem implements Serializable {
    public int imageSource;
    public String itemColor;
    public String temperature;
    public String formality;
    public String itemType;
    public double temperatureInt;
    public double formalityInt;
    public String waterResistant;
    public String pattern;

    public ClosetItem(String typ, String col){
        this.itemType = typ;
        this.itemColor = col;
    }
    public void setWarmth(){
        if(this.temperatureInt >= 0.0 && this.temperatureInt < 25.0){
            this.temperature = "Cool";
        }
        else if(this.temperatureInt >= 25.0 && this.temperatureInt < 50.0){
            this.temperature = "Somewhat Warm";
        }
        else if(this.temperatureInt>=50.0 && this.temperatureInt<75.0){
            this.temperature = "Warm";
        }
        else{
            this.temperature = "Very Warm";
        }

    }
    public void setFormality(){
        if(this.formalityInt >= 0.0 && this.formalityInt < 25.0){
            this.formality = "Very casual";
        }
        else if(this.formalityInt >= 25.0 && this.formalityInt < 50.0){
            this.formality = "Casual";
        }
        else if(this.formalityInt>=50.0 && this.formalityInt<75.0){
            this.formality = "Formal";
        }
        else{
            this.formality = "Very Formal";
        }
    }
    public void setImageSource(int source){
        this.imageSource = source;
    }
}
