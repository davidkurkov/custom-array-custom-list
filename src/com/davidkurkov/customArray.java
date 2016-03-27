package com.davidkurkov;


/**
 * Created by david on 3/25/16.
 */

class CustomArray implements list{
    int[] myArray;
    boolean[] inputArray;

    int memorySpots = 10;
    int increaseMemoryBy = 3;
    int memoryBuffer = 3;

    CustomArray() {
        myArray = new int[memorySpots];
        inputArray = new boolean[memorySpots];
    }

    @Override
    public void insert(int value) {
        checkOverflow();
        int emptyIndex = findEmptyIndex();
        myArray[emptyIndex] = value;
        inputArray[emptyIndex] = true;
    }

    @Override
    public void remove(int value) {
        int index = findIndexOfValue(value);
        if (index != -1) {
            myArray[index] = 0;
            inputArray[index] = false;
            cleanupArray();
        }
    }

    @Override
    public int size() {
        int count = 0;
        for (int i=0; i < myArray.length; i++) {
            if (myArray[i] != 0) {
                count++;
            }
        }
        return count;
    }

    @Override
    public void clear() {
        for (int i=0; i < myArray.length; i++) {
            myArray[i] = 0;
        }
    }

    @Override
    public void printElements() {
        String formattedElements = "";
        for (int i=0; i < myArray.length; i++) {
            if (myArray[i] != 0) {
                if (i == 0) {
                    formattedElements += "" + myArray[i];
                }
                else {
                    formattedElements += ", " + myArray[i];
                }
            }
        }
        formattedElements = "[" + formattedElements + "]";
        System.out.println(formattedElements);
    }

    private int findEmptyIndex() {
        int emptyIndex = -1;
        for (int i=0; i < inputArray.length; i++) {
            if (inputArray[i] == false) {
                emptyIndex = i;
                break;
            }
        }
        return emptyIndex;
    }

    private int findIndexOfValue(int value) {
        int index = -1;
        for (int i=0; i < myArray.length; i++) {
            if (myArray[i] == value) {
                index = i;
                break;
            }
        }
        return index;
    }

    private void prettyPrint(int elements) {
        if (elements == 1) {
            System.out.println("There is " + elements + " element.");
        }
        else {
            System.out.println("There are " + elements + " elements.");
        }
    }

    private void cleanupArray() {
        int[] tempArray = new int[myArray.length];
        int tempArrayIndex = 0;
        for (int i=0; i < myArray.length; i++) {
            if (myArray[i] != 0) {
                tempArray[tempArrayIndex] = myArray[i];
                tempArrayIndex += 1;
            }
        }
        myArray = tempArray;

        boolean[] tempInputArray = new boolean[inputArray.length];
        int tempInputArrayIndex = 0;
        for (int i=0; i < inputArray.length; i++) {
            if (inputArray[i] != false) {
                tempInputArray[tempInputArrayIndex] = inputArray[i];
                tempArrayIndex += 1;
            }
        }
        inputArray = tempInputArray;
    }

    private void checkOverflow() {
        if (myArray.length - size() <= memoryBuffer) {
            int tempArrayIndex = 0;
            int newLength = myArray.length * increaseMemoryBy;
            int[] tempArray = new int[newLength];
            for (int i=0; i < myArray.length; i++) {
                if (myArray[i] != 0) {
                    tempArray[tempArrayIndex] = myArray[i];
                    tempArrayIndex += 1;
                }
            }
            myArray = tempArray;
        }

        if (inputArray.length - size() <= memoryBuffer) {
            int tempArrayIndex = 0;
            int newLength = inputArray.length * increaseMemoryBy;
            boolean[] tempArray = new boolean[newLength];
            for (int i=0; i < inputArray.length; i++) {
                if (inputArray[i] != false) {
                    tempArray[tempArrayIndex] = inputArray[i];
                    tempArrayIndex += 1;
                }
            }
            inputArray = tempArray;
        }
    }
}