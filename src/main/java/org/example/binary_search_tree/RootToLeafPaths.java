package org.example.binary_search_tree;

import java.util.ArrayList;

import static org.example.binary_search_tree.BuildBinarySearchTree.buildBST;
import static org.example.binary_tree.BinaryTreeWithNode.Node;

public class RootToLeafPaths {
    private static void printAllPaths(Node root, ArrayList<Integer> path) {
        if (root == null) return;
        path.add(root.data);
        if (root.left == root.right && root.left == null) {
            System.out.println(path);
        }
        printAllPaths(root.left, path);
        printAllPaths(root.right, path);
        path.removeLast();
    }

    public static void main(String[] args) {
        int[] arr = {8, 5, 10, 3, 6, 11, 14};
        Node root;
        root = buildBST(arr);
        printAllPaths(root, new ArrayList<>());
    }
}
