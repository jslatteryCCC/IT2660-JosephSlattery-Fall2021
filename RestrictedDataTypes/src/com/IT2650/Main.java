package com.IT2650;

import java.awt.desktop.SystemSleepEvent;

public class Main {


    public static void main(String[] args) {

        Stack stack = new Stack(3);
        Object l;
        Legend l1 = new Legend("Octane", "JumpPad");
        Legend l2 = new Legend("Caustic", "Nox Gas Grenade");
        Legend l3 = new Legend("Fuse", "The Mothelode");
        Legend l4 = new Legend("Bloodhound", "Beast of the Hunt");
        Legend l5 = new Legend("Bangalore", "Rolling Thunder");

        stack.push(l1);
        stack.push(l2);
        stack.push(l3);

        stack.showAll();

        l = stack.pop();
        l = stack.pop();
        l = stack.pop();

        System.out.println("\nIs empty: " + stack.isEmpty());

        stack.push(l1);
        stack.push(l2);
        stack.push(l3);
        stack.push(l4);
        System.out.println("\nIs full: " +
                stack.isFull());
        stack.push(l5);

        stack.showAll();
        // write your code here

    }
}
