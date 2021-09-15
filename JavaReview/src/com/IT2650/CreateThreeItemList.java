package com.IT2650;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CreateThreeItemList {
    Boolean isPeas;
    double itemListTotal;
    int listCount = 0;

    List<Object> itemList = new ArrayList<>();

    public CreateThreeItemList() {
        listMaker();
    }


    public void listMaker() {
        isPeas = false;
        while (listCount < 3) {
            CreateItem newItem = new CreateItem();
            addItemsToList(newItem);
            itemListTotal += newItem.getItemPrice();
            listCount++;
            if (newItem.getItemName().equalsIgnoreCase("peas")) {
                isPeas = true;
            }
        }
        if(isPeas) {
            infoBox(toString(), average());
        }
        else infoBox(toString(), "");
    }
    public void addItemsToList(Object item) {
        itemList.add(item);
    }
    public List<Object> getItemList() {
        return itemList;
    }

    @Override
    public String toString() {
        return "CreateThreeItemList{" +
                "itemList=" + itemList +
                '}';
    }

    public String average() {
            return "The average item price is " + itemListTotal/listCount;
    }



    public static void infoBox(String infoMessage, String titleBar) {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
}



