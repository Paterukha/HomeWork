package com.example.HW51.task2;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    public static final int WIDTH = 900;
    public static final int HEIGHT = 825;
    public static final int MARGIN = 100;

    public static final double CIRCLE = 360;
    public static final double SQUARE = 90;
    public static final int POLYGON = 5;

    private double x;
    private double y;
    private double radius;
    private String method;



    private Pane root = new Pane();

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setWidth(WIDTH);
        primaryStage.setHeight(HEIGHT);
        primaryStage.setTitle("Звездочка");


        Input input = new Input();
        x = input.getX();
        y = input.getY();
        radius = input.getRadius();
        method = input.getMethod();


        switch (method){
            case "1":

                DrawMethod5Lines drawMethod5Lines = new DrawMethod5Lines(x,y,radius,root);
                break;
            default:

                DrawMethod10Lines drawMethod10Lines = new DrawMethod10Lines(x,y,radius,root);
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