package com.IT2650;

interface GenericNode {
    GenericNode deepCopy();
    String toString();
}
public class Legend implements GenericNode{
    private String name, address;


    public Legend() {}

    public Legend(String n, String a) {
        this.name = n;
        this.address = a;
    }

    public Legend deepCopy(){
        return new Legend(name, address);
    }
    @Override
    public String toString() {
        return "Legend{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

}
