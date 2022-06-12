package com.techelevator.items;

/*
    This represents a single catering item in the system
 */
public class CateringItem {
    private String productCode;
    private String itemType;
    private String itemName;
    private int quantity;
    private float price;
    private final int startingQuantity= 25;
    private String messageReminder;

   public CateringItem(String itemName, float price){
       this.itemName=itemName;
       this.price=price;

   }

    public String getMessageReminder() {
        return messageReminder;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getItemType() {
        return itemType;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }
}
