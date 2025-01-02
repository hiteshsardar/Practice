package org.com.practice.practice.generics.wildcards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UpperBoundedWildCard {
    private static double sumAll(List<? extends Number> list) {
        double sum = 0;

        for (Number no : list)
            sum += no.doubleValue();

        return sum;
    }

    private static void showAll(List<? extends Number> list) {
        for (Number no : list)
            System.out.println(no);
    }

    public static void main(String[] args) {
        List<? extends Number> l1 = new ArrayList<Integer>();
        List<? extends Number> l2 = new ArrayList<Double>();
        List<? extends Number> l3 = new ArrayList<Float>();

        showAll(Arrays.asList(1.2f, 2.3f, 8));

        System.out.println(sumAll(Arrays.asList(1, 9, 7)));
    }
}
