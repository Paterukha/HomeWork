package com.example.HW52.Task1.players;

public class Player2 extends PlayerSong {
    public Player2(double price, String song) {
        super(price, song);
    }

    @Override
    public void playSong(String song) {
        System.out.println("Playing \"" + song + "\": error.");
    }
}
