package org.example.binary_search_tree;

import org.example.binary_tree.BinaryTreeWithNode.Node;

import static org.example.binary_tree.BinaryTreeWithNode.printLevelOrder;

public class BuildBinarySearchTree {
    public static void main(String[] args) {
        int[] arr = {150, 155, 160, 115, 110, 140, 120, 145, 130, 147, 180};
        Node root;
        root = buildBST(arr);
//        printBSTInOrder(root);
        printLevelOrder(root);
    }

    public static void printBSTInOrder(Node root) {
        if (root == null) return;
        printBSTInOrder(root.left);
        System.out.print(" " + root.data);
        printBSTInOrder(root.right);
    }

    public static Node buildBST(int[] arr) {
        Node root = null;
        for (int i : arr) {
            if (root == null) root = new Node(i);
            else {
                insertNode(root, i);
            }
        }
        return root;
    }

    private static void insertNode(Node parent, int i) {
        if (parent.data > i) {
            if (parent.left == null) parent.left = new Node(i);
            else insertNode(parent.left, i);
        } else {
            if (parent.right == null) parent.right = new Node(i);
            else insertNode(parent.right, i);
        }
    }
}
