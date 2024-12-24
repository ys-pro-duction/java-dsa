package org.example.binary_tree;

import static org.example.binary_tree.BinaryTreeWithNode.*;

public class LowestCommonAncestor {
    private static boolean printLowestCommonParent(Node root, int keyOne, int keyTwo) {
        if (root == null) return false;
        boolean founded = (keyOne == root.data || keyTwo == root.data);
        boolean leftFounded = printLowestCommonParent(root.leftChild, keyOne, keyTwo);
        boolean rightFounded = printLowestCommonParent(root.rightChild, keyOne, keyTwo);
        if (leftFounded && rightFounded) System.out.println("Common lowest parent = " + root.data);
        return leftFounded || rightFounded || founded;
    }

    private static Node printLowestCommonParent2(Node root, int keyOne, int keyTwo) {
        if (root == null) return null;
        if (keyOne == root.data || keyTwo == root.data) {
            return root;
        }
        Node leftFounded = printLowestCommonParent2(root.leftChild, keyOne, keyTwo);
        Node rightFounded = printLowestCommonParent2(root.rightChild, keyOne, keyTwo);
        if (leftFounded == null) return rightFounded;
        if (rightFounded == null) return leftFounded;
        return root;
    }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1};
        Node root = new BinaryTree().buildBinaryTree(nodes);

        printLowestCommonParent(root, 2, 3);
        Node seconde = printLowestCommonParent2(root, 2, 3);
        System.out.println("Result = " + seconde.data);
    }
}
