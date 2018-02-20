package com.example.HW51.task1;


import javafx.application.Application;
import javafx.stage.Stage;

public class MainExtra extends Application {
    public static final int WIDTH = 900;
    public static final int HEIGHT = 825;
    public static final int MARGIN = 100;
    public static final int EYES_NOSE = 3;

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setWidth(WIDTH);
        primaryStage.setHeight(HEIGHT);
        primaryStage.setTitle("Снеговик");

        CircleScene circleScene = new CircleScene(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }

}