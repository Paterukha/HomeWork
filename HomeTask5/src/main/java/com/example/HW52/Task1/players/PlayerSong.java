package com.example.HW52.Task1.players;


public class PlayerSong extends Player {
    private String song;

    public PlayerSong(double price, String song){
        super(price);
        this.song = song;
    }


    public String getSong(){
        return song;
    }
}
