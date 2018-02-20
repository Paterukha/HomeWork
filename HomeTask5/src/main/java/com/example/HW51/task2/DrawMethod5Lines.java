package com.example.HW51.task2;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;


public class DrawMethod5Lines {
    private Pane root;
    double x;
    double y;
    double radius;

    public DrawMethod5Lines(double x, double y, double radius, Pane root){
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.root = root;
        method1();
    }


    private void method1(){


        if (checkSize(x,y,radius)) {
            root.getChildren().addAll(generateLines(x,y-radius,radius));
        } else {
            Warning warning = new Warning(root);
            root.getChildren().addAll(warning.generateWarning());
        }
    }

    private boolean checkSize(double x, double y, double radius){
        return ((x - radius > Main.MARGIN) && (x + radius < Main.WIDTH - Main.MARGIN) && (y - radius > Main.MARGIN) && (y + radius < Main.HEIGHT - Main.MARGIN));
    }


    private Line[] generateLines(double x, double y, double radius){
        Line[] lines = new Line[Main.POLYGON];
        double deltaX;
        double deltaY;
        double x_old = x;
        double y_old = y;
        for (int i = 0; i < lines.length; i++){
            deltaX = radius * Math.cos(Math.toRadians(Main.SQUARE + (i+1)*2*Main.CIRCLE/Main.POLYGON));
            deltaY = radius * (1 - Math.sin(Math.toRadians(Main.SQUARE + (i+1)*2*Main.CIRCLE/Main.POLYGON)));

            lines[i] = new Line(x_old,
                    y_old,
                    x + deltaX,
                    y + deltaY);
            x_old = x + deltaX;
            y_old = y + deltaY;
        }
        return lines;
    }
}
