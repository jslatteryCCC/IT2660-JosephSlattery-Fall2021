package com.IT2650;

public class Node {
    private String value;
    private Node next;
    public Node(String value){ this.value = value; }
    public Node getNext(){ return this.next; };
    public void setNext(Node node){ this.next = node; }

    private Node getNodeAtPosition(int position){
        Node walker = this;
        for(int i = 0; i < position; i++){
            walker = walker.getNext();
        }
        return walker;
    }

    public Node insertNodeAtPosition(Node newNode, int position){
        if (position == 0) {return newRoot(newNode);};
        if (position == getListSize()){ return append(newNode); };
        Node previousNode = getNodeAtPosition(position -1);
        newNode.setNext(previousNode.getNext());
        previousNode.setNext(newNode);
        return this;
    }

    private int getListSize(){
        int size = 1;
        Node walker = this;
        while(walker.getNext() != null) {
            walker = walker.getNext();
            size++;
        }
        return size;
    }

    private Node newRoot(Node newNode){
        newNode.setNext(this);
        return newNode;
    }
    private Node append(Node newNode){
        Node lastNode = getNodeAtPosition(getListSize() - 1);
        lastNode.setNext(newNode);
        return this;
    }

    public void showAll(Node node){
        for (int i = 0; node != null; i++){
            System.out.println(node.value);
            node = node.next;
        }
        System.out.println("---end list---\n");
    }
    @Override
    public String toString() {
        return "Node{" +
                "value='" + value;
    }
}

/*create Node object - String value, Node next
 * constructor takes value
 * getNext method returns node at this.next
 * setNext method takes Node node and sets this.next to node
 * getNodeAtPosition takes int position:
 *   -creates walker node and sets it to calling node (root, position 0)
 *   -sets walker to walker.getNext while i < desired position
 *   -returns walker, a copy of node at desired position
 * insertNodeAtPosition takes Node newNode, int position:
 *   -creates previousNode by calling getNodeAtPosition(position - 1)
 *   -newNode setNext takes value of previousNode getNext
 *   -previousNode setNext becomes newNode
 *   -*/