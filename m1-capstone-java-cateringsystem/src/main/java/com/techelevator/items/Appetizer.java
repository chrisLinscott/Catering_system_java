package com.techelevator.items;

public class Appetizer extends CateringItem{
    private String itemType = "Appetizer";
    private String messageReminder = "You might need extra plates";


    @Override
    public String getItemType() {
        return itemType;
    }

    public String getMessageReminder() {
        return messageReminder;
    }

    public Appetizer(String itemName, float price) {
     super(itemName, price);

 }}

