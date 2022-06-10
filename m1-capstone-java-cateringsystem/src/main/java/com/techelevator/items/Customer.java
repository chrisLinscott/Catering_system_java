package com.techelevator.items;

import com.techelevator.view.Menu;

import java.util.Map ;


public class Customer {
    private float currentAccountBalance;
    private float startingBalance = 0;
    private Map<String, Integer> shoppingCart;

    private Menu menu;

    public float getCurrentAccountBalance() {
        return currentAccountBalance;
    }



    public float getStartingBalance() {
        return startingBalance;
    }

    public float addMoney(float moneyToAdd) {
        currentAccountBalance = currentAccountBalance + moneyToAdd;
        return currentAccountBalance;
    }

    }

