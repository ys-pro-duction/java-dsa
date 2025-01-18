package org.example.heap;

public class Insert {


    public static void main(String[] args) {
        Heap heap = new Heap(7);
        heap.insert(10);
        heap.insert(20);
        heap.insert(40);
        heap.insert(30);
        heap.insert(80);
        heap.insert(90);
        heap.insert(2);
        heap.printH();
        System.out.println();
        heap.print();
        while (!heap.isEmpty()) {
            System.out.print(" " + heap.remove());
        }
        System.out.println();
        heap.print();
    }

}
