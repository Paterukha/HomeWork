package com.example.HW52.Task2.players;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;


public class Player4 extends PlayerPlaylist {

    public Player4(double price, String[] playlist, Pane root) {
        super(price, playlist, root);
    }


    public String playSong(){
        return super.playSong(playlist[playlist.length - 1], playlist.length);
    }

}
