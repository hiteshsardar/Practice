package org.com.practice.practice.generics;

public class GenericMethods {
    public <T> void showItems(T item) {
        System.out.println("The item is: " + item.toString());
    }

    public <T> T showAndReturnItems(T item) {
        System.out.println("The item is: " + item.toString());
        return item;
    }

    public <T, V> void showMultipleItems(T item, V value) {
        System.out.println("The item is: " + item.toString());
        System.out.println("The value is: " + value.toString());
    }

    public <T> void showArrayOfItems(T[] items) {
        for (T item : items) {
            System.out.println("The item is : " + item.toString());
        }
    }

    public <T,V> boolean checkEquality(T item, V value){
//        return item == value;
        return item.equals(value);
    }

    public static void main(String[] args) {
        GenericMethods genericMethods = new GenericMethods();
//        genericMethods.showItems(5);
//        genericMethods.showItems("Hello");
//        genericMethods.showItems(5.5);
//
//        System.out.println("Returned Iteam is " + genericMethods.showAndReturnItems(5));
//        System.out.println("Returned Iteam is " + genericMethods.showAndReturnItems("Hello"));
//        System.out.println("Returned Iteam is " + genericMethods.showAndReturnItems(5.5));
//
//        // multiple generics signature method
//        genericMethods.showMultipleItems(5, "Hello");
//        genericMethods.showMultipleItems("Hello", 5);

//        // array of generics
//        Integer[] integers = {1, 2, 3, 4, 5};
//        genericMethods.showArrayOfItems(integers);
//        String[] strings = {"Hello", "World"};
//        genericMethods.showArrayOfItems(strings);

        // check equality
        System.out.println(genericMethods.checkEquality(10.5, 10.5));
        System.out.println(genericMethods.checkEquality(5, 6));
        System.out.println(genericMethods.checkEquality("Joe", "Joe"));

    }
}
