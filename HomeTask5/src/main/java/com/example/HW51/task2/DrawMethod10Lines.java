package com.example.HW51.task2;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public class DrawMethod10Lines {
    private double[] vertexesX = new double[2*Main.POLYGON+1];
    private double[] vertexesY = new double[2*Main.POLYGON+1];
    private double[] vertexes_outX = new double[Main.POLYGON+1];
    private double[] vertexes_outY = new double[Main.POLYGON+1];
    private double[] vertexes_inX = new double[Main.POLYGON];
    private double[] vertexes_inY = new double[Main.POLYGON];
    private Pane root;
    double x;
    double y;
    double radius;

    public DrawMethod10Lines(double x, double y, double radius, Pane root){
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.root = root;
        method2();
    }


    private void method2(){

        if (checkSize(x,y,radius)) {


            getVertexesOut(x,y-radius,radius);


            double radius_pentagon = radius * Math.sin(Math.toRadians(Main.SQUARE - Main.CIRCLE/Main.POLYGON))/
                    Math.sin(Math.toRadians(2*Main.SQUARE - Main.CIRCLE/(2*Main.POLYGON) - Main.CIRCLE/(4*Main.POLYGON)));


            getVertexesIn(x,y,radius_pentagon);


            getVertexes();


            root.getChildren().addAll(getLines(vertexesX,vertexesY));
        } else {
            Warning warning = new Warning(root);
            root.getChildren().addAll(warning.generateWarning());
        }
    }

    private boolean checkSize(double x, double y, double radius){
        return ((x - radius > Main.MARGIN) && (x + radius < Main.WIDTH - Main.MARGIN) && (y - radius > Main.MARGIN) && (y + radius < Main.HEIGHT - Main.MARGIN));
    }


    private void getVertexesOut(double x, double y, double radius){
        double deltaX;
        double deltaY;
        vertexes_outX[0] = x;
        vertexes_outY[0] = y;

        for (int i = 1; i < vertexes_outX.length; i++){
            deltaX = radius * Math.cos(Math.toRadians(Main.SQUARE + i*Main.CIRCLE/Main.POLYGON));
            deltaY = radius * (1 - Math.sin(Math.toRadians(Main.SQUARE + i*Main.CIRCLE/Main.POLYGON)));

            vertexes_outX[i] = x + deltaX;
            vertexes_outY[i] = y + deltaY;
        }
    }


    private void getVertexesIn(double x, double y, double radius){
        double deltaX;
        double deltaY;
        vertexes_inX[0] = x + radius * Math.cos(Math.toRadians(Main.SQUARE + Main.CIRCLE/(2*Main.POLYGON)));
        vertexes_inY[0] = y - radius * Math.sin(Math.toRadians(Main.SQUARE + Main.CIRCLE/(2*Main.POLYGON)));

        for (int i = 1; i < vertexes_inX.length; i++){
            deltaX = radius * Math.cos(Math.toRadians(Main.SQUARE + Main.CIRCLE/(2*Main.POLYGON) + i*Main.CIRCLE/Main.POLYGON));
            deltaY = radius * Math.sin(Math.toRadians(Main.SQUARE + Main.CIRCLE/(2*Main.POLYGON) + i*Main.CIRCLE/Main.POLYGON));

            vertexes_inX[i] = x + deltaX;
            vertexes_inY[i] = y - deltaY;
        }
    }



    private void getVertexes(){
        int i_out = 0;
        int i_in = 0;
        for (int i = 0; i < vertexesX.length; i++){
            if (i%2 == 0){
                vertexesX[i] = vertexes_outX[i/2];
                vertexesY[i] = vertexes_outY[i/2];
            } else {
                vertexesX[i] = vertexes_inX[(i-1)/2];
                vertexesY[i] = vertexes_inY[(i-1)/2];
            }
        }
    }


    private Line[] getLines(double[] vX, double[] vY){
        Line[] lines = new Line[vX.length];
        for (int i = 0; i < lines.length-1; i++){
            lines[i] = new Line(vX[i], vY[i], vX[i+1], vY[i+1]);
        }

        lines[lines.length-1] = new Line(vX[vX.length-1], vY[vX.length-1], vX[0], vY[0]);
        return lines;
    }




    private Line[] generatePentagon(double x, double y, double radius){
        Line[] lines = new Line[Main.POLYGON];
        double deltaX;
        double deltaY;
        double x_old = x + radius * Math.cos(Math.toRadians(Main.SQUARE + Main.CIRCLE/(2*Main.POLYGON)));
        double y_old = y - radius * Math.sin(Math.toRadians(Main.SQUARE + Main.CIRCLE/(2*Main.POLYGON)));

        System.out.println(x_old + "     " + y_old);

        for (int i = 0; i < lines.length; i++){
            deltaX = radius * Math.cos(Math.toRadians(Main.SQUARE + Main.CIRCLE/(2*Main.POLYGON) + (i+1)*Main.CIRCLE/Main.POLYGON));
            deltaY = radius * Math.sin(Math.toRadians(Main.SQUARE + Main.CIRCLE/(2*Main.POLYGON) + (i+1)*Main.CIRCLE/Main.POLYGON));

            lines[i] = new Line(x_old,
                    y_old,
                    x + deltaX,
                    y - deltaY);
            x_old = x + deltaX;
            y_old = y - deltaY;
            System.out.println(x_old + "     " + y_old);
        }
        return lines;
    }

}
