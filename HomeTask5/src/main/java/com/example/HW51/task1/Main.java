package com.example.HW51.task1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Random;
import java.util.Scanner;

public class Main extends Application {
    public static final int WIDTH = 900;
    public static final int HEIGHT = 825;
    public static final int MARGIN = 100;
    public static final int EYES_NOSE = 3;
    private static int count;
    private static int min_radius;
    private static int max_radius;

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setWidth(WIDTH);
        primaryStage.setHeight(HEIGHT);

        primaryStage.setTitle("Снеговик");
        Pane root = new Pane();
        getInput();


        if (checkCount(count,max_radius)) {
            root.getChildren().addAll(generateCircles(count, min_radius,max_radius));
        } else {
            root.getChildren().addAll(generateWarning());
        }

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }


    private Circle[] generateCircles(int count, int min_radius, int max_radius) {
        Random random = new Random();

        Circle[] circles = new Circle[count+EYES_NOSE];
        int radius;
        int radius_old = MARGIN;
        int x;
        int y = HEIGHT;
        int count_i = 0;
        for(int i = 0; i < circles.length-EYES_NOSE; i++) {


            radius = random.nextInt(max_radius - min_radius) + min_radius;

            y -= radius + radius_old;
            radius_old = radius;

            circles[i] = new Circle(
                    (int)WIDTH/2,
                    y,
                    radius,
                    Paint.valueOf(getColor().toString()));
            count_i = i;
        }


        for (int i = 0; i < EYES_NOSE; i++){
            circles[i + circles.length -EYES_NOSE] = generateEyesNose(circles[count_i])[i];
        }
        return circles;
    }


    private boolean checkCount(int count, int max_radius){
        return 2 * max_radius * count < (HEIGHT - MARGIN);
    }


    private Circle[] generateEyesNose(Circle circle){
        final int DIM = 3;
        int x_head = (int)circle.getCenterX();
        int y_head = (int)circle.getCenterY();
        int radius_head = (int)circle.getRadius();


        int radius = (int)radius_head/4;

        Circle[] circles = new Circle[DIM];


        circles[0] = new Circle(
                x_head - 2*radius,
                y_head - 2*radius,
                radius,
                Paint.valueOf(getColor().toString()));


        circles[1] = new Circle(
                x_head + 2*radius,
                y_head - 2*radius,
                radius,
                Paint.valueOf(getColor().toString()));


        circles[2] = new Circle(
                x_head,
                y_head,
                radius,
                Paint.valueOf(getColor().toString()));
        return circles;
    }

    private Color getColor(){
        Random random = new Random();
        Color color = Color.color(random.nextDouble(),
                random.nextDouble(),
                random.nextDouble(),
                0.6f);
        return color;
    }


    private Label generateWarning(){
        Label warningLabel = new Label("Большое количество кругов. Не помещается!");
        warningLabel.setLayoutX(WIDTH/6);
        warningLabel.setLayoutY(HEIGHT/3);
        warningLabel.setFont(new Font("Arial", 30));
        return warningLabel;
    }


    private void getInput(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите количество кругов: ");
        count = sc.nextInt();
        sc.nextLine();
        System.out.print("Введите минимальный радиус: ");
        min_radius = sc.nextInt();
        sc.nextLine();
        System.out.print("Введите максимальный радиус: ");
        max_radius = sc.nextInt();
        sc.nextLine();
    }
}