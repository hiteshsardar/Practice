package org.com.practice.practice.ds.linkedList.singlyLinkedList;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;

@Slf4j
public class Person implements Comparable<Person> {
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }


    @Override
    public int compareTo(Person person) {
        return Comparator.comparing(Person::getName).thenComparingInt(Person::getAge).compare(this, person);
    }
}
