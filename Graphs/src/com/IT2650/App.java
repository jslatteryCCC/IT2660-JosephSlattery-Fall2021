package com.IT2650;

import java.util.Scanner;

public class App {
    Scanner keyboard = new Scanner(System.in);
    public Graph g;
    public int graphSize, start, target;


    public App() {
        initGraph();
        chooseNodes();
        chooseOperation();
    }

    public void initGraph() {
        String oorMsg = "Input must be a number between 1 - 1000.";
        try {
            System.out.println("Let's make some nodes!!");
            System.out.println("Define graph size between 1 - 1000: ");
            graphSize = keyboard.nextInt();
            if (graphSize > 0 && graphSize <= 1000) {
                g = new Graph(graphSize);
            } else {
                System.out.println(oorMsg);
                initGraph();
            }
        } catch (Exception e) {
            keyboard.next();
            System.out.println(oorMsg);
            initGraph();
        }
    }
    public void chooseOperation(){
        try {
            System.out.println("Make a selection: ");
            System.out.println("""
                    1: Output sequence of depth first traversal.
                    2: Output sequence of breadth first traversal.
                    3: Output both
                    4: Exit
                    """);
            choiceSwitch(keyboard.nextInt());
        } catch (Exception e) {
            keyboard.next();
            System.out.println("Select from given choices or press 4 to exit.");
            chooseOperation();
        }
    }
    public void chooseNodes(){
        try {
            System.out.println("Enter a start node between 1 and " + graphSize);
            start = keyboard.nextInt();
            if(start < 0 || start > graphSize){
                chooseNodes();
            }
            System.out.println("Enter a target node between 1 and " + graphSize);
            target = keyboard.nextInt();
            if(target < 0 || target > graphSize){
                chooseNodes();
            }
        } catch (Exception e){
            keyboard.next();
            System.out.println("Numbers between 1 and " + graphSize + " only.\n");
            chooseNodes();
        }
    }
    public void choiceSwitch(int i){
        if(i < 1 || i > 4){
            System.out.println("Select from given choices or press 4 to exit.");
            chooseOperation();
        }
        switch (i) {
            case 1 -> {
                g.showAll();
                g.depth(start, target);
            }
            case 2 -> {
                g.showAll();
                g.breadth(start, target);
            }
            case 3 -> {
                g.showAll();
                g.breadth(start, target);
                g.depth(start, target);
            }
            case 4 -> {
                System.out.println("\nExiting.\n");
                System.exit(0);
            }

        }
    }
}
