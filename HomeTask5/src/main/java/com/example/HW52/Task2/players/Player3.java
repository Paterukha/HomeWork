package com.example.HW52.Task2.players;

import javafx.scene.layout.Pane;


public class Player3 extends PlayerPlaylist {

    public Player3(double price, String[] playlist, Pane root) {
        super(price, playlist, root);
    }

    public String playSong(){
        return super.playSong(playlist[0], 1);
    }
}
