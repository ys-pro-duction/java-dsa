package org.example.arraylist;

import java.util.ArrayList;
import java.util.Collections;

public class LonelyNumber {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(10);
        arrayList.add(6);
        arrayList.add(5);
        arrayList.add(8);
        System.out.println(lonelyNumber(arrayList));
    }

    private static ArrayList<Integer> lonelyNumber(ArrayList<Integer> arrayList) {
        Collections.sort(arrayList);
        arrayList.add(Integer.MAX_VALUE);
        arrayList.add(0, Integer.MAX_VALUE);
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i < arrayList.size() - 1; i++) {
            if (arrayList.get(i - 1) + 1 < arrayList.get(i) && arrayList.get(i) < arrayList.get(i + 1) - 1) {
                result.add(arrayList.get(i));
            }
//            if (arrayList.get(i - 1).equals(arrayList.get(i)) || arrayList.get(i - 1).equals(arrayList.get(i) - 1) || arrayList.get(i + 1).equals(arrayList.get(i)) || arrayList.get(i + 1).equals(arrayList.get(i) + 1)) {
//            } else result.add(arrayList.get(i));
        }
        return result;
    }
}
