package com.techelevator;

import com.techelevator.filereader.InventoryFileReader;
import com.techelevator.items.CateringItem;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

/*
    This class should encapsulate all the functionality of the Catering system, meaning it should
    contain all the "work"
 */

public class CateringSystem {
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
    }

    public float updatingBalanceAfterShopping(float itemPrice, int itemQuantity) {
        currentAccountBalance -= (itemPrice * itemQuantity);
        return currentAccountBalance;
    }
    public void updatingItemQuantityInMap (String itemsProductCode, int quantityDesired) {
       CateringItem item =cateringItemMap.get(itemsProductCode);
       item.setQuantity(item.getQuantity()-quantityDesired);
    //    updatedItemCount = cateringItemMap.get(itemsProductCode).getQuantity() - quantityDesired;
     //   cateringItemMap.put(itemsProductCode,)

    }
}




