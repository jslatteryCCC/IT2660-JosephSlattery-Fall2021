package com.IT2650;

import java.util.Scanner;

public class CreateItem {

    public Item createItem(){
        Scanner keyboard = new Scanner(System.in);
        Item item = new Item();
        System.out.println("Enter the item name:\n");
        item.setItemName(keyboard.nextLine());
        System.out.println(item.toString());
        return item;
    }
}
