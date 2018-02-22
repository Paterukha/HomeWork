package com.example.HW53.HW53.flowers;

import java.io.FileWriter;


public abstract class FlowersSaver {
    public static void save(String fileName, Flower[] flowers) {
        try {
            FileWriter writer = new FileWriter(fileName);
            for (int i = 0; i < flowers.length - 1; i++){
                writer.write(flowers[i].show() + ",");
            }
            writer.write(flowers[flowers.length-1].show() + "\n");
            writer.flush();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
