package com.techelevator;

import com.techelevator.filereader.InventoryFileReader;
import com.techelevator.items.CateringItem;
import com.techelevator.view.Menu;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.TreeMap;

/*
    This class should encapsulate all the functionality of the Catering system, meaning it should
    contain all the "work"
 */

public class CateringSystem {
    //variables from customer class
    private float currentAccountBalance;
    private float startingBalance = 0;
    private Map<String, Integer> shoppingCart;

    //cateringSystem cannot exist w/out Map
    private Map<String, CateringItem> inventory;

    public CateringSystem(Map<String, CateringItem> inventory) {
        this.inventory = inventory;
    }

    //methods from customer class
    public float getCurrentAccountBalance() {
        return currentAccountBalance;
    }


    public float getStartingBalance() {
        return startingBalance;
    }

    public void addMoney(float moneyToAdd) {
        if (moneyToAdd <= 500 && getCurrentAccountBalance() < 1500)
            currentAccountBalance += moneyToAdd;

    }

    public Map<String, Integer> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(Map<String, Integer> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }


}



