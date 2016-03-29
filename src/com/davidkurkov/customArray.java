package com.davidkurkov;

/**
 * Created by david on 3/25/16.
 */

class CustomArray implements list{
    int[] myArray;
    int[] inputArray;

    int memorySpots = 10;
    int increaseMemoryBy = 3;
    int memoryBuffer = 3;

    CustomArray() {
        myArray = new int[memorySpots];
        inputArray = new int[memorySpots];
    }

    @Override
    public void insert(int value) {
        myArray = checkOverflow(myArray);
        inputArray = checkOverflow(inputArray);
        int emptyIndex = findEmptyIndex();
        myArray[emptyIndex] = value;
        inputArray[emptyIndex] = 1;
    }

    @Override
    public void remove(int value) {
        int index = findIndexOfValue(value);
        if (index != -1) {
            myArray[index] = 0;
            inputArray[index] = 0;
        }
    }

    @Override
    public int size() {
        int count = 0;
        for (int i=0; i < inputArray.length; i++) {
            if (inputArray[i] != 0) {
                count++;
            }
            else {
                break;
            }
        }
        return count;
    }

    @Override
    public void clear() {
        myArray = clearArray(myArray);
        inputArray = clearArray(inputArray);
    }

    @Override
    public void printElements() {
        myArray = cleanupArray(myArray);
        inputArray = cleanupArray(inputArray);
        String formattedElements = "";
        for (int i=0; i < myArray.length; i++) {
            if (inputArray[i] == 0) {
                break;
            }
            else {
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
            if (inputArray[i] == 0) {
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

    private int[] cleanupArray(int[] array) {
        int[] tempArray = new int[array.length];
        int tempArrayIndex = 0;
        for (int i=0; i < array.length; i++) {
            if (array[i] != 0) {
                tempArray[tempArrayIndex] = array[i];
                tempArrayIndex += 1;
            }
        }
        return tempArray;
    }

    private int[] checkOverflow(int[] array) {
        if (array.length - size() <= memoryBuffer) {
            int tempArrayIndex = 0;
            int newLength = array.length * increaseMemoryBy;
            int[] tempArray = new int[newLength];
            for (int i=0; i < array.length; i++) {
                if (array[i] != 0) {
                    tempArray[tempArrayIndex] = array[i];
                    tempArrayIndex += 1;
                }
            }
            return tempArray;
        }
        return array;
    }

    private int[] clearArray(int[] array) {
        for (int i=0; i < array.length; i++) {
            array[i] = 0;
        }
        return array;
    }
}