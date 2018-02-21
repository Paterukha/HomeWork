package com.example.HW52.Task1.players;


public class PlayerPlaylist extends Player {
    protected String[] playlist;

    public PlayerPlaylist(double price, String[] playlist) {
        super(price);
        this.playlist = playlist;
    }

    public void playSong(String song, int i){
        System.out.println("Playing : " + i + ". \"" + song + "\"");
    }

}
