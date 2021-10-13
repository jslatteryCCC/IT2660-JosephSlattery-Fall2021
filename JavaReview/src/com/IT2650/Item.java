package com.IT2650;

public class Item {
    private String itemName;
    private double itemPrice;

    public Item(String itemName, double itemPrice){
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }
    public Item(){};
    public String getItemName() {
        return this.itemName;
    }
    public double getItemPrice() {
        return this.itemPrice;
    }
    public void setItemName(String userEnteredName) {
        this.itemName = userEnteredName;
    }

    public void setItemPrice(double userEnteredPrice){
        this.itemPrice = userEnteredPrice;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                '}';
    }
}
