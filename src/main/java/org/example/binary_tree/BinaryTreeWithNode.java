package org.example.binary_tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeWithNode {
    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1};
        Node root = new BinaryTree().buildBinaryTree(nodes);
//        printBinaryTree(root);
        printLevelOrder(root);
    }

    public static void printBinaryTree(Node root) {
        if (root == null) return;
        // PreOrder  1 2 4 5 3 6
        // InOrder   4 2 5 1 3 6
        // PostOrder 4 5 2 6 3 1
        printBinaryTree(root.left);
        printBinaryTree(root.right);
        System.out.print(" " + root.data);
    }

    public static void printLevelOrder(Node root) {
//        1
//        2 3
//        4 5 6
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            Node currentNode = queue.remove();
            if (currentNode == null) {
                System.out.println();
                if (!queue.isEmpty()) queue.add(null);
            } else {
                System.out.print(" " + currentNode.data);
                if (currentNode.left != null) queue.add(currentNode.left);
                if (currentNode.right != null) queue.add(currentNode.right);
            }
        }
    }

    public static class Node {
        public Node left;
        public Node right;
        public int data;
        int idx;// for one queston

        public Node(int data) {
            this.data = data;
        }
    }

    public static class BinaryTree {
        private int idx = -1;

        public Node buildBinaryTree(int[] nodes) {
            idx++;
            if (idx >= nodes.length) {
                return null;
            }
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildBinaryTree(nodes);
            newNode.right = buildBinaryTree(nodes);
            return newNode;
        }
    }
}
