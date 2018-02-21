package com.example.HW52.Task1.players;


public class Player4 extends Player3 {

    public Player4(double price, String[] playlist) {
        super(price, playlist);
    }


    public void playSong(){
        super.playSong(playlist[playlist.length - 1], playlist.length);
    }
}
