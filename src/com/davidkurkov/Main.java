package com.davidkurkov;

public class Main {

    public static void main(String[] args) {
        CustomArray myArray = new CustomArray();
        testRobbsCriteria(myArray);
        testOverflow(myArray);
        System.out.println("\n");
        CustomList myList = new CustomList();
        testRobbsCriteria(myList);
        testOverflow(myList);
    }

    private static void testRobbsCriteria(list list) {
        System.out.println(list.size());
        list.printElements();
        list.insert(3);
        System.out.println(list.size());
        list.printElements();
        list.insert(5);
        System.out.println(list.size());
        list.printElements();
        list.remove(3);
        System.out.println(list.size());
        list.printElements();
    }

    private static void testOverflow(list list) {
        list.printElements();
        for (int i = 1; i < 15; i++) {
            list.insert(i);
        }
        list.printElements();
        for (int i = 10; i < 14; i++) {
            list.remove(i);
        }
        list.printElements();
        list.clear();
        list.printElements();
    }

}
