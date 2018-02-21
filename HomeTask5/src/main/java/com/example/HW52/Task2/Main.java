package com.example.HW52.Task2;

import com.example.HW52.Task2.players.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;



public class Main extends Application {
    public static final int WIDTH = 400;
    public static final int WIDTH_PLAYLIST = 700;
    public static final int HEIGHT = 200;
    public static final int HEIGHT_PLAYLIST = 500;


    private String player;

    private Pane root = new Pane();

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setWidth(WIDTH);
        primaryStage.setHeight(HEIGHT);


        Input input = new Input();
        player = input.getPlayer();


        switch (player){
            case "1":
                primaryStage.setTitle("Плеєр player1");
                Player1 player1 = new Player1(45, "Invisible Man", root);
                player1.show(player1.getSong());
                break;
            case "2":
                primaryStage.setTitle("Плеєр player2");
                Player2 player2 = new Player2(55, "Boat On The River", root);
                player2.show(player2.getSong());
                break;
            case "3":
                primaryStage.setHeight(HEIGHT_PLAYLIST);
                primaryStage.setWidth(WIDTH_PLAYLIST);
                primaryStage.setTitle("Плеєр player3");
                String[] playlist3 = {"Brothers In Arms", "Money For Nothing"};
                Player3 player3 = new Player3(75, playlist3, root);
                player3.show(player3.getFirstSong());
                break;
            case "4":
                primaryStage.setHeight(HEIGHT_PLAYLIST);
                primaryStage.setWidth(WIDTH_PLAYLIST);
                primaryStage.setTitle("Плеєр player4");
                String[] playlist4 = {"Sunrise", "July Morning"};
                Player4 player4 = new Player4(95, playlist4, root);
                player4.show(player4.getLastSong());
                break;
            case "5":
                primaryStage.setHeight(HEIGHT_PLAYLIST);
                primaryStage.setWidth(WIDTH_PLAYLIST);
                primaryStage.setTitle("Плеєр player5");
                String[] playlist5 = {"Back In Black", "Highway To Hell"};
                Player5 player5 = new Player5(105, playlist5, root);
                player5.show(player5.getFirstSong());
                break;
            case "6":
                primaryStage.setHeight(HEIGHT_PLAYLIST);
                primaryStage.setWidth(WIDTH_PLAYLIST);
                primaryStage.setTitle("Плеєр player6");
                String[] playlist6 = {"Freebird", "Sweet Home Alabama", "Tuesday's Gone"};
                Player6 player6 = new Player6(115, playlist6, root);
                player6.show(player6.getFirstSong());
                break;
            default:
                primaryStage.setTitle("Плеєр player1");
                player1 = new Player1(45, "Invisible Man", root);
                player1.show(player1.getSong());
                break;
        }

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
