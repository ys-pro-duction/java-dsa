package org.example.binary_tree;

import static org.example.binary_tree.BinaryTreeWithNode.*;

public class MinDistanceBetweenNodes {
    private static Node findAncester(Node root, int n1, int n2) {
        if (root == null) return null;
        if (root.data == n1 || root.data == n2) return root;
        Node left = findAncester(root.leftChild, n1, n2);
        Node right = findAncester(root.rightChild, n1, n2);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }

    private static int findDistance(Node root, int n1, int n2) {
        if (root == null) return 0;
        if (root.data == n1 || root.data == n2) return 1;
        int left = findDistance(root.leftChild, n1, n2);
        int right = findDistance(root.rightChild, n1, n2);
        if (left > -1 && right > -1) return left + right;
        if (left > -1) return left + 1;
        if (right > -1) return right + 1;
        return -1;
    }

    private static int distanceBetweenNodes(Node root, int n1, int n2) {
        Node ancester = findAncester(root, n1, n2);
        return findDistance(ancester, n1, n2);
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1};
        Node root = new BinaryTree().buildBinaryTree(nodes);
        int distance = distanceBetweenNodes(root, 2, 3);
        System.out.println("Distance is = " + distance);
    }
}
