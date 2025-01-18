package org.example.binary_search_tree;

import static org.example.binary_search_tree.BuildBinarySearchTree.buildBST;
import static org.example.binary_search_tree.BuildBinarySearchTree.printBSTInOrder;
import static org.example.binary_tree.BinaryTreeWithNode.Node;
import static org.example.binary_tree.BinaryTreeWithNode.printLevelOrder;

public class DeleteBSTNode {
    public static void main(String[] args) {
        int[] arr = {8, 5, 1, 3, 4, 2, 7, 6, 10, 9, 11, 13, 12};
        Node root;
        root = buildBST(arr);
        printBSTInOrder(root);
        System.out.println();
        int key = 1;
        root = deleteBSTNode(root, key);
        printBSTInOrder(root);
        System.out.println("\nKey " + key + " deleted.");
        printLevelOrder(root);

    }

    private static Node deleteBSTNode(Node root, int key) {
        if (root == null) return null;
        if (root.data == key) {
            if (root.left == null && root.right == null) return null;
            else if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            else {
                {
                    Node leftMostChild = root.right;
                    while (leftMostChild.left != null) leftMostChild = leftMostChild.left;
                    root.data = leftMostChild.data;
                }
                root.right = deleteBSTNode(root.right, root.data);
            }
        }

        if (root.data > key) {
            root.left = deleteBSTNode(root.left, key);
        } else {
            root.right = deleteBSTNode(root.right, key);
        }
        return root;
    }
}
