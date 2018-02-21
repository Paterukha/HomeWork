package com.example.HW52.Task1.players;

public class Player3 extends PlayerPlaylist {

    public Player3(double price, String[] playlist) {
        super(price, playlist);
    }

    public void playAllSongs(){
        System.out.println("Playing playlist:");
        for (int i = 0; i < playlist.length; i++){
            playSong(playlist[i],i+1);
        }
    }

    public void playSong(){
        super.playSong(playlist[0], 1);
    }
}
