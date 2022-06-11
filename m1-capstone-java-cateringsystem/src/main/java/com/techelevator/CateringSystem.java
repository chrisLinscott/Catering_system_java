package com.techelevator;

import com.techelevator.filereader.InventoryFileReader;
import com.techelevator.items.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
    This class should encapsulate all the functionality of the Catering system, meaning it should
    contain all the "work"
 */

public class CateringSystem extends Money {
    //variables from customer class
    private float currentAccountBalance;
    private float startingBalance = 0;

    private InventoryFileReader inventoryFileReader;
    //cateringSystem cannot exist w/out Map
    private Map<String, CateringItem> cateringItemMap = null;
    private CateringSystem cateringSystem;
    Map<String, Integer> shoppingCart = new HashMap<>();
    private int updatedItemCount;
    private CateringItem cateringItem;
    int numberOfFifties;
    int numberOfTwenties;
    int numberOfTens;
    int numberOfFives;
    int numberOfOnes;
    int numberOfQuarters;
    int numberOfDimes;
    int numberOfNickels;

    public int getNumberOfFifties() {
        return numberOfFifties;
    }

    public int getNumberOfTwenties() {
        return numberOfTwenties;
    }

    public int getNumberOfTens() {
        return numberOfTens;
    }

    public int getNumberOfFives() {
        return numberOfFives;
    }

    public int getNumberOfOnes() {
        return numberOfOnes;
    }

    public int getNumberOfQuarters() {
        return numberOfQuarters;
    }

    public int getNumberOfDimes() {
        return numberOfDimes;
    }

    public int getNumberOfNickels() {
        return numberOfNickels;
    }


    public CateringSystem(Map<String, CateringItem> cateringItemMap) {
        // cateringSystem = new CateringSystem(inventoryFileReader.readFileInventory());

    }


    public void readingFileInventory() throws FileNotFoundException {
        inventoryFileReader = new InventoryFileReader("cateringsystem.csv");
        cateringItemMap = inventoryFileReader.readFileInventory();
    }
//    public CateringSystem(Map<String, CateringItem> inventory) {
//        inventoryFileReader.readFileInventory();
//        this.inventory = inventory;


    //methods from customer class
    public float getCurrentAccountBalance() {
        return currentAccountBalance;
    }


    public float getStartingBalance() {
        return startingBalance;
    }

    public void addMoney(Integer moneyToAdd) {
        if (moneyToAdd <= 500 && getCurrentAccountBalance() < 1500)
            currentAccountBalance += moneyToAdd;

    }


    public void addToCart(String itemsProductCode, int quantityDesired) {
        shoppingCart.put(itemsProductCode, quantityDesired);
//            CateringItem item = cateringItemMap.get(itemsProductCode);
//        item.setQuantity(item.getQuantity() - quantityDesired);


    }

    public float updatingBalanceAfterShopping(float itemPrice, int itemQuantity) {
        currentAccountBalance -= (itemPrice * itemQuantity);
        return currentAccountBalance;
    }

//    public void updatingItemQuantityInMap (String itemsProductCode, int quantityDesired) {
//       CateringItem item =cateringItemMap.get(itemsProductCode);
//       item.setQuantity(item.getQuantity()-quantityDesired);
    //    updatedItemCount = cateringItemMap.get(itemsProductCode).getQuantity() - quantityDesired;
     //   cateringItemMap.put(itemsProductCode,)
//    public void updatingItemQuantityInMap (String itemsProductCode, int quantityDesired) {
//        CateringItem item = cateringItemMap.get(itemsProductCode);
//        item.setQuantity(item.getQuantity() - quantityDesired);
    //trying to update map with quantity after purchase
//        updatedItemCount = cateringItemMap.get(itemsProductCode).getQuantity() - quantityDesired;
    //cateringItemMap.put(itemsProductCode, item);}

    public float resetBalance() {
        currentAccountBalance = 0;
        return currentAccountBalance;
    }


    public void makeChange() {
       numberOfFifties = (int) Math.floor(currentAccountBalance / 50);
       currentAccountBalance -= numberOfFifties * 50;
       numberOfTwenties = (int) Math.floor(currentAccountBalance / 20);
       currentAccountBalance -= numberOfTwenties * 20;
       numberOfTens = (int) Math.floor(currentAccountBalance / 10);
       currentAccountBalance -= numberOfTens * 10;
       numberOfFives = (int) Math.floor(currentAccountBalance / 5);
       currentAccountBalance -= numberOfFives * 5;
       numberOfOnes = (int) Math.floor(currentAccountBalance / 1);
       currentAccountBalance -= numberOfOnes * 1;
       numberOfQuarters = (int) Math.floor( currentAccountBalance/ 0.25);
       currentAccountBalance -= numberOfQuarters * 0.25;
       numberOfDimes = (int) Math.floor( currentAccountBalance / 0.10);
       currentAccountBalance -= numberOfDimes * .10;
       numberOfNickels = (int) Math.floor(currentAccountBalance / 0.05);
       currentAccountBalance -= numberOfNickels * 0.05;

//testingtesting
//        float[] bills = new float[]{50, 20, 10, 5, 1, 0.25F, .10F, .05F};
//
//        for (int i = 0; i < bills.length; i++) {
//            float remainderAfterValues = currentAccountBalance % bills[i];
//            float numberOfBills = currentAccountBalance - (remainderAfterValues / bills[i]);
//            currentAccountBalance = remainderAfterValues;

        }


    }









