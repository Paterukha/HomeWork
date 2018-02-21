package com.example.HW52.Task2.players;

import javafx.scene.layout.Pane;


public class Player {
    private final double price;
    protected Pane root;

    public Player(double price, Pane root){
        this.price = price;
        this.root = root;
    }

    public double getPrice(){
        return price;
    }

    public String playSong(String song){
        return ("Playing: \"" + song + "\"");
    }
}
