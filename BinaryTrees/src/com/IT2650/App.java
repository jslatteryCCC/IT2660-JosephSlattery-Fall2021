package com.IT2650;

import java.util.*;

public class App {
    public StudentList studentList = new StudentList();
    public Listing student1 = new Listing("Waldo", "Ralph", "s00441111", "4.0");
    public Listing student2 = new Listing("Eyre", "Jane", "s00343278", "3.8");
    public Listing student3 = new Listing("Sangiacomo-Jones", "Rocco", "s15393849", "2.9");
    public Listing student4 = new Listing("Hones", "Billy", "s00000042", "1.8");
    public Listing student5 = new Listing("Bing", "Chandler", "s00353933", "2.9");
    public Listing student6 = new Listing("Richalds", "Chim", "s02583987", "4.0");
    public Listing student7 = new Listing("Geller", "Ross", "s03816543", "3.1");
    public Listing[] startingList = {student1, student2, student3, student4, student5, student6,student7};
    public Node studentNodes;
    Scanner keyboard = new Scanner(System.in);

    public void initializeList(){
        studentList.addAll(startingList);
    }
    public void sort(){
        studentList.sort();
    }

    public void descendingOutput(){
        Comparator<Listing> lastNameComparator = Comparator.comparing(Listing::getLastName);
        ArrayList<Listing> bottomUpList = studentList.list;
        bottomUpList.sort(Collections.reverseOrder(lastNameComparator));
        bottomUpList.forEach(student -> System.out.println(
            "Last name: " + student.lastName + "\n" +
            "First name: " + student.firstName + "\n" +
            "ID Number: " + student.idNumber + "\n" +
            "Current GPA: " + student.gpa + "\n"
        ));
    }
/*    public void Output(){
        studentList.list.forEach(student -> System.out.println(
                "Last name: " + student.lastName + "\n" +
                        "First name: " + student.firstName + "\n" +
                        "ID Number: " + student.idNumber + "\n" +
                        "Current GPA: " + student.gpa + "\n"
        ));
    }*/
    public void choiceSwitch(int i){
        if(i < 0 || i > 6){
            System.out.println("Select from given choices or 6 to exit.");
            user();
        }
        switch (i) {
            case 1:
                studentList.addToList(createNew());
                sort();
                createNodes();
                user();
            case 2:
                viewRecord();
                user();
            case 3:
                deleteRecord();
                createNodes();
                user();
            case 4:
                deleteRecord();
                studentList.addToList(createNew());
                sort();
                createNodes();
                user();
            case 5:
                descendingOutput();
                //System.out.println(studentNodes.toString() + "\n");
                user();
            case 6:
                System.out.println("Exiting...");
                System.exit(0);
        }

    }
    public void user() {
        System.out.println("Make a selection: ");
        System.out.println("""
                1: Create a new student record
                2: View a student's information
                3: Delete a student record
                4: Update a student record
                5: Print ALL student records
                6: Exit the program
                """);
        try {
            choiceSwitch(keyboard.nextInt());
        } catch (InputMismatchException e) {
            keyboard.next();
            System.out.println("Select from given choices or 6 to exit.");
            user();
        }
    }

    public void createNodes(){
        studentNodes = new Node(studentList.list);
        //return studentNodes;
    }

    public Listing createNew(){
        String first, last, id, gpa;
        System.out.println("Enter the student's last name: ");
        last = keyboard.next();
        System.out.println("Enter the student's first name: ");
        first = keyboard.next();
        System.out.println("Enter the student's ID Number: ");
        id = keyboard.next();
        System.out.println("Enter the student's current GPA: ");
        gpa = keyboard.next();
        System.out.println("New student added.");
        return new Listing(last, first, id, gpa);
    }
    public void viewRecord(){
        String entry;
        System.out.println("Enter the student's last name to see record: ");
        entry = keyboard.next();
        studentNodes.search(entry, studentNodes);
        //studentList.fetch(entry);
    }

    public void deleteRecord(){
        String entry;
        int decision;
        System.out.println("Enter the ID number of the student to delete: ");
        entry = keyboard.next();
        if(studentList.fetch(entry)) {
            System.out.println("""
                    Is this the correct entry?\s
                    Enter:\s
                    '1' for YES\s
                    '2' for NO\s
                    '3' to return to menu.""");
        } else user();
        decision = keyboard.nextInt();
        if (decision == 1) {
            studentList.delete(entry);
            System.out.println("Record deleted.");
        }
        if (decision == 2 || decision == -1) {
            System.out.println("Returning to delete options.");
            deleteRecord();
        }
        if (decision == 3) {
            System.out.println("Returning to main menu.");
            user();
        }
    }
}
