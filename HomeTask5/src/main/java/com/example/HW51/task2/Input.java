package com.example.HW51.task2;

import java.util.Scanner;


public class Input {
    private double x;
    private double y;
    private double radius;
    private String method;

    public Input(){
        getInput();
    }

    private void getInput(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите кординаты X - центра звезды: ");
        x = sc.nextInt();
        sc.nextLine();
        System.out.print("Введите кординаты Y - центра звезды: ");
        y = sc.nextInt();
        sc.nextLine();
        System.out.print("Введите радиус звезды: ");
        radius = sc.nextInt();
        sc.nextLine();
        System.out.println("Выберите метод выведения изображения звезды.");
        System.out.println("1 - Метод1; Другое - Метод2");
        System.out.print("Выберите метод: ");;
        method = sc.nextLine();
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public double getRadius(){
        return radius;
    }

    public String getMethod(){
        return method;
    }
}
