package com.davidkurkov;

public class Main {

    public static void main(String[] args) {
        CustomArray myArray = new CustomArray();
        testRobbsCriteria(myArray);
        testOverflow(myArray);
        testRandomCombination(myArray);
        System.out.println("\n");
        CustomList myList = new CustomList();
        testRobbsCriteria(myList);
        testOverflow(myList);
        testRandomCombination(myList);
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
        list.insert(0);
        System.out.println(list.size());
        list.printElements();
        list.remove(0);
        System.out.println(list.size());
        list.printElements();
    }

    private static void testOverflow(list list) {
        list.printElements();
        for (int i = 1; i < 1500; i++) {
            list.insert(i);
        }
        list.printElements();
        for (int i = 10; i < 975; i++) {
            list.remove(i);
        }
        list.printElements();
        list.clear();
        list.printElements();
    }

    private static void testRandomCombination(list list) {
        for (int i = 1; i < 345; i++) {
            if (i % 2 == 0) {
                list.insert(i);
                System.out.println(list.size());
            }
            else {
                list.remove(i);
            }
            if (i == 273 || i == 332) {
                list.printElements();
                list.clear();
            }
        }
    }

}
