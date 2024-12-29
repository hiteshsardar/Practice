package org.com.practice.practice.generics;

class Persion implements Comparable<Persion> {
    private String name;
    private int age;
    public Persion(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Persion otherPersion) {
//        // compare based on age
//        return this.age - otherPersion.age;
//        return Integer.compare(this.getAge(), otherPersion.getAge());

        // compare based on name
//        return this.getName().compareTo(otherPersion.getName());
        String str = new String(this.getName());
        String str2 = new String(otherPersion.getName());
        int test =  str.compareTo(str2);
        return test;
    }

    @Override
    public String toString() {
        return "Persion{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class BoundedGenericTypes {
    /*
        In this exercise, your task is to construct a generic method that takes two T objects as the input and it returns the minimum of these two objects.
        For example:
        calculateMin(74, 85) --> result is 74
        calculateMin(94, 2) --> result is 2
        calculateMin(74.5, 85.5) --> result is 74.5
        calculateMin("Hitesh", "Sardar") --> result is "Hitesh"
     */
    public static <T extends Comparable<T>> T calculateMin(T item1, T item2) {
        return item1.compareTo(item2) < 0 ? item1 : item2;
    }

    /*
        In this exercise, your task is to construct a generic method that takes two T objects as the input and it returns the sum of these two objects.
        For example:
        add(74, 85) --> result is 159
        add(74.5, 85.5) --> result is 160.0
        add(74, 85.5) --> result is 159.5
     */
    public static <T extends Number> double add(T item1, T item2) {
        return item1.doubleValue() + item2.doubleValue();
    }

    /*
        In this exercise, your task is to construct a generic method that takes a T[] one-dimensional array as the input with a T item and it counts that how many items are greater than this specified T item.
        For example:
        [1, 2, 3, 4, 5] and item=3 --> result is 2 because 4, 5 are greater than 3.
        [1.4, 2.1, 3.9, 4.3, 5.1] and item=2.0 --> result is 4 because 2.1, 3.9, 4.3, 5.1 are greater than 2.0.
        ["a", "b", "f", "d", "e"] and item="c" --> result is 3 because "f", "d", "e" are greater than "c" in the alphabetical order.
     */
    public <T extends Comparable<T>> int countGreaterItems(T[] items, T item){
        int counter = 0;

        for (T itm : items){
            if (itm.compareTo(item) > 0)
                ++counter;
        }
        return counter;
    }

    public static void main(String[] args) {
//        System.out.println(calculateMin(74, 85));
//        System.out.println(calculateMin(94, 2));
//        System.out.println(calculateMin(74.5, 85.5));
//        System.out.println(calculateMin("Hitesh", "Sardar"));

//        // compare persion objects
//        Persion persion1 = new Persion("Hitesh", 25);
//        Persion persion2 = new Persion("aardar", 24);
//        System.out.println(calculateMin(persion1, persion2));
//
//        // add numbers
//        System.out.println(add(74, 85));
//        System.out.println(add(74.5, 85.5));
//        System.out.println(add(74, 85.5f));

        // count greater items
        Integer[] numbers = {1, 2, 3, 4, 5};
        System.out.println(new BoundedGenericTypes().countGreaterItems(numbers, 3));
        Double[] doubles = {1.4, 2.1, 3.9, 4.3, 5.1};
        System.out.println(new BoundedGenericTypes().countGreaterItems(doubles, 2.0));
        String[] strings = {"a", "b", "f", "d", "e"};
        System.out.println(new BoundedGenericTypes().countGreaterItems(strings, "c"));
    }
}
