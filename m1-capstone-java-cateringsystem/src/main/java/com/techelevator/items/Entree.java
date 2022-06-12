package com.techelevator.items;

public class Entree extends CateringItem{
    private String itemType = "Entree";
    private String messageReminder = "Did you remember dessert?";
    public Entree(String itemName, float price) {
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

