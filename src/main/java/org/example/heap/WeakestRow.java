package org.example.heap;

import org.example.Main;

import java.util.PriorityQueue;

public class WeakestRow {
    public static void main(String[] args) {
        int[][] arr = {{1, 1, 0, 0, 0}, {1, 1, 1, 1, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 0, 0}, {1, 1, 1, 1, 1}};
        int k = 2;
        int [] result = kWeakestRows(arr,k);
        Main.printIntArray(result);
    }

    private static int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Row> pq = new PriorityQueue<>(mat.length);
        for (int i = 0; i < mat.length; i++) {
            Row row = new Row(i);
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) row.power++;
            }
            pq.add(row);
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.remove().idx;
        }
        return result;
    }

    static class Row implements Comparable<Row> {
        int idx;
        int power;

        public Row(int idx) {
            this.idx = idx;
            power = 0;
        }

        @Override
        public int compareTo(Row o) {
            if (power == o.power) return idx - o.idx;
            return power - o.power;
        }
    }
}
