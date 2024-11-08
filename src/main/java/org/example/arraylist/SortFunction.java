package org.example.arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class SortFunction {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(5);
        list.add(8);
        list.add(15);
        list.add(3);

        System.out.println("Original list: " + list);
//        Collections.sort(list);
        System.out.println("Sorted list: " + list);
        Collections.sort(list, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return new Random().nextInt(-2, 2);
            }
        });
        System.out.println("Sorted list: " + list);
    }
}
