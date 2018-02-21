package com.example.HW52.Task1.players;

public class Player5 extends Player3 {

    public Player5(double price, String[] playlist) {
        super(price, playlist);
    }


    public void playAllSongs(){
        System.out.println("Playing playlist:");
        for (int i = playlist.length-1; i >= 0; i--){
            playSong(playlist[i], i+1);
        }
    }

}
