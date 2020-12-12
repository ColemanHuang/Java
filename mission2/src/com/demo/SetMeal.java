package com.demo;

public class SetMeal {
    private String setMealName, friedChickenName;
    private double price;
    private Drinks drinks;

    public SetMeal(String setMealName, String friedChickenName, double price, Drinks drinks) {
        this.setMealName = setMealName;
        this.friedChickenName = friedChickenName;
        this.price = price;
        this.drinks = drinks;
    }

    @Override
    public String toString() {
        return  setMealName  +
                "：" + friedChickenName + "+" + drinks.name +
                " 价格：" + price + "元";
    }

    public Drinks getDrinks() {
        return drinks;
    }
}
