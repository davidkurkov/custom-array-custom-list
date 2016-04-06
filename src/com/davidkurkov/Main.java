package com.davidkurkov;

public class Main {

    public static void main(String[] args) {
        long startTimeArray = System.currentTimeMillis();
        CustomArray myArray = new CustomArray();
        testRobbsCriteria(myArray);
        testOverflow(myArray);
        testRandomCombination(myArray);
        long endTimeArray   = System.currentTimeMillis();
        long totalTimeArray = endTimeArray - startTimeArray;
        System.out.println("Array: " + totalTimeArray / 1000 + "s");
        System.out.println("\n");
        long startTimeList = System.currentTimeMillis();
        CustomList myList = new CustomList();
        testRobbsCriteria(myList);
        testOverflow(myList);
        testRandomCombination(myList);
        long endTimeList   = System.currentTimeMillis();
        long totalTimeList = endTimeList - startTimeList;
        System.out.println("List: " + totalTimeList / 1000 + "s");
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
        int elementsToAdd = 80000;
        for (int i = 1; i < elementsToAdd; i++) {
            list.insert(i);
        }
        # it took me a bit to figure out what was taking so long in here.
        # The problem is in printElements. Look up StringBuilder. That's how you should be doing strings in java.
        # You build your string with a StringBuilder, then call '.toString()' when ready to print it out.
        # I think that will cut down on how long this function is taking. Try timing just testRandomCombination with and
        # without a StringBuilder to verify.
        list.printElements();
        for (int i = 1; i < elementsToAdd; i++) {
            if (i % 2 == 0) {
                # Now THIS guy, the line below, is where all the time in this function should be going. At least for the array implementation.
                list.remove(i);
            }
        }
        list.printElements();
    }

}
