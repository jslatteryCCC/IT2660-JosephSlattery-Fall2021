package com.IT2650;

import javax.swing.*;

public class StudentListings {
    private String name;
    private String idNumber;
    private String gpa;

    public StudentListings(String name, String idNumber, String gpa) {
        this.name = name;
        this.idNumber = idNumber;
        this.gpa = gpa;
    }
    public StudentListings(){}

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", idNumber=" + idNumber +
                ", gpa=" + gpa +
                '}';
    }
    public StudentListings deepCopy(){
        return new StudentListings(name, idNumber, gpa);
    }
    public int compareTo(String targetKey) {
        return idNumber.compareTo(targetKey);
    }
    public void input() {
        name = JOptionPane.showInputDialog("Enter a name: ");
        idNumber = JOptionPane.showInputDialog("Enter ID number: ");
        gpa = JOptionPane.showInputDialog("Enter G.P.A.: ");
        int i = 0;

    }
    /*
    public String getName() {
        return this.name;
    }
    public String getIdNumber() {
        return this.idNumber;
    }
    public String getGpa() {
        return this.gpa;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
    public void setGpa(String gpa) {
        this.gpa = gpa;
    }

     */
}
