package org.com.practice.practice.generics;

import java.util.HashMap;
import java.util.Map;

class GenericClass<H>{
    private H data;

    public H getData() {
        return data;
    }

    public void setData(H data) {
        this.data = data;
    }
}

class HashTable<K, V> {
    private K key;
    private V value;

    public HashTable(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "HashTable{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}

public class GenericTest {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("hs", 587);
        GenericClass<Integer> genericClass = new GenericClass<>();
        genericClass.setData(587);
        System.out.println(genericClass.getData());

        HashTable<String, Integer> hashTable = new HashTable<>("hs", 587);
        System.out.println(hashTable);
    }
}
