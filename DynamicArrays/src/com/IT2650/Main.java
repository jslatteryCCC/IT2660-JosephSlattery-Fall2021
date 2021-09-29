package com.IT2650;
/*
Took me awhile to get the resizing right - it's only in the insert function currently. I think making
it into a separate function that will check the size/resize the array, and then calling that function from
within each operation method would be the way to go.
 */

public class Main {

    public static void main(String[] args) {

        StudentArray studentArray1 = new StudentArray(1);
        StudentListings student1 = new StudentListings("Bill", "1", "3.1");
        StudentListings student2 = new StudentListings("Rocco", "2", "2.7");
        StudentListings student3 = new StudentListings("Larry", "3", "4.0");
        StudentListings student4 = new StudentListings("Rodrigo", "4", "2.3");
        StudentListings student5 = new StudentListings("Esmerelda", "5", "3.5");
        studentArray1.insert(student1);
        System.out.println(studentArray1.students.length);
        studentArray1.insert(student2);
        System.out.println(studentArray1.students.length);
        studentArray1.insert(student3);
        System.out.println(studentArray1.students.length);
        studentArray1.insert(student4);
        System.out.println(studentArray1.students.length);
        studentArray1.insert(student5);
        System.out.println(studentArray1.students.length);

        studentArray1.showAll();
        System.out.println("\n");

        studentArray1.update("4", new StudentListings("McLovin'", "4", "3.0"));
        studentArray1.showAll();
        System.out.println("\n");
        StudentListings temp = studentArray1.fetch("3");
        System.out.println(temp);
        System.out.println("\n");
        studentArray1.delete("3");
        studentArray1.showAll();
    }
}


        /*
        int i = 0;
        while(i < studentArray1.students.length){
            StudentListings student = new StudentListings();
            student.input();
            studentArray1.insert(student);
            i++;
        }
        */