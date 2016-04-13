package com.davidkurkov;

import junit.framework.TestCase;

public class Main extends TestCase {

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
        assertEquals(0, list.size());
        assertEquals("[]", list.printElements());

        list.insert(3);
        assertEquals(1, list.size());
        assertEquals("[3]", list.printElements());

        list.insert(5);
        assertEquals(2, list.size());
        assertEquals("[3, 5]", list.printElements());

        list.remove(3);
        assertEquals(1, list.size());
        assertEquals("[5]", list.printElements());

        list.insert(0);
        assertEquals(2, list.size());
        assertEquals("[5, 0]", list.printElements());

        list.remove(0);
        assertEquals(1, list.size());
        assertEquals("[5]", list.printElements());

        list.remove(12);
        assertEquals(1, list.size());
        assertEquals("[5]", list.printElements());

        list.clear();
        assertEquals(0, list.size());
        assertEquals("[]", list.printElements());
    }

    private static void testOverflow(list list) {
        for (int i = 1; i < 1500; i++) {
            list.insert(i);
        }
        String elementsBefore = list.printElements();
        for (int i = 1; i < 1500; i++) {
            assertTrue(elementsBefore.contains(String.valueOf(i)));
        }

        for (int i = 10; i < 975; i++) {
            list.remove(i);
        }
        String elementsAfter = list.printElements();
        for (int i = 0; i < 10; i++) {
            assertTrue(elementsAfter.contains(String.valueOf(i)));
        }
        for (int i = 975; i < 1500; i++) {
            assertTrue(elementsAfter.contains(String.valueOf(i)));
        }

        list.clear();
        assertEquals(0, list.size());
        assertEquals("[]", list.printElements());
    }

    private static void testRandomCombination(list list) {
        int elementsToAdd = 80000;
        for (int i = 1; i < elementsToAdd; i++) {
            list.insert(i);
        }
        String elementsBefore = list.printElements();
        for (int i = 1; i < elementsToAdd; i++) {
            assertTrue(elementsBefore.contains(String.valueOf(i)));
        }

        for (int i = 1; i < elementsToAdd; i++) {
            if (i % 2 == 0) {
                list.remove(i);
            }
        }

        String elementsAfter = list.printElements();
        for (int i = 1; i < elementsToAdd; i++) {
            if (i % 2 != 0) {
                assertTrue(elementsAfter.contains(String.valueOf(i)));
            }
        }
        list.clear();
        assertEquals(0, list.size());
        assertEquals("[]", list.printElements());
    }

}
