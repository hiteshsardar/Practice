package org.com.practice.practice.ds.linkedList.doublyLinkedList;

public class LinkedList <T extends Comparable<T>> implements List<T> {
    private Node<T> headNode;
    private Node<T> tailNode;
    private int size;

    @Override
    public void insert(T data) {
        Node<T> newNode = new Node<>(data);
        if (tailNode == null) {
            size++;
            headNode = newNode;
            tailNode = newNode;
        } else {
            size++;
//            insertFirstNode(data, headNode);
            insertLastNode(data, tailNode);
        }
    }

    @Override
    public void remove(T data) {
        if (headNode == null) return;

        if (headNode.getData().compareTo(data) == 0) {
            size--;
            Node<T> removeNode = headNode;
            headNode = headNode.getNextNode();
            headNode.setPrevNode(null);
            removeNode = null;
        } else if (tailNode.getData().compareTo(data) == 0) {
            size--;
            Node<T> removeNode = tailNode;
            tailNode = tailNode.getPrevNode();
            tailNode.setNextNode(null);
            removeNode = null;
        } else {
            removeNode(data);
        }
    }

    @Override
    public void traverseForward() {
        Node<T> actualNode = headNode;

        while (actualNode != null) {
            System.out.println(actualNode);
            actualNode = actualNode.getNextNode();
        }
    }

    @Override
    public void traverseBackward() {
        Node<T> actualNode = tailNode;

        while (actualNode != null) {
            System.out.println(actualNode);
            actualNode = actualNode.getPrevNode();
        }
    }

    @Override
    public int size() {
        return size;
    }

    private void insertFirstNode(T data, Node<T> head) {
        Node<T> newNode = new Node<>(data);
        headNode.setPrevNode(newNode);
        newNode.setNextNode(head);
        newNode.setPrevNode(null);
        headNode = newNode;
    }

    private void insertLastNode(T data, Node<T> tail) {
        Node<T> newNode = new Node<>(data);
        tailNode.setNextNode(newNode);
        newNode.setPrevNode(tail);
        newNode.setNextNode(null);
        tailNode = newNode;
    }

    private void removeNode(T data) {
        Node<T> actualNode = headNode.getNextNode();
        while (actualNode != null) {
            if (actualNode.getData().compareTo(data) == 0) {
                size--;
                Node<T> prevNode = actualNode.getPrevNode();
                prevNode.setNextNode(actualNode.getNextNode());
                actualNode = null;
                break;
            }
            actualNode = actualNode.getNextNode();
        }
    }
}
