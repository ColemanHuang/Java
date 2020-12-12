package com.demo;

import java.time.LocalDate;
import java.util.Objects;

public abstract class Drinks {
    protected String name;
    protected double cost;
    protected LocalDate dateOfProduction;
    protected int qualityGuaranteePeriod;

    public Drinks(String name, double cost, LocalDate dateOfProduction, int qualityGuaranteePeriod) {
        this.name = name;
        this.cost = cost;
        this.dateOfProduction = dateOfProduction;
        this.qualityGuaranteePeriod = qualityGuaranteePeriod;
    }

    public boolean isOverdue() {
        LocalDate today = LocalDate.now();
        if (today.isBefore(dateOfProduction.plusDays(qualityGuaranteePeriod))) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public abstract String toString();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drinks drinks = (Drinks) o;
        return Objects.equals(name, drinks.name);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(name);
//    }
}
