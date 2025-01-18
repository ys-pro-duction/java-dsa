package org.example.binary_tree;

import org.example.binary_tree.BinaryTreeWithNode.Node;

import java.util.LinkedList;
import java.util.Queue;

import static org.example.binary_tree.BinaryTreeWithNode.BinaryTree;

public class KthLevelOfBT {
    // print K th level horizontal nodes
    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, 10};
        Node root = new BinaryTree().buildBinaryTree(nodes);
        int level = 3;
        printKthLevel(root, level);
        System.out.println();
        printKthLevelRecursive(root, level, 1);

    }

    private static void printKthLevelRecursive(Node root, int level, int i) {
        if (root == null || level < i) return;
        if (i == level) System.out.print(" " + root.data);
        printKthLevelRecursive(root.left, level, ++i);
        printKthLevelRecursive(root.right, level, i);
    }

    private static void printKthLevel(Node root, int level) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        int lCount = 1;
        while (!queue.isEmpty() && lCount <= level) {
            Node cuNode = queue.remove();
            if (cuNode == null) {
                if (!queue.isEmpty()) {
                    lCount++;
                    queue.add(null);
                }
            } else {
                if (level == lCount) System.out.print(" " + cuNode.data);
                if (cuNode.left != null) queue.add(cuNode.left);
                if (cuNode.right != null) queue.add(cuNode.right);
            }
        }
    }
}
