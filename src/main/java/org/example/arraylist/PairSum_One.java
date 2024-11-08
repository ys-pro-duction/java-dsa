package org.example.arraylist;

import java.util.ArrayList;

public class PairSum_One {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);
        // sorted array
        int target = 20;
        System.out.println("For target = " + target + ", Pair exist = " + isPairExitst(arrayList, target));
    }

    private static boolean isPairExitst(ArrayList<Integer> arr, int target) {
        for (int i = 0, j = arr.size() - 1; i < j; ) {
            int sum = arr.get(i) + arr.get(j);
            if (sum == target) return true;
            else if (sum > target) j--;
            else i++;
        }
        return false;
    }
}
