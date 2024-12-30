package org.com.practice.practice.ds.linkedList.singlyLinkedList;

public class LinkedList<T extends Comparable<T>> implements List<T> {
    private Node<T> rootNode;
    private int noOfItems = 0;

    @Override
    public void insert(T data) {
        if(rootNode == null) {
            noOfItems++;
            rootNode = new Node<>(data);
        } else {
            noOfItems++;
//            insertBeginning(data);
            insertEnd(data, rootNode);
        }
    }

    @Override
    public void remove(T data) {
        if (rootNode == null) return;

        // remove first node
        if (rootNode.getData().compareTo(data) == 0) {
            noOfItems--;
            rootNode = rootNode.getNextNode();
        } else {
            remove(data, rootNode, rootNode.getNextNode());
        }
    }

    @Override
    public void traverse() {
        if(rootNode == null) return;

        Node<T> actualNode = rootNode;
        while (actualNode != null) {
            System.out.println(actualNode);
            actualNode = actualNode.getNextNode();
        }
    }

    @Override
    public int size() {
        return noOfItems;
    }

    private void insertBeginning(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.setNextNode(rootNode);
        rootNode = newNode;
    }

    private void insertEnd(T data, Node<T> node) {
        if(node.getNextNode() != null){
            insertEnd(data, node.getNextNode());
        } else {
            Node<T> newNode = new Node<>(data);
            node.setNextNode(newNode);
            newNode.setNextNode(null);
        }
    }

    private void remove(T data, Node<T> previousNode, Node<T> actualNode) {
        while (actualNode != null) {
            if (actualNode.getData().compareTo(data) == 0) {
                noOfItems--;
                previousNode.setNextNode(actualNode.getNextNode());
                actualNode = null;
                return;
            }
            previousNode = actualNode;
            actualNode = actualNode.getNextNode();
        }
    }
}
