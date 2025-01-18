package org.example.binary_tree;

import static org.example.binary_tree.BinaryTreeWithNode.BinaryTree;
import static org.example.binary_tree.BinaryTreeWithNode.Node;

public class FindSubtreeExistance {
    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1};
        Node mainTree = new BinaryTree().buildBinaryTree(nodes);
        Node subTree = new BinaryTree().buildBinaryTree(new int[]{3, -1, 6, -1, -1});
        BinaryTreeWithNode.printLevelOrder(mainTree);
        System.out.println();
        BinaryTreeWithNode.printLevelOrder(subTree);
        System.out.println("Sub tree exits int main tree = " + subtreeExist(mainTree, subTree));
    }

    public static boolean subtreeExist(Node main, Node sub) {
        if (main == sub) return true;
        if (main == null || sub == null) return false;
        if (main.data == sub.data) {
            boolean left = subtreeExist(main.left, sub.left);
            boolean right = subtreeExist(main.right, sub.right);
            if (left && right) return true;
        }
        boolean left = subtreeExist(main.left, sub);
        boolean right = subtreeExist(main.right, sub);
        return left || right;
    }
}
