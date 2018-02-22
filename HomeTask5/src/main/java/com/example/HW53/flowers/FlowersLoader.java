package com.example.HW53.HW53.flowers;

import java.io.BufferedReader;
import java.io.FileReader;


public abstract class FlowersLoader extends FlowersSaver {
    public static Flower[] load(String fileName) {
        try {
            FileReader reader = new FileReader(fileName);
            BufferedReader br = new BufferedReader(reader);

            String delims = "[,]";

            String line = br.readLine();
            String[] elements = line.split(delims);

            Flower[] resultArray = new Flower[elements.length];

            for(int i = 0; i < resultArray.length; i++) {
                switch (elements[i]){
                    case "rose":
                        resultArray[i] = new Rose();
                        break;
                    case "chamomile":
                        resultArray[i] = new Chamomile();
                        break;
                    case "tulip":
                        resultArray[i] = new Tulip();
                        break;
                    default:
                        resultArray[i] = new Rose();
                        break;
                }
            }
            return resultArray;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
