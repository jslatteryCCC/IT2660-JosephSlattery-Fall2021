package com.IT2650;

public class Stack <T>{
    private T[] data;
    private int top, size;

    public Stack(){
        top = -1;
        size = 100;
        data = (T[]) new Object[100];
    }

    public Stack(int n){
        top = -1;
        size = n;
        data = (T[]) new Object[n];
    }
    public boolean push(T newNode){
        GenericNode node = (GenericNode) newNode;
        if(top == size -1 && !increaseSize(newNode)) return false;
        top++;
        data[top] = (T) node.deepCopy();
        return true;
    }

    public T pop(){
        int topLocation;
        if (top == -1) return null;
        topLocation = top;
        top--;
        return data[topLocation];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return top == size -1;
    }

    public void reinitialize(){
        top = -1;
    }

    public T peek(int n){
        return data[n];
    }

    public void showAll(){
        for(int i = top; i >= 0; i--) {
            System.out.println(data[i].toString() + " is at stack[" + i + "]");
        }
    }

    public boolean increaseSize(T newNode){
        GenericNode node = (GenericNode) newNode;
        T[] temp;
        T[] larger = (T[]) new Object[data.length + 1];
        temp = data;
        data = larger;
        System.arraycopy(temp, 0, larger, 0, temp.length);
        System.arraycopy(larger, 0, data, 0, larger.length);
        temp = null;
        larger = null;
        size = data.length;
        return true;
    }

}
