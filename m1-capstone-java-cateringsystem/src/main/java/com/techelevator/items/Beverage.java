package com.techelevator.items;

public class Beverage extends  CateringItem{

    private String itemType = "Beverage";
    private String messageReminder = "Don't forget ice!";
    public Beverage(String itemName, float price) {
        super(itemName, price);

    }

    @Override
    public String getItemType() {
        return itemType;
    }

    public String getMessageReminder() {
        return messageReminder;
    }
}
