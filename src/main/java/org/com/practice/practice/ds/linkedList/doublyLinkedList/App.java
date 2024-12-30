package org.com.practice.practice.ds.linkedList.doublyLinkedList;

public class App {
    public static void main(String[] args) {
        LinkedList<String> names = new LinkedList<>();
        names.insert("Hitesh");
        names.insert("Sardar");
        names.insert("Adam");
        names.insert("Ana");

        System.out.println(names.size());
        names.traverseForward();
//        names.traverseBackward();

        names.remove("ardar");
        System.out.println(names.size());
        names.traverseForward();
    }
}
