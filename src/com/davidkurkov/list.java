package com.davidkurkov;

/**
 * Created by david on 3/25/16.
 */
abstract interface list {

    void insert(int value);

    void remove(int value);

    int size();

    void clear();

    String printElements();

}
