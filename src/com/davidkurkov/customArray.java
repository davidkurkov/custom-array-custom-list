package com.davidkurkov;


/**
 * Created by david on 3/25/16.
 */

class CustomArray implements list{
    int[] myArray;

    CustomArray() {
        myArray = new int[10];
    }

    @Override
    public void insert(int value) {
        if (isSupported(value)) {
            checkOverflow();
            myArray[findEmptyIndex()] = value;
        }
        else {
            notSupportedMessage(value);
        }
    }

    @Override
    public void remove(int value) {
        if (isSupported(value)) {
            int index = findIndexOfValue(value);
            if (index != -1) {
                myArray[index] = 0;
                cleanupArray();
            }
        }
        else {
            notSupportedMessage(value);
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
        int emptyIndex = 0;
        for (int i=0; i < myArray.length; i++) {
            if (myArray[i] == 0) {
                emptyIndex = i;
                break;
            }
        }
        return emptyIndex;
    }

    private boolean isSupported(int value) {
        return value != 0;
    }

    private String notSupportedMessage(int value) {
        throw new IllegalArgumentException("value: " + value + " is unsupported");
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
    }

    private void checkOverflow() {
        if (myArray.length - size() <= 3) {
            int tempArrayIndex = 0;
            int newLength = myArray.length * 3;
            int[] tempArray = new int[newLength];
            for (int i=0; i < myArray.length; i++) {
                if (myArray[i] != 0) {
                    tempArray[tempArrayIndex] = myArray[i];
                    tempArrayIndex += 1;
                }
            }
            myArray = tempArray;
        }
    }
}