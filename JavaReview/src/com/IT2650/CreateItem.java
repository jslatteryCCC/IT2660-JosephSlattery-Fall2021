package com.IT2650;
import java.util.Scanner;

public class CreateItem {
    private String itemName;
    private double itemPrice;
    private Scanner keyboard = new Scanner(System.in);

    public CreateItem() {
        setItemName();
        setItemPrice();
    }

    public void setItemName(){
        System.out.println("What is the item's name?:");
        itemName = keyboard.nextLine();
    }
    public String getItemName() {
        return itemName;
    }

    public void setItemPrice() {
        System.out.println("What's the price?:");
        itemPrice =  keyboard.nextDouble();
    }
    public double getItemPrice() {
        return itemPrice;
    }

    @Override
    public String toString() {
        return "itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice;
    }
}
