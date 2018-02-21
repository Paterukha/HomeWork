package com.example.HW52.Task1.players;

public class Player {
    private final double price;

    public Player(double price){
        this.price = price;
    }

    public double getPrice(){
        return price;
    }

    public void playSong(String song){
        System.out.println("Playing: \"" + song + "\"");
    }
}
