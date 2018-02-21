package com.example.HW52.Task1.players;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class Player6 extends Player3 {
    public Player6(double price, String[] playlist) {
        super(price, playlist);
    }

    public void shuffle(){
        shuffleArray(playlist);
        System.out.println("Playing shuffle playlist.");
        super.playAllSongs();
    }

    void shuffleArray(String[] ar)
    {

        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);

            String a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }
}
