package com.example.HW53.HW53.flowers;


public class Tulip extends Flower {
    private double price = 45;

    public Tulip(){
        super.price = this.price;
    }

    public String show(){
        return "tulip";
    }

}
