package org.com.practice.practice.ds.linkedList.doublyLinkedList;

public interface List<T> {
    public void insert(T data);
    public void remove(T data);
    public void traverseForward();
    public void traverseBackward();
    public int size();
}
