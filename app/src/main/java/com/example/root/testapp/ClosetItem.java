package com.example.root.testapp;

import java.io.Serializable;

public class ClosetItem implements Serializable {
    public String articleType;
    public int imageSource;
    public String itemColor;
    public String temperature;
    public String formality;
    public String itemType;
    public double temperatureInt;
    public double formalityInt;
    public String waterResistant;
    public String pattern;

    public ClosetItem(String article, String typ, String col){
        this.articleType = article;
        this.itemType = typ;
        this.itemColor = col;
    }
    public void setWarmth(){
        if(this.temperatureInt >= 0.0 && this.temperatureInt < 25.0){
            this.temperature = "Not Warm";
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
            this.formality = "Very Casual";
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
    public void findImageSource(){
        if(this.articleType!=null){
            if(this.articleType.equals("bottom")){
                if(this.itemType.equals("Short Pants")){
                    this.setImageSource(R.drawable.pants1);
                }
                else if(this.itemType.equals("Long Pants")){
                    this.setImageSource(R.drawable.pants2);
                }
                else if(this.itemType.equals("Short Skirt")){
                    this.setImageSource(R.drawable.skirtshort);
                }
                else if(this.itemType.equals("Long Skirt")){
                    this.setImageSource(R.drawable.skirtlong);
                }
                else if(this.itemType.equals("Capri Pants")){
                    this.setImageSource(R.drawable.pantscapris);
                }

            }
            else if(this.articleType.equals("top")){
                if(this.itemType.equals("Sleeveless")){
                    this.setImageSource(R.drawable.shirt2);
                }
                else if(this.itemType.equals("Short Sleeve")){
                    this.setImageSource(R.drawable.shirt1);
                }
                else if(this.itemType.equals("Long Sleeve")){
                    this.setImageSource(R.drawable.shirt4);
                }
                else if(this.itemType.equals("Long Sleeve") && this.formality.equals("Very Formal")){
                    this.setImageSource(R.drawable.shirt3);
                }
            }
            else if(this.articleType.equals("outerwear")){
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
            else if(this.articleType.equals("shoes")){
                if(this.itemType.equals("Flat Shoe") && !this.formality.equals("Very Formal")){
                    this.setImageSource(R.drawable.shoes1);
                }
                else if(this.itemType.equals("Flat Shoe") && this.formality.equals("Very Formal")){
                    this.setImageSource(R.drawable.shoes3);
                }
                else if(this.itemType.equals("Boot")){
                    if(this.waterResistant.equals("Yes") && !this.temperature.equals("Very Warm")){
                        this.setImageSource(R.drawable.shoesrainboots);
                    }
                    else if(this.temperature.equals("Very Warm")){
                        this.setImageSource(R.drawable.shoessnowboots);
                    }
                    else{
                        this.setImageSource(R.drawable.shoes2);
                    }
                }
                else if(this.itemType.equals("Heeled Shoe") && this.formality.equals("Very Formal")){
                    this.setImageSource(R.drawable.shoes3);
                }
                else if(this.itemType.equals("Heeled Shoe")){
                    this.setImageSource(R.drawable.shoes4);
                }
                else if(this.itemType.equals("Sandals")){
                    this.setImageSource(R.drawable.shoessandals);
                }
            }
            else if(this.articleType.equals("accessory")){
                if(this.itemType.equals("Mittens")){
                    this.setImageSource(R.drawable.accessories1);
                }
                else if(this.itemType.equals("Umbrella")){
                    this.setImageSource(R.drawable.accessories2);
                }
                else if(this.itemType.equals("Winter Hat")){
                    this.setImageSource(R.drawable.hat2);
                }
                else if(this.itemType.equals("Baseball Hat")){
                    this.setImageSource(R.drawable.hat1);
                }
                else if(this.itemType.equals("Scarf")){
                    this.setImageSource(R.drawable.accessoryscarf);
                }
                else if(this.itemType.equals("Tie")){
                    this.setImageSource(R.drawable.tie2);
                }
                else if(this.itemType.equals("Bow Tie")){
                    this.setImageSource(R.drawable.tie1);
                }
                else if(this.itemType.equals("Vest")){
                    this.setImageSource(R.drawable.vest1);
                }
            }
        }
    }
    public void setImageSource(int source){
        this.imageSource = source;
    }
}
