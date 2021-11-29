package com.IT2650;


public class Listing {
    public String lastName;
    public String firstName;
    public String idNumber;
    public String gpa;

    public Listing(String last, String first, String i, String g){
        this.lastName = last;
        this.firstName = first;
        this.idNumber = i;
        this.gpa = g;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return
                "Last Name: " + lastName + " \n" +
                "FirstName: " + firstName + " \n" +
                "IdNumber:" + idNumber + " \n" +
                "GPA: " + gpa ;
    }
    public Listing deepCopy(){
        return new Listing(lastName, firstName, idNumber, gpa);

    }
    public String getKey(){
        return lastName;
    }
}
