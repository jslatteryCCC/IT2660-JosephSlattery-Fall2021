package com.IT2650;

public class Main {

    public static void main(String[] args) {

	// write your code here
    Node root = new Node("Octane");
    root.setNext(new Node("Wraith"));
    root.getNext().setNext(new Node("Bangalore"));
    root.showAll(root);

    root = root.insertNodeAtPosition(new Node("Bloodhound"), 2);
    root.showAll(root);

    root = root.insertNodeAtPosition(new Node("Fuse"), 4);
    root.showAll(root);

    root = root.insertNodeAtPosition(new Node("Horizon"), 0);
    root.showAll(root);
    }
}
