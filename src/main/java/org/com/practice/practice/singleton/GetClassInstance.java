package org.com.practice.practice.singleton;

import java.util.concurrent.ConcurrentHashMap;

public class GetClassInstance {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> my_cmmap = new ConcurrentHashMap<>();
        SingletonClass instance1 = SingletonClass.getInstance();
        SingletonClass instance2 = SingletonClass.getInstance();
        System.out.println(instance1 == instance2);
    }
}
