package com.IT2650;

import java.util.ArrayList;
import java.util.Objects;

public class Node {

    private String lastName;
    private String firstName;
    private String idNumber;
    private String gpa;
    private Node leftChild;
    private Node rightChild;

    public Node(Listing listing) {
        this.lastName = listing.lastName;
        this.firstName = listing.firstName;
        this.idNumber = listing.idNumber;
        this.gpa = listing.gpa;
    }

    public Node(ArrayList<Listing> studentList) {
        int length = studentList.size();
        int median = length / 2;

        switch (length) {
            case 1:
                this.lastName = studentList.get(0).lastName;
                this.firstName = studentList.get(0).firstName;
                this.idNumber = studentList.get(0).idNumber;
                this.gpa = studentList.get(0).gpa;
                return;
            case 2:
                Listing low = studentList.get(0);
                Listing high = studentList.get(1);
                this.lastName = high.lastName;
                this.firstName = high.firstName;
                this.idNumber = high.idNumber;
                this.gpa = high.gpa;
                this.leftChild = new Node(low);
            default:
                ArrayList<Listing> leftArray = new ArrayList<>(studentList.subList(0, median));
                ArrayList<Listing> rightArray = new ArrayList<>(studentList.subList(median + 1, studentList.size()));
                if (leftArray.size() > 0) this.leftChild = new Node(leftArray);
                this.lastName = studentList.get(median).lastName;
                this.firstName = studentList.get(median).firstName;
                this.idNumber = studentList.get(median).idNumber;
                this.gpa = studentList.get(median).gpa;
                if (rightArray.size() > 0) this.rightChild = new Node(rightArray);
        }

    }

    public Node search(String ln, Node node) {
        ln = ln.toLowerCase();
        try {
            if (Objects.equals(ln, node.lastName.toLowerCase())) {
                System.out.println(node.lastName + ", " + node.firstName +
                        "\n ID: " + node.idNumber + "\nGPA: " + node.gpa + "\n");
                return node;
            }
            if (ln.compareTo(node.lastName.toLowerCase()) < 0) {
                search(ln, node.leftChild);
            }
            if (ln.compareTo(node.lastName.toLowerCase()) > 0) {
                search(ln, node.rightChild);
            }
        } catch (NullPointerException n) {
            System.out.println("Student not found.\n");
        } return null;
    }

    @Override
    public String toString() {
        return "\n" + lastName + ": " +
                "leftChild = " + leftChild + "\n" +
                "rightChild = " + rightChild;
    }
}
