package com.example.HW52.Task2;

import java.util.Scanner;


public class Input {

    private String player;

    public Input(){
        getInput();
    }

    private void getInput(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Какой плеер нарисовать?");
        System.out.print("Введите от 1 до 6 для выбора плеера: ");;
        player = sc.nextLine();
    }

    public String getPlayer(){
        return player;
    }
}
