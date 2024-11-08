package org.example.arraylist;

import java.util.ArrayList;

public class PairSum_Two {
    public static void main(String[] args) {
        // Sorted rotated array
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(11);
        arrayList.add(15);
        arrayList.add(6);
        arrayList.add(8);
        arrayList.add(9);
        arrayList.add(10);
        int target = 25;
        boolean res = isPairExist(arrayList, target);
        System.out.println("is pair exist = " + res);
    }

    private static boolean isPairExist(ArrayList<Integer> arrayList, int target) {
        int lp = 0;
        int rp = arrayList.size() - 1;
        for (int i = 0; i < arrayList.size(); i++) {
            lp = (arrayList.get(i) < lp) ? i : lp;
            rp = (arrayList.get(i) > rp) ? i : rp;
        }
        while (lp != rp) {
            int sum = arrayList.get(lp) + arrayList.get(rp);
            if (sum == target) return true;
            else if (sum > target) rp = (rp + arrayList.size() - 1) % arrayList.size();
            else lp = (lp + 1) % arrayList.size();
        }
        return false;
    }
}
