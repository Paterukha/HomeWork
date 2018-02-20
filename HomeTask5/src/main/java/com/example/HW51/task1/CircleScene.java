package com.example.HW51.task1;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.Random;


public class CircleScene {
    private static int count;
    private static int min_radius;
    private static int max_radius;
    private Circle[] circles;
    private Label warningLabel;
    private Pane root = new Pane();
    private Warning warning;

    public CircleScene(Stage primaryStage) {
        graphicInterface();

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    private void generateCircles(int count, int min_radius, int max_radius) {

        if (checkCount(count,max_radius)) {
            Random random = new Random();
            circles = new Circle[count + Main.EYES_NOSE];
            int radius;
            int radius_old = Main.MARGIN;
            int x;
            int y = Main.HEIGHT;
            int count_i = 0;
            for (int i = 0; i < circles.length - Main.EYES_NOSE; i++) {
                radius = random.nextInt(max_radius - min_radius) + min_radius;
                y -= radius + radius_old;
                radius_old = radius;

                circles[i] = new Circle(
                        (int) Main.WIDTH / 2,
                        y,
                        radius,
                        Paint.valueOf(getColor().toString()));
                count_i = i;
            }


            for (int i = 0; i < Main.EYES_NOSE; i++) {
                circles[i + circles.length - Main.EYES_NOSE] = generateEyesNose(circles[count_i])[i];
            }
            root.getChildren().addAll(circles);
        } else {

            warning = new Warning();
        }

    }


    private boolean checkCount(int count, int max_radius){
        return 2 * max_radius * count < (Main.HEIGHT - Main.MARGIN);
    }


    private Circle[] generateEyesNose(Circle circle){
        final int DIM = 3;
        int x_head = (int)circle.getCenterX();
        int y_head = (int)circle.getCenterY();
        int radius_head = (int)circle.getRadius();


        int radius = (int)radius_head/4;

        Circle[] circles_head = new Circle[DIM];


        circles_head[0] = new Circle(
                x_head - 2*radius,
                y_head - 2*radius,
                radius,
                Paint.valueOf(getColor().toString()));


        circles_head[1] = new Circle(
                x_head + 2*radius,
                y_head - 2*radius,
                radius,
                Paint.valueOf(getColor().toString()));


        circles_head[2] = new Circle(
                x_head,
                y_head,
                radius,
                Paint.valueOf(getColor().toString()));
        return circles_head;
    }

    private Color getColor(){
        Random random = new Random();
        Color color = Color.color(random.nextDouble(),
                random.nextDouble(),
                random.nextDouble(),
                0.6f);
        return color;
    }


    private void graphicInterface() {

        Label countFieldLabel = new Label("Количество кругов: ");
        countFieldLabel.setTranslateX(10);
        countFieldLabel.setTranslateY(10);

        TextField countField = new TextField();
        countField.setTranslateX(140);
        countField.setTranslateY(10);
        countField.setPrefWidth(50);
        countField.setText("10");

        Label minRadiusLabel = new Label("Минимальный радиус: ");
        minRadiusLabel.setTranslateX(10);
        minRadiusLabel.setTranslateY(40);

        TextField minRadius = new TextField();
        minRadius.setTranslateX(140);
        minRadius.setTranslateY(40);
        minRadius.setPrefWidth(50);
        minRadius.setText("20");

        Label maxRadiusLabel = new Label("Максимальный радиус: ");
        maxRadiusLabel.setTranslateX(10);
        maxRadiusLabel.setTranslateY(70);

        TextField maxRadius = new TextField();
        maxRadius.setTranslateX(140);
        maxRadius.setTranslateY(70);
        maxRadius.setPrefWidth(50);
        maxRadius.setText("30");

        Button generateButton = new Button();
        generateButton.setTranslateX(10);
        generateButton.setTranslateY(110);
        generateButton.setText("Сгенерировать");
        generateButton.setOnMouseClicked(event -> {
            int count = Integer.parseInt(countField.getText());
            int min_radius = Integer.parseInt(minRadius.getText());
            int max_radius = Integer.parseInt(maxRadius.getText());
            if (warning != null){
                warning.clearWarnings();
            }
            clearCircles();
            generateCircles(count, min_radius, max_radius);
        });

        Button redPaintAll = new Button();
        redPaintAll.setTranslateX(10);
        redPaintAll.setTranslateY(140);
        redPaintAll.setText("Залить красным");
        redPaintAll.setOnMouseClicked(event -> {
            paintAll(Color.color(1, 0, 0));
        });

        Button gradientPaintAll = new Button();
        gradientPaintAll.setTranslateX(10);
        gradientPaintAll.setTranslateY(170);
        gradientPaintAll.setText("Градиэнт чёрного");
        gradientPaintAll.setOnMouseClicked(event -> {
            paintAllGradient(Color.color(0, 0, 0));
        });

        root.getChildren().addAll(countField, minRadius, maxRadius, generateButton, redPaintAll, gradientPaintAll);
        root.getChildren().addAll(countFieldLabel, minRadiusLabel, maxRadiusLabel);
    }


    private void clearCircles() {
        if (circles != null && circles.length > 0) {
            root.getChildren().removeAll(circles);
        }
    }


    private void paintAll(Color color) {
        if (circles == null) return;

        for (int i = 0; i < circles.length; i++)
            circles[i].setFill(Paint.valueOf(color.toString()));
    }


    private void paintAllGradient(Color color) {
        if (circles == null) return;
        double red = color.getRed();
        double green = color.getGreen();
        double blue = color.getBlue();
        double step;

        for (int i = 0; i < circles.length; i++) {
            step = (double)i / circles.length;
            circles[i].setFill(Paint.valueOf(Color.color(red + step, green + step, blue + step).toString()));
        }
    }

    private class Warning{
        private Label warningLabel;
        private Pane root;

        public Warning(){
            root = CircleScene.this.root;
            generateWarning();
        }

        private void generateWarning(){
            warningLabel = new Label("Большое количество кругов. Не помещается!");
            warningLabel.setLayoutX(Main.WIDTH/6);
            warningLabel.setLayoutY(Main.HEIGHT/3);
            warningLabel.setFont(new Font("Arial", 30));
            root.getChildren().addAll(warningLabel);
        }


        private void clearWarnings(){
            if (warningLabel != null){
                root.getChildren().removeAll(warningLabel);
            }
        }
    }
}
