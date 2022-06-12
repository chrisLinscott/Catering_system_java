package com.techelevator.items;

public class Dessert extends CateringItem{
    private String itemType = "Dessert";
    private String messageReminder = "Coffee goes with dessert";
    public Dessert(String itemName, float price) {


        super(itemName, price);}

    @Override
    public String getItemType() {
        return itemType;
    }

    public String getMessageReminder() {
        return messageReminder;
    }
}
