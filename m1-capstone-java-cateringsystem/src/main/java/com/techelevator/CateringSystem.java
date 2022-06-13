package com.techelevator;

import com.techelevator.filereader.InventoryFileReader;
import com.techelevator.filereader.LogFileWriter;
import com.techelevator.items.*;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
    private Map<String, CateringItem> cateringItemMap;
    private CateringSystem cateringSystem;
    Map<String, Integer> shoppingCart = new HashMap<>();
    private LogFileWriter logFileWriter = new LogFileWriter();
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

public CateringSystem(){}

    public CateringSystem(Map<String, CateringItem> cateringItemMap) {
        this.cateringItemMap = cateringItemMap;


    }



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

    public Map<String, CateringItem> getCateringItemMap() {
        return cateringItemMap;
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
        logFileWriter.moneyAdded(moneyToAdd, currentAccountBalance);


    }


    public void addToCart(String itemsProductCode, int quantityDesired) {
        shoppingCart.put(itemsProductCode, quantityDesired);
        CateringItem item = cateringItemMap.get(itemsProductCode);
        item.setQuantity(item.getQuantity() - quantityDesired);
        logFileWriter.itemBought( item.getItemName(), (item.getPrice() * quantityDesired),quantityDesired, itemsProductCode, currentAccountBalance );


    }

    public float updatingBalanceAfterShopping(float itemPrice, int itemQuantity) {
        currentAccountBalance -= (itemPrice * itemQuantity);
        return currentAccountBalance;
    }

    public int getQuantity(String productCode) {

        return this.getCateringItemMap().get(productCode).getQuantity();

    }

    //array of arrays....size of cart...number of variables each item has in receipt
    public String[][] getShoppingCart() {
        String[][] receiptArrayToPrint = new String[shoppingCart.size()][6];
        int i = 0;
        for (Map.Entry<String, Integer> entry : shoppingCart.entrySet()) {
            String[] itemsAddedToReceipt = new String[6];
            //gets value of item it cart
            itemsAddedToReceipt[0] = String.valueOf(entry.getValue());
            itemsAddedToReceipt[1] = cateringItemMap.get(entry.getKey()).getItemType();
            itemsAddedToReceipt[2] = cateringItemMap.get(entry.getKey()).getItemName();
            itemsAddedToReceipt[3] = String.format("%.2f",cateringItemMap.get(entry.getKey()).getPrice());
            itemsAddedToReceipt[4] = String.format("%.2f", cateringItemMap.get(entry.getKey()).getPrice() * entry.getValue());
            itemsAddedToReceipt[5] = cateringItemMap.get(entry.getKey()).getMessageReminder();

            receiptArrayToPrint[i] = itemsAddedToReceipt;
            i++;

        }


        return receiptArrayToPrint;
    }


    public float resetBalance() {
        currentAccountBalance = 0;
        return currentAccountBalance;
    }


        // testing change options // linked hashmap does order of insertion
    public Map<Float, Integer> makeChange (float currentAccountBalance) {
        Map<Float, Integer> billMap = new LinkedHashMap<>();
        float[] bills = new float[]{50, 20, 10, 5, 1, 0.25F, .10F, .05F};
        {
            float remainderAfterValues = 0;
            logFileWriter.givingChange(currentAccountBalance, 0);

            for (int i = 0; i < bills.length; i++) {
                remainderAfterValues = currentAccountBalance % bills[i];
                float numberOfBills = (currentAccountBalance - remainderAfterValues) / bills[i];
                currentAccountBalance = remainderAfterValues;
                billMap.put(bills[i], (int) numberOfBills);


            }

            resetBalance();


            return billMap;
        }
    }
}









