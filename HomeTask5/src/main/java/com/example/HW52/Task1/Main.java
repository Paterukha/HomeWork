package com.example.HW52.Task1;


import com.example.HW52.Task1.players.*;


public class Main {

    public static void main(String[] args) {
        Player1 player1 = new Player1(45, "Invisible Man");
        Player2 player2 = new Player2(55, "Boat On The River");
        String[] playlist3 = {"Brothers In Arms", "Money For Nothing"};
        Player3 player3 = new Player3(75, playlist3);
        String[] playlist4 = {"Sunrise", "July Morning"};
        Player4 player4 = new Player4(95, playlist4);
        String[] playlist5 = {"Back In Black", "Highway To Hell"};
        Player5 player5 = new Player5(105, playlist5);
        String[] playlist6 = {"Freebird", "Sweet Home Alabama", "Tuesday's Gone"};
        Player6 player6 = new Player6(115, playlist6);

        System.out.println("player1");
        System.out.println("Price : " + player1.getPrice());
        player1.playSong(player1.getSong());
        System.out.println();
        System.out.println("player2");
        System.out.println("Price : " + player2.getPrice());
        player2.playSong(player2.getSong());
        System.out.println();
        System.out.println("player3");
        System.out.println("Price : " + player3.getPrice());
        player3.playSong();
        player3.playAllSongs();
        System.out.println();
        System.out.println("player4");
        System.out.println("Price : " + player4.getPrice());
        player4.playSong();
        player4.playAllSongs();
        System.out.println();
        System.out.println("player5");
        System.out.println("Price : " + player5.getPrice());
        player5.playSong();
        player5.playAllSongs();
        System.out.println();
        System.out.println("player6");
        System.out.println("Price : " + player6.getPrice());
        player6.playSong();
        player6.playAllSongs();
        player6.shuffle();
    }
}
