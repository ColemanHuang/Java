package com.demo;

import java.time.LocalDate;

public class Juice extends Drinks {
    public Juice(String name, double price, LocalDate date) {
        super(name, price, date, 2);
    }

    @Override
    public String toString() {
        LocalDate today = LocalDate.now();
        return name + " 价格：" + cost + "元";
    }
}
