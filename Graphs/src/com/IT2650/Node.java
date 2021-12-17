package com.IT2650;

import java.util.ArrayList;

public class Node {
    private int value;
    private ArrayList<Integer> edges;
    boolean dfsVisited;
    boolean bfsVisited;

    public Node(int v){
        this.setValue(v);
        this.edges = new ArrayList<>(1);
    }
    public Node deepCopy(){
        return new Node(getValue());
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public ArrayList<Integer> getAllEdges() {
        return edges;
    }

    public boolean setEdges(int edges) {
        if(this.edges.size() >= 5)
            return false;
        this.edges.add(edges);
        return true;
    }

    public boolean edgeChecker(int incomingEdge) {
        for(int i = 0; i < this.edges.size(); i++){
            if(this.edges.size() == 5 || incomingEdge == this.edges.get(i)){
                return false;
            }
        }
        return true;
    }

    public void setDfsVisited(boolean state){
        dfsVisited = state;
    }

    public void setBfsVisited(boolean state){
        bfsVisited = state;
    }

    public boolean getDfsVisited(){ return dfsVisited; }

    public boolean getBfsVisited(){ return bfsVisited; }
}
