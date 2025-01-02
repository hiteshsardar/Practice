package org.com.practice.practice.generics.wildcards;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LowerBoundedWildCard {
    private static void showAll(List<? super Number> list){
        for (Object num : list)
            System.out.println(num);
    }

    public static void main(String[] args) {
        List<? super Integer> l1 = new ArrayList<Integer>();
        List<? super Integer> l2 = new ArrayList<Number>();
        List<? super Integer> l3 = new ArrayList<Object>();

        // how to items using lower bounded wildcard
        List<Serializable> list = new ArrayList<>();
        list.add("Hitesh");
        list.add("Sardar");
        list.add("Adam");
        showAll(list);
    }
}
