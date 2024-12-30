package org.com.practice.practice.ds.linkedList.singlyLinkedList;

public class App {
    public static void main(String[] args) {
//        LinkedList<String> names = new LinkedList<>();
//        names.insert("Adam");
//        names.insert("Hitesh");
//        names.insert("Ana");
//
//        names.traverse();
//
//        names.remove("Hitesh");
//        names.traverse();
//        System.out.println(names.size());


        LinkedList<Person> persons = new LinkedList<>();
        Person p = new Person(23,"Hitesh");

        persons.insert(p);
        persons.insert(new Person(25, "Ana"));
        persons.insert(new Person(80, "Adam"));

        System.out.println(persons.size());
        persons.traverse();

        persons.remove(p);
        System.out.println(persons.size());
        persons.traverse();
    }
}
