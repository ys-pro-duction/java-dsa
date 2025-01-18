package org.example.binary_search_tree.avl_tree;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree {
    public static void main(String[] args) {
        Node root = null;
        root = Node.insert(root, 150);
        root = Node.insert(root, 155);
        root = Node.insert(root, 160);
        root = Node.insert(root, 115);
        root = Node.insert(root, 110);
        root = Node.insert(root, 140);
        root = Node.insert(root, 120);
        root = Node.insert(root, 145);
        root = Node.insert(root, 130);
        root = Node.insert(root, 147);
        root = Node.insert(root, 180);
        System.out.println();
        print(root);
        System.out.println();
    }

    private static void print(Node root) {
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
        int height, data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            height = 1;
        }

        public static Node insert(Node root, int key) {
            if (root == null) return new Node(key);
            if (root.data > key) {
                root.left = insert(root.left, key);
            } else if (root.data < key) {
                root.right = insert(root.right, key);
            } else return root;
            int balanceFactor = getBalanceFactor(root);
            if (balanceFactor > 1 && root.left.data < key) { // lr
                root.left = leftRotate(root.left);
                return rightRotate(root);
            } else if (balanceFactor > 1 && root.left.data > key) { // ll
                return rightRotate(root);
            } else if (balanceFactor < -1 && root.right.data > key) { // rl
                root.right = rightRotate(root.right);
                return leftRotate(root);
            } else if (balanceFactor < -1 && root.right.data < key) { //rr
                return leftRotate(root);
            }
            return root;
        }

        private static Node rightRotate(Node x) {
            Node y = x.left;
            x.left = y.right;
            y.right = x;
            return y;
        }

        private static Node leftRotate(Node x) {
            Node y = x.right;
            x.right = y.left;
            y.left = x;
            return y;
        }

        public static int getBalanceFactor(Node root) {
            return findHeight(root.left) - findHeight(root.right);
        }

        private static int findHeight(Node root) {
            if (root == null) return 0;
            int left = findHeight(root.left);
            int right = findHeight(root.right);
            return Math.max(left, right) + 1;
        }
    }
}
