package org.com.practice.practice.ds.linkedList.doublyLinkedList;

import java.util.Comparator;

public class Person implements Comparable<Person>{
    private int age;
    private String name;
    private int salary;

    public Person(int salary, String name, int age) {
        this.salary = salary;
        this.name = name;
        this.age = age;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }


    @Override
    public int compareTo(Person person) {
        return Comparator.comparing(Person::getName).thenComparingInt(Person::getAge).thenComparingInt(Person::getSalary).compare(this, person);
    }
}
