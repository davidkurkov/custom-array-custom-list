package com.davidkurkov;

/**
 * Created by david on 3/26/16.
 */
class CustomList implements list{
    Node headNode;
    Node tailNode;

    CustomList() {
        headNode = new Node(0);
        tailNode = headNode;
    }

    @Override
    public void insert(int value) {
        if (isSupported(value)) {
            if (size() != 0) {
                Node newNode = new Node(value);
                tailNode.setNext(newNode);
                tailNode = newNode;
            }
            else {
                headNode.setValue(value);
            }
        }
        else {
            notSupportedMessage(value);
        }
    }

    @Override
    public void remove(int value) {
        if (headNode.getVal() == value) {
            headNode = headNode.getNext();
        }
        else {
            Node previousNode = headNode;
            Node currentNode = headNode.getNext();
            while (true) {
                if (currentNode.getVal() == value) {
                    previousNode.setNext(currentNode.getNext());
                    break;
                }
                previousNode = currentNode;
                currentNode = currentNode.getNext();
            }
        }
    }

    @Override
    public int size() {
        if (isEmpty()) {
            return 0;
        }
        if (headNode == tailNode) {
            return 1;
        }
        int counter = 1;
        Node currentNode = headNode.getNext();
        while (currentNode != null) {
            currentNode = currentNode.getNext();
            counter += 1;
        }
        return counter;
    }

    @Override
    public void clear() {
        headNode = new Node(0);
        tailNode = headNode;
    }

    @Override
    public void printElements() {
        String formattedElements = "";
        Node currentNode = headNode;
        if (currentNode.getVal() != 0) {
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

    private boolean isEmpty() {
        if (headNode.getVal() == 0 && headNode == tailNode) {
            return true;
        }
        return false;
    }

    private boolean isSupported(int value) {
        return value != 0;
    }

    private String notSupportedMessage(int value) {
        throw new IllegalArgumentException("value: " + value + " is unsupported");
    }

    class Node {
        int val;
        Node next;

        Node(int value) {
            val = value;
            next = null;
        }

        int getVal() {
            return val;
        }

        int setValue(int value) {
            val = value;
            return val;
        }

        void setNext(Node next) {
            this.next = next;
        }

        Node getNext() {
            return next;
        }
    }
}
