package org.example.arraylist;

import java.util.ArrayList;

public class BeautifulArray {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(beautifulArray(n));
        System.out.println(beautifulArray2(n));
        System.out.println(beautifulArray3(n));
    }//66 62

    private static ArrayList<Integer> beautifulArray(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int first = (2 * i);
            if (first <= n) result.add(first);
            int second = (2 * i) - 1;
            if (second <= n) result.add(second);
        }
        return result;
    }

    private static ArrayList<Integer> beautifulArray2(int n) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(1);
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int j : result) {
                int sum = (2 * j);
                if (sum <= n) tmp.add(sum);
            }
            for (int j : result) {
                int sum = (2 * j) - 1;
                if (sum <= n) tmp.add(sum);
            }
            result = tmp;
        }
        return result;
    }

    private static ArrayList<Integer> beautifulArray3(int n) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        divideConque(1, 1, arrayList, n);
        return arrayList;
    }

    private static void divideConque(int start, int increment, ArrayList<Integer> res, int n) {
        if (start + increment > n) {
            res.add(start);
            return;
        }
        divideConque(start, 2 * increment, res, n);
        divideConque(start + increment, 2 * increment, res, n);
    }

}

