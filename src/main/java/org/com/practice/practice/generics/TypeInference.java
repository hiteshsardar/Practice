package org.com.practice.practice.generics;

import java.util.ArrayList;
import java.util.List;

class Bucket<T> {
    private T item;

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}

public class TypeInference {
    private static <T> void addItem(T t, List<Bucket<T>> list) {
        Bucket<T> bucket = new Bucket<>();
        bucket.setItem(t);
        list.add(bucket);
        System.out.println(t.toString() + " has been added to the list...");
    }

    static <T> List<T> add(List<T> list, T item1, T item2) {
        list.add(item1);
        list.add(item2);
        return list;
    }

    public static void main(String[] args) {
        List<Bucket<String>> list = new ArrayList<>();
        TypeInference.addItem("Hello", list);

        // type witness
        TypeInference.<String>addItem("World", list);

        // type inference
        List<Integer> integerList1 = TypeInference.add(new ArrayList<>(), 5, 10);
        System.out.println(integerList1);

        List<String> integerList2 = TypeInference.add(new ArrayList<>(), "Hitesh", "Sardar");
        System.out.println(integerList2);
    }
}
