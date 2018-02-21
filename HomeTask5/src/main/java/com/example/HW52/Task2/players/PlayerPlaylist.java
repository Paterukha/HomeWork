package com.example.HW52.Task2.players;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;


public class PlayerPlaylist extends Player implements Showable {
    protected String[] playlist;
    protected Label[] lblPlaylist;
    protected Label lblStatus;

    public PlayerPlaylist(double price, String[] playlist, Pane root) {
        super(price,root);
        this.playlist = playlist;
    }

    public String playSong(String song, int i){
        return ("Playing : " + i + ". \"" + song + "\"");
    }

    public String playAllSongs(){
        String result = "Status:";
        for (int i = 0; i < playlist.length; i++){
            result += "\n" + playSong(playlist[i],i+1) + "; ";
        }
        return result;
    }

    @Override
    public void show(String song) {
        String[] songs = getPlaylist();


        lblStatus = new Label("Status:");
        lblStatus.setTranslateX(380);
        lblStatus.setTranslateY(60);
        root.getChildren().addAll(lblStatus);

        lblPlaylist = new Label[songs.length];
        for (int i = 0; i < lblPlaylist.length; i++){
            lblPlaylist[i] = new Label(i+1 + ". " + songs[i]);
            lblPlaylist[i].setTranslateX(10);
            lblPlaylist[i].setTranslateY(60 + i*30);
            root.getChildren().addAll(lblPlaylist[i]);
        }

        Button playSong = new Button();
        playSong.setTranslateX(10);
        playSong.setTranslateY(10);
        playSong.setText("Play song");
        playSong.setOnMouseClicked(event -> {
            lblStatus.setText(playSong(song));
        });

        Button playAllSongs = new Button();
        playAllSongs.setTranslateX(100);
        playAllSongs.setTranslateY(10);
        playAllSongs.setText("Play all songs");
        playAllSongs.setOnMouseClicked(event -> {
            lblStatus.setText(playAllSongs());
        });

        Button stopSong = new Button();
        stopSong.setTranslateX(200);
        stopSong.setTranslateY(10);
        stopSong.setText("Stop");
        stopSong.setOnMouseClicked(event -> {
            lblStatus.setText("Status: stopped");
        });

        Line line = new Line(350,10,350,450);

        root.getChildren().addAll(playSong, playAllSongs, stopSong, line);
    }

    public void setSongLabels(String[] playlist){
        if (lblPlaylist != null && lblPlaylist.length > 0){
            root.getChildren().removeAll(lblPlaylist);
        }
        lblPlaylist = new Label[playlist.length];
        for (int i = 0; i < lblPlaylist.length; i++){
            lblPlaylist[i] = new Label(i+1 + ". " + playlist[i]);
            lblPlaylist[i].setTranslateX(10);
            lblPlaylist[i].setTranslateY(60 + i*30);
            root.getChildren().addAll(lblPlaylist[i]);
        }
    }

    public String[] getPlaylist(){
        return playlist;
    }

    public String getFirstSong(){
        return playlist[0];
    }

    public String getLastSong(){
        return playlist[playlist.length-1];
    }
}
