package com.davidkurkov;

/**
 * Created by david on 3/26/16.
 */
class CustomList implements list{
    Node headNode = new Node();
    Node tailNode = headNode;
    boolean firstNode = true;

    @Override
    public void insert(int value) {
        if (firstNode) {
            headNode.setValue(value);
            firstNode = false;
        }
        else {
            Node newNode = new Node();
            newNode.setValue(value);
            tailNode.setNext(newNode);
            tailNode = newNode;
        }
    }

    @Override
    public void remove(int value) {
        if (headNode.getVal() == value && headNode.getNext() == null) {
            clear();
        }
        else if (headNode.getVal() == value && headNode.getNext() != null) {
            headNode = headNode.getNext();
        }
        else {
            Node previousNode = headNode;
            Node currentNode = headNode.getNext();
            while (true && currentNode != null) {
                if (currentNode.getVal() == value) {
                    if (currentNode.getNext() != null) {
                        previousNode.setNext(currentNode.getNext());
                    }
                    else {
                        previousNode.setNext(null);
                        if (previousNode == headNode) {
                            tailNode = headNode;
                        }
                    }
                    break;
                }
                previousNode = currentNode;
                currentNode = currentNode.getNext();
            }
        }
    }

    @Override
    public int size() {
        if (firstNode) {
            return 0;
        }
        else if (headNode == tailNode) {
            return 1;
        }
        else {
            int counter = 1;
            Node currentNode = headNode.getNext();
            while (currentNode != null) {
                currentNode = currentNode.getNext();
                counter += 1;
            }
            return counter;
        }
    }

    @Override
    public void clear() {
        headNode = new Node();
        tailNode = headNode;
        firstNode = true;
    }

    @Override
    public void printElements() {
        String formattedElements = "";
        Node currentNode = headNode;
        if (!firstNode) {
            while (currentNode != null) {
                if (currentNode == headNode) {
                    formattedElements += "" + currentNode.getVal();
                }
                else {
                    formattedElements += ", " + currentNode.getVal();
                }
                currentNode = currentNode.getNext();
            }
        }
        formattedElements = "[" + formattedElements + "]";
        System.out.println(formattedElements);
    }

    class Node {
        int val;
        Node next;

        int getVal() {
            return this.val;
        }

        int setValue(int value) {
            this.val = value;
            return this.val;
        }

        void setNext(Node next) {
            this.next = next;
        }

        Node getNext() {
            return this.next;
        }
    }
}
