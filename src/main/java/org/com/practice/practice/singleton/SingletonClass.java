package org.com.practice.practice.singleton;

public class SingletonClass {
    private static SingletonClass instance = null;
    private SingletonClass() {
    }

    public static synchronized SingletonClass getInstance() {
        if (instance == null) {
            instance = new SingletonClass();
        }
        return instance;
    }
}
