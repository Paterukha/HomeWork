package com.example.HW53.HW53.flowers;


public class Rose extends Flower {
    private double price = 100;

    public Rose(){
        super.price = this.price;
    }

    public String show(){
        return "rose";
    }

}
