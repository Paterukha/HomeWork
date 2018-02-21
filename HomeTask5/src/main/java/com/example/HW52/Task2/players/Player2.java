package com.example.HW52.Task2.players;

import javafx.scene.layout.Pane;


public class Player2 extends PlayerSong {
    public Player2(double price, String song, Pane root) {
        super(price, song, root);
    }

    @Override
    public String playSong(String song) {
        return ("Playing \"" + song + "\": error.");
    }
}
