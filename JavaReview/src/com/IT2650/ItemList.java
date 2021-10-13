package com.IT2650;

public class ItemList{

    private Item[] list;

    public ItemList(Item firstItem) {
        this.list = new Item[1];
        this.list[0] = firstItem;
    }

    public void print() {
        for (Item item: this.list){
            System.out.println(item.getItemName() + " " + item.getItemPrice());
            System.out.println();
        }
    }

    public void insert(Item item, int listPosition){

        if (this.list.length == 0 && listPosition == 0){
            this.list = new Item [1];
            this.list[0] = item;
        }

        if (listPosition < 0 || listPosition > this.list.length ) {
            return;
        }

        Item[] newList = new Item[this.list.length + 1];

        for (int i = 0; i < this.list.length + 1; i++){
            if(i < listPosition){
                newList[i] = this.list[i];
            }
            else if (i > listPosition) {
                newList[i] = this.list[i - 1];
            }
            else {
                newList[i] = item;
            }
        }
        this.list = newList;
    }


}



