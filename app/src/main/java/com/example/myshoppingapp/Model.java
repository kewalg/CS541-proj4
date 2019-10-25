package com.example.myshoppingapp;

public class Model {

    private boolean isSelected;
    private String foods;
    private Object images;

    public String getFoods() {
        return foods;
    }

    public void setFood(String food) {
        this.foods = food;
    }

    public boolean getSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

}