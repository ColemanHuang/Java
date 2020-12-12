package com.demo;

import java.time.LocalDate;

public class Beer extends Drinks {
    private float alcoholContent;
    public Beer(float alcoholContent, String name, double price, LocalDate dateOfProduction) {
        super(name, price, dateOfProduction, 30);
        this.alcoholContent = alcoholContent;
    }

    @Override
    public String toString() {
        LocalDate today = LocalDate.now();
        return name +
                " 酒精度数：" + alcoholContent + "°" +
                " 价格：" + cost + "元" ;
    }
}
