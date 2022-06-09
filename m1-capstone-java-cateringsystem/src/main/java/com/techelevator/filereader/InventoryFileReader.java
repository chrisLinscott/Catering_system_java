package com.techelevator.filereader;

import com.techelevator.items.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


/*
    This class should contain any and all details of access to the inventory file
 */
public class InventoryFileReader {


    private String inventoryFileName;




    public InventoryFileReader(String inventoryFileName) {
        this.inventoryFileName = inventoryFileName;

    }

    public Map<String, CateringItem> readFileInventory() throws FileNotFoundException {
        Map<String, CateringItem> cateringItemMap = new TreeMap<>();

        File file = new File(inventoryFileName);

        try (Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNext()) {
                String line = fileScanner.nextLine();

                CateringItem cateringItem = makingCateringItemsFromFile(line);
                cateringItemMap.put(cateringItem.getProductCode(), cateringItem);
            }

        }

        return cateringItemMap;
    }

    private CateringItem makingCateringItemsFromFile(String line) {
        CateringItem cateringItem = null;
        String[] parts = line.split("\\|");

        String itemType = parts[0];
        String productCode = parts[1];
        String itemName = parts[2];
        float price = Float.parseFloat(parts[3]);

        if (itemType.equalsIgnoreCase("A")) {
            cateringItem = new Appetizer(itemName, price);
        } else if (itemType.equalsIgnoreCase("B")) {
            cateringItem = new Beverage(itemName, price);
        } else if (itemType.equalsIgnoreCase("D")) {
            cateringItem = new Dessert(itemName, price);
        } else if (itemType.equalsIgnoreCase("E")) {
            cateringItem = new Entree(itemName, price);
        }
        cateringItem.setProductCode(productCode);
        cateringItem.setQuantity(25);

        return cateringItem;
    }

}
