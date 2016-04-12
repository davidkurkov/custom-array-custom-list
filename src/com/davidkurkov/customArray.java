package com.davidkurkov;

/**
 * Created by david on 3/25/16.
 */

class CustomArray implements list {
    int[] myArray;
    int index = 0;
    int memorySpots = 10;
    int multiplierAndBuffer = 3;

    CustomArray() {
        myArray = new int[memorySpots];
    }

    @Override
    public void insert(int value) {
        checkOverflow();
        myArray[index] = value;
        index += 1;
    }

    @Override
    public void remove(int value) {
        int valueOfIndex = findIndexOfValue(value);
        if (valueOfIndex != -1) {
            int count = valueOfIndex;
            while (count < index) {
                myArray[count] = myArray[count+1];
                count += 1;
            }
            index -= 1;
        }
    }

    @Override
    public int size() {
        return index;
    }

    @Override
    public void clear() {
        myArray = new int[memorySpots];
        index = 0;
        int memorySpots = 10;
        int multiplierAndBuffer = 3;
    }

    @Override
    public String printElements() {
        StringBuilder elements = new StringBuilder();
        if (index == 0) {
            elements.append("[]");
        }
        else {
            for (int i=0; i < index; i++) {
                if (i == 0) {
                    elements.append(myArray[i]);
                }
                else {
                    elements.append(", ");
                    elements.append(myArray[i]);
                }
            }
            elements.insert(0, "[");
            elements.append("]");
        }
        System.out.println(elements.toString());
        return elements.toString();
    }

    private int findIndexOfValue(int value) {
        int indexOfValue = -1;
        for (int i=0; i < index; i++) {
            if (myArray[i] == value) {
                indexOfValue = i;
                break;
            }
        }
        return indexOfValue;
    }

    private void checkOverflow() {
        if (myArray.length - size() <= multiplierAndBuffer) {
            int tempArrayIndex = 0;
            int newLength = myArray.length * multiplierAndBuffer;
            int[] tempArray = new int[newLength];
            for (int i=0; i < size(); i++) {
                tempArray[tempArrayIndex] = myArray[i];
                tempArrayIndex += 1;
            }
            myArray = tempArray;
        }
    }
}
