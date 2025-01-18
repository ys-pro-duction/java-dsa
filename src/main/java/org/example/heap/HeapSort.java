package org.example.heap;

import java.util.ArrayList;

public class HeapSort {
    private static ArrayList<Integer> heap = new ArrayList<>();

    public static void main(String[] args) {
        heap.add(40);
        heap.add(20);
        heap.add(30);
        heap.add(80);
        heap.add(10);
        heap.add(90);
        heap.add(2);
        System.out.println(heap);
        heapSort(heap);
        System.out.println(heap);
    }

    public static void heapSort(ArrayList<Integer> h) {
        for (int i = 0; i < h.size(); i++) {
            heapify(i);
        }
    }

    private static void heapify(int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int idx = i;
        if (left < heap.size() && heap.get(idx) < heap.get(left)) {
            idx = left;
        }
        if (right < heap.size() && heap.get(idx) < heap.get(right)) {
            idx = right;
        }
        if (idx != i) {
            int tmp = heap.get(idx);
            int tmp2 = heap.get(i);
            heap.set(i, tmp);
            heap.set(idx, tmp2);
            heapify(idx);
        }
    }
}
