package com.example.root.testapp;
import java.util.ArrayList;
public final class ClosetList {
    private static final ClosetList SELF = new ClosetList();
    private ArrayList<ClosetItem> items = new ArrayList<ClosetItem>();
    private ClosetList(){

    }
    public String bio = null;
    public String profilename = null;
    public String age = null;
    public static ClosetList getInstance(){
        return SELF;
    }
    public ArrayList<ClosetItem> getItems(){
        return items;
    }

    public ArrayList<ClosetItem> getTops(){
        ArrayList<ClosetItem> tops = new ArrayList<>();
        for(int i = 0; i < this.getItems().size(); i++){
            if(this.getItems().get(i).articleType.equals("top")){
                tops.add(this.getItems().get(i));
            }
        }
        return tops;
    }
    public ArrayList<ClosetItem> getBottoms(){
        ArrayList<ClosetItem> bottoms = new ArrayList<>();
        for(int i = 0; i < this.getItems().size(); i++){
            if(this.getItems().get(i).articleType.equals("bottom")){
                bottoms.add(this.getItems().get(i));
            }
        }
        return bottoms;
    }
    public ArrayList<ClosetItem> getShoes(){
        ArrayList<ClosetItem> shoes = new ArrayList<>();
        for(int i = 0; i < this.getItems().size(); i++){
            if(this.getItems().get(i).articleType.equals("shoes")){
                shoes.add(this.getItems().get(i));
            }
        }
        return shoes;
    }
    public ArrayList<ClosetItem> getOuterwear(){
        ArrayList<ClosetItem> outerwear = new ArrayList<>();
        for(int i = 0; i < this.getItems().size(); i++){
            if(this.getItems().get(i).articleType.equals("outerwear")){
                outerwear.add(this.getItems().get(i));
            }
        }
        return outerwear;
    }

    public ArrayList<ClosetItem> getAccessories(){
        ArrayList<ClosetItem> accessories = new ArrayList<>();
        for(int i = 0; i < this.getItems().size(); i++){
            if(this.getItems().get(i).articleType.equals("accessory")){
                accessories.add(this.getItems().get(i));
            }
        }
        return accessories;
    }
}
