package com.example.HW53.HW53.flowers;


public class FlowerStore {
    private Flower flower;
    private Rose rose;
    private Chamomile chamomile;
    private Tulip tulip;
    private double cash;

    public FlowerStore(){
        cash = 0;
    }

    public Flower[] sell(int rose_count, int chamomile_count, int tulip_count){
        int flower_count = rose_count + chamomile_count + tulip_count;
        Flower[] result = new Flower[flower_count];
        for (int i = 0; i < rose_count; i++){
            rose = new Rose();
            result[i] = rose;
            cash += rose.getPrice();
        }
        for (int i = 0; i < chamomile_count; i++){
            chamomile = new Chamomile();
            result[rose_count + i] = chamomile;
            cash += chamomile.getPrice();
        }
        for (int i = 0; i < tulip_count; i++){
            tulip = new Tulip();
            result[rose_count + chamomile_count + i] = tulip;
            cash += tulip.getPrice();
        }
        return result;
    }

    public Flower[] sellSequence(int rose_count, int chamomile_count, int tulip_count){
        int flower_count = rose_count + chamomile_count + tulip_count;
        Flower[] result = new Flower[flower_count];
        int k;
        for (int i = 0; i < flower_count; i += k){
            k = 0;
            if (rose_count > 0){
                result[i] = new Rose();
                rose_count--;
                k++;
                cash += rose.getPrice();
            }
            if (chamomile_count > 0){
                result[i+k] = new Chamomile();
                chamomile_count--;
                k++;
                cash += chamomile.getPrice();
            }
            if (tulip_count > 0){
                result[i+k] = new Tulip();
                tulip_count--;
                k++;
                cash += tulip.getPrice();
            }
        }
        return result;
    }

    public double getCash(){
        return cash;
    }
}
