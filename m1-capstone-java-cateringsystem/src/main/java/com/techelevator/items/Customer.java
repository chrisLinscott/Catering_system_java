package com.techelevator.items;

import com.techelevator.view.Menu;

import java.util.Map ;


public class Customer {
    private double currentAccountBalance;
    private double startingBalance = 0.0;
    private Map<String, Integer> shoppingCart;

    private Menu menu;

    public double getCurrentAccountBalance() {
        return currentAccountBalance;
    }

    public double getStartingBalance() {
        return startingBalance;
    }

    public double addMoney(double moneyToAdd) {
        currentAccountBalance = currentAccountBalance + moneyToAdd;
        return currentAccountBalance;
    }


}
