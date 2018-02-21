package com.example.HW52.Task2.players;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;


public class PlayerSong extends Player implements Showable {
    private String song;

    public PlayerSong(double price, String song, Pane root){
        super(price,root);
        this.song = song;
    }

    @Override
    public void show(String song) {
        Label lblStatus = new Label("Status:");
        lblStatus.setTranslateX(40);
        lblStatus.setTranslateY(130);
        root.getChildren().addAll(lblStatus);

        Label lblSong = new Label(getSong());
        lblSong.setTranslateX(10);
        lblSong.setTranslateY(60);
        root.getChildren().addAll(lblSong);

        Button playSong = new Button();
        playSong.setTranslateX(10);
        playSong.setTranslateY(10);
        playSong.setText("Play song");
        playSong.setOnMouseClicked(event -> {
            lblStatus.setText(playSong(song));
        });

        Button stopSong = new Button();
        stopSong.setTranslateX(100);
        stopSong.setTranslateY(10);
        stopSong.setText("Stop song");
        stopSong.setOnMouseClicked(event -> {
            lblStatus.setText("Status: stopped");
        });

        root.getChildren().addAll(playSong, stopSong);
    }

    public String getSong(){
        return song;
    }

}
