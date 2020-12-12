package com.demo;

import java.time.LocalDate;
import java.util.*;

public class West2FriedChickenRestaurant implements FriedChickenRestaurant {
    private double restaurantBalance;
    private ArrayList<Beer> beerList = new ArrayList<>();
    private ArrayList<Juice> juiceList = new ArrayList<>();
    private static ArrayList<SetMeal> setMealList;
    static {
        LocalDate dateOfProduction = LocalDate.of(2020, 12, 11);
        Beer beer1 = new Beer(5, "天津啤酒", 4.5, dateOfProduction);
        Beer beer2 = new Beer(7, "雪花啤酒", 5.2, dateOfProduction);
        Juice juice1 = new Juice("橙汁", 3.8, dateOfProduction);
        Juice juice2 = new Juice("梨汁", 4.0, dateOfProduction);
        SetMeal setMeal1 = new SetMeal("套餐0", "美式炸鸡", 32.1, beer1);
        SetMeal setMeal2 = new SetMeal("套餐1", "广式炸鸡", 38.9, beer2);
        SetMeal setMeal3 = new SetMeal("套餐2", "韩式炸鸡", 39.9, juice1);
        SetMeal setMeal4 = new SetMeal("套餐3", "泰式炸鸡", 36.0, juice2);
        setMealList = new ArrayList<>(List.of(setMeal1, setMeal2, setMeal3, setMeal4));
    }
    private void use(Beer beer) {
        int index = beerList.indexOf(beer);
        if (index == -1) {
            throw new IngredientSortOutException(beer.name+" 已经卖完了");
        } else {
            while(true) {
                if (!beerList.get(index).isOverdue()) {
                    beerList.remove(beer);
                    index = beerList.indexOf(beer);
                    if (index == -1) {
                        throw new IngredientSortOutException(beer.name+" 已经卖完了");
                    }
                } else {
                    beerList.remove(beer);
                    System.out.println("点餐成功");
                    break;
                }


            }
        }
    }

    private void use(Juice juice) {
        int index = juiceList.indexOf(juice);
        if (index == -1) {
            throw new IngredientSortOutException(juice.name+" 已经卖完了");
        } else {
            while(true) {
                if (!juiceList.get(index).isOverdue()) {
                    juiceList.remove(juice);
                    index = juiceList.indexOf(juice);
                    if (index == -1) {
                        throw new IngredientSortOutException(juice.name+" 已经卖完了");
                    }
                } else {
                    juiceList.remove(juice);
                    System.out.println("点餐成功");
                    break;
                }

            }


        }
    }

    @Override
    public void saleSetMeal() {
        System.out.println("——————————————————————欢迎来到西二炸鸡店——————————————————————");
        System.out.println("套餐：");
        for (SetMeal setMeal : setMealList) {
            System.out.println("    " + setMeal);
        }
        System.out.println("啤酒：");
        for (Beer beer : beerList) {
            System.out.println("    " + beer);
        }
        System.out.println("果汁：");
        for (Juice juice : juiceList) {
            System.out.println("    " + juice);
        }
        System.out.println("点餐请输入相应数字：0——套餐0    1——套餐1  2——套餐2  3——套餐3");
        System.out.println("输入大于3的数字退出");
        Scanner scanner = new Scanner(System.in);
        int setMealNumber = scanner.nextInt();
        while(setMealNumber >= 0 && setMealNumber < 4) {
            SetMeal setMeal = setMealList.get(setMealNumber);
            //Drinks drink = setMeal.getDrinks();

            if (setMeal.getDrinks() instanceof Juice) {
                use((Juice) setMeal.getDrinks());
            } else if (setMeal.getDrinks() instanceof Beer){
                use((Beer) setMeal.getDrinks());
            }
            setMealNumber = scanner.nextInt();
        }
        System.out.println("谢谢惠顾，欢迎下次再来");
    }

    public West2FriedChickenRestaurant(double restaurantBalance) {
        this.restaurantBalance = restaurantBalance;
    }

    @Override
    public void bulkPurchase() {
        LocalDate dateOfProduction = LocalDate.of(2020, 12, 11);
        Beer beer1 = new Beer(5, "天津啤酒", 4.5, dateOfProduction);
        Beer beer2 = new Beer(7, "雪花啤酒", 5.2, dateOfProduction);
        Juice juice1 = new Juice("橙汁", 3.8, dateOfProduction);
        Juice juice2 = new Juice("梨汁", 4.0, dateOfProduction);
        double bill = beer1.cost + beer2.cost + juice1.cost + juice2.cost;
        double budget = restaurantBalance - bill;
        if (budget < 0) {
            throw new OverdraftBalanceException("进货差" + (-budget)+ "元");
        } else {
            System.out.println("进货成功");
            beerList.add(beer1);
            beerList.add(beer2);
            juiceList.add(juice1);
            juiceList.add(juice2);
        }
    }
}
