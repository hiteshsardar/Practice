package org.com.practice.practice.generics.wildcards;

import java.util.ArrayList;
import java.util.List;

public class WildCards {

    private static <T extends Shape>void drawAll(List<T> shapes){
        for (T shape : shapes)
            shape.draw();
    }

    private static void print(List<?> lst) {
        for (Object obj : lst)
            System.out.println(obj);
    }

    public static void main(String[] args) {
//        List<String> names = Arrays.asList("Hitesh", "Sardar", "Ana", "Adam");
//        print(names);

        List<Rectangle> rect = new ArrayList<>();
        rect.add(new Rectangle());
        drawAll(rect);
    }
}
