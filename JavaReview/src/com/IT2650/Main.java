package com.IT2650;

/*public class Main {
    /*I took IT2650 in the spring - that ended 5 months ago. I'm more than
    * a little rusty, and I wasn't an expert to begin with! I'm hoping more
    * comes back to me, and I keep learning and getting better, but hopefully
    * this is enough for the review assignment
    *
    * I went along with a few programming exercises from the book. I made a class
    * that takes user input and creates items with a name and a price, and a class
    * that creates a list, checks if it contains 'peas', and if so, outputs the average
    * item price to a message box. I didn't get to formatting the output.

    public static void main(String[] args) {
        CreateItem createItem = new CreateItem();
        createItem.createItem();
    }
}
*/
public class Main {

    public static void main(String[] args) {

        System.out.println();
        System.out.println("In Order:");
        ItemList list1 = new ItemList(new Item("Apples", 1.99));
        list1.insert(new Item("Oranges", 2.99), 1);
        list1.insert(new Item("Pears", 3.99), 2);
        list1.insert(new Item("Bananas", .99), 3);
        list1.insert(new Item("Kiwi", 3.49), 4);
        list1.print();
        list1.insert(new Item("Crabs", 14.99), 5);
    }

}

        /*System.out.println();
        System.out.println("Reverse Order:");
        Bookshelf shelf2 = new Bookshelf(new Book("Book One"));
        shelf2.insert(new Book("Book Two"), 0);
        shelf2.insert(new Book("Book Three"), 0);
        shelf2.insert(new Book("Book Four"), 0);
        shelf2.insert(new Book("Book Five"), 0);
        shelf2.print();

        System.out.println();
        System.out.println("Mixed Order:");
        Bookshelf shelf3 = new Bookshelf(new Book("Book One"));
        shelf3.insert(new Book("Book Two"), 1);
        shelf3.insert(new Book("Book Three"), 2);
        shelf3.insert(new Book("Book Four"), 1);
        shelf3.insert(new Book("Book Five"), 2);
        shelf3.print();*/