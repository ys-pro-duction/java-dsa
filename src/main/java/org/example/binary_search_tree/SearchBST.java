package org.example.binary_search_tree;

import static org.example.binary_search_tree.BuildBinarySearchTree.buildBST;
import static org.example.binary_search_tree.BuildBinarySearchTree.printBSTInOrder;
import static org.example.binary_tree.BinaryTreeWithNode.*;

public class SearchBST {
    public static void main(String[] args) {
        int[] arr = {5, 1, 3, 4, 2, 7};
        Node root;
        root = buildBST(arr);
        printBSTInOrder(root);
        int key = 7;
        System.out.println("\n " + key + " exists in tree = " + searchKeyBST(root, key));
    }

    /*O(H) => O(logn)-O(n)*/
    private static boolean searchKeyBST(Node root, int key) {
        if (root == null) return false;
        if (root.data == key) return true;
        if (root.data > key) return searchKeyBST(root.left, key);
        else return searchKeyBST(root.right, key);
    }
}
