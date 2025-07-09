package org.example.hashmap;

import org.example.binary_tree.BinaryTreeWithNode.BinaryTree;
import org.example.binary_tree.BinaryTreeWithNode.Node;

import java.util.TreeMap;

public class BottomViewOfABinaryTree {
    public static void main(String[] args) {
        int[] arr = {20,8,5,-1,-1,3,10,-1,-1,14,-1,-1,22,-1,25};
        Node tree = new BinaryTree().buildBinaryTree(arr);
        System.out.println();
        printTreeNode(tree);

        TreeMap<Integer, Pair> map = new TreeMap<>();
        bottomViewOfMap(map,tree,0,0);
        System.out.println();
        System.out.println(map);
    }
    record Pair(int k, int v){}

    private static void bottomViewOfMap(TreeMap<Integer, Pair> map, Node tree, int i, int depth) {
        if (tree == null) return;
        if (map.containsKey(i)){
            int finalDepth = depth;
            map.compute(i, (k, pair) -> pair.k > finalDepth ? pair : new Pair(pair.k, tree.data));
        }else map.put(i, new Pair(depth,tree.data));
        depth++;
        bottomViewOfMap(map, tree.left, i-1, depth);
        bottomViewOfMap(map, tree.right, i+1, depth);
    }

    private static void printTreeNode(Node tree) {
        if (tree == null) return;
        System.out.print(tree.data + ", ");
        printTreeNode(tree.left);
        printTreeNode(tree.right);
    }
}
