package com.IT2650;

import java.util.*;

public class StudentList {

    public ArrayList<Listing> list = new ArrayList<>();

    public void sort(){
        list.sort(Comparator.comparing(p->p.lastName));
    }
    public void addToList(Listing l){
        list.add(l);
    }

    public void addAll(Listing[] l){
        Collections.addAll(list, l);
    }

    public boolean delete(String id){
        list.removeIf(student -> id.equals(student.idNumber));
        return true;
    }

    public boolean fetch(String id) {
        boolean found = false;
        for (Listing student : list) {
            if (Objects.equals(id, student.idNumber)) {
                found = true;
                System.out.println(student);
                return true;
            }
        }
        if (!found) System.out.println("Student not found.");
        return false;
    }



    @Override
    public String toString() {
        return "Students{" +
                "list=" + list +
                '}';
    }
}
