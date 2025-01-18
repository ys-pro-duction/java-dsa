package org.example.binary_search_tree;

import static org.example.binary_search_tree.BuildBinarySearchTree.buildBST;
import static org.example.binary_search_tree.BuildBinarySearchTree.printBSTInOrder;
import static org.example.binary_tree.BinaryTreeWithNode.*;

public class PrintInRange {
    private static void printInRange(Node root, int k1, int k2) {
        if (root == null) return;
        if (root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.print(" " + root.data);
            printInRange(root.right, k1, k2);
        } else if (root.data > k2) {
            printInRange(root.left, k1, k2);
        } else {
            printInRange(root.right, k1, k2);
        }
    }

    public static void main(String[] args) {
        int[] arr = {8, 5, 1, 3, 4, 2, 7, 6, 10, 9, 11, 13, 12};
        Node root;
        root = buildBST(arr);
        int k1 = 2;
        int k2 = 5;
        printBSTInOrder(root);
        System.out.println();
        printInRange(root, k1, k2);
        System.out.println();
    }
}
