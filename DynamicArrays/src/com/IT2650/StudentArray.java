package com.IT2650;

public class StudentArray {
    private int next;
    private int size;
    public StudentListings[] students;

    public StudentArray(){
        next = 0;
        size = 5;
        students = new StudentListings[size];
    }

    public StudentArray(int s){
        next = 0;
        students = new StudentListings[s];
        size = s;
    }
    public boolean insert(StudentListings newListing){

        if (next >= size) {
            StudentListings[] temp; //create temp array
            StudentListings[] larger = new StudentListings[students.length + 1]; //create larger array to copy to
            temp = students;
            students = larger;
            System.arraycopy(temp, 0, larger,0, temp.length); //copy temp to larger array
            System.arraycopy(larger, 0, students, 0, larger.length);
            students[next] = newListing.deepCopy();
            temp = null;
            larger = null;
            next = next + 1;
            return false;
        }
        students[next] = newListing.deepCopy();

        if(students[next] == null)
            return false;
        next = next + 1;
        return true;
    }
    public StudentListings fetch(String studentID){
        StudentListings studentListings;
        StudentListings temp;

        int i = 0;
        while(i < next &&  !(students[i].compareTo(studentID) == 0)){
            i++;
        }
        if (i == next)
            return null;
        studentListings = students[i].deepCopy();
        if(i != 0){
            temp = students[i - 1];
            students[i - 1] = students[i];
            students[i] = temp;
        }
        return studentListings;
    }

    public boolean delete(String studentID) {
        int i = 0;
        while (i < next && !(students[i].compareTo(studentID) == 0)) {
            i++;
        }
        if (i == next)
            return false;
        students[i] = students[next -1];
        students[next - 1] = null;
        next = next - 1;
        return true;
    }
    public boolean update(String studentID, StudentListings newStudent) {
        if(!delete(studentID))
            return false;
        else return insert(newStudent);
    }
    public void showAll(){
        for(int i = 0; i < next; i++) {
            System.out.println(students[i].toString());
        }
    }
}
