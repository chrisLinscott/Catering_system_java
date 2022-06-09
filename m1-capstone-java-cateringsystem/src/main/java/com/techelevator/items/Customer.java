package com.techelevator.items;

import java.util.Map;

public class Customer {
    private double currentAccountBalance;
    private double startingBalance= 0.0;
    private Map<String, Integer> shoppingCart;


    public double addMoney(double moneyToAdd){
        currentAccountBalance=currentAccountBalance+moneyToAdd;
        return currentAccountBalance;
    }


}
