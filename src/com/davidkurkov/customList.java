package com.davidkurkov;

/**
 * Created by david on 3/26/16.
 */
class CustomList implements list{
//    # New lists should start with headNode = null
    Node headNode = null;
    Node tailNode = headNode;
    int size = 0;

    @Override
    public void insert(Number value) {
        if (headNode == null) {
            headNode = new Node();
            headNode.setValue(value);
            tailNode = headNode;
        }
        else {
            Node newNode = new Node();
            newNode.setValue(value);
            tailNode.setNext(newNode);
            tailNode = newNode;
        }
        size += 1;
    }

    @Override
    public void remove(Number value) {
        if (size == 1 && headNode.getVal() == value) {
            clear();
            return;
        }
        else if (headNode.getVal() == value && headNode.getNext() != null) {
            headNode = headNode.getNext();
            size -= 1;
        }
        else {
            Node previousNode = headNode;
            Node currentNode = headNode.getNext();
            while (currentNode != null) {
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
                    size -= 1;
                    break;
                }
                previousNode = currentNode;
                currentNode = currentNode.getNext();
            }
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        headNode = null;
        tailNode = headNode;
        size = 0;
    }

    @Override
    public String printElements() {
        StringBuilder elements = new StringBuilder();
        if (size == 0) {
            elements.append("[]");
        }
        else {
            Node currentNode = headNode;
            while (currentNode != null) {
                if (currentNode != headNode) {
                    elements.append(", ");
                }
                elements.append(currentNode.getVal());
                currentNode = currentNode.getNext();
            }
            elements.insert(0, "[");
            elements.append("]");
        }
        System.out.println(elements.toString());
        return elements.toString();
    }

    @Override
    public void reverse() {
        return;
    }

    class Node {
        Number val;
        Node next;

        Number getVal() {
            return this.val;
        }

        Number setValue(Number value) {
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
