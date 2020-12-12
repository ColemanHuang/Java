package com.demo;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        West2FriedChickenRestaurant west2FriedChickenRestaurant = new West2FriedChickenRestaurant(1000);
        west2FriedChickenRestaurant.bulkPurchase();
        west2FriedChickenRestaurant.saleSetMeal();
//        Beer beer1 = new Beer(5, "天津啤酒", 4.5, today);
//        Beer beer2 = new Beer(7, "雪花啤酒", 5.2, today);
//        ArrayList<Beer> beers = new ArrayList<>(List.of(beer1, beer2));
////        for (Beer beer : beers) {
////            System.out.println(beer);
////        }
//        Beer beer3 = new Beer(3, "雪花啤酒", 1.5, today);
//        int index = beers.indexOf(beer3);
//
//        //System.out.println(beers.get(index));
//        Beer item = beers.get(index);
//        beers.remove(index);
//        for (Beer beer : beers) {
//            System.out.println(beer);
//        }
    }
}
