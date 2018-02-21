package com.example.HW52.Task2.players;

import javafx.scene.layout.Pane;


public class Player5 extends Player3 {

    public Player5(double price, String[] playlist, Pane root) {
        super(price, playlist, root);
    }


    public String playAllSongs(){
        String result = "Status:";
        for (int i = playlist.length-1; i >= 0; i--){
            result += "\n" + playSong(playlist[i], i+1) + "; ";
        }
        return result;
    }

}
