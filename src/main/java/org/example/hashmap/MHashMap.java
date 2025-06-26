package org.example.hashmap;

import java.util.LinkedList;
import java.util.Random;

public class MHashMap {
    public static void main(String[] args) {
        java.util.HashMap<Integer, String> a = new java.util.HashMap<>();
//        a.put();
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1,"India");
        hashMap.put(2,"China");
        hashMap.put(3,"USA");
        hashMap.put(4,"Russia");
        hashMap.put(5,"Canada");
        hashMap.put(6,"Combodia");
        hashMap.put(7,"Nepal");
        hashMap.put(8,"Nepal");
        hashMap.put(9,"Nepal");
        hashMap.put(10,"Nepal");
        hashMap.put(11,"Nepal");
        hashMap.put(12,"Nepal");
        hashMap.put(13,"Nepal");
        hashMap.put(14,"Nepal");
        for (int i = 0; i < 100; i++) {
            hashMap.put(new Random().nextInt(5000),String.valueOf(new Random().nextInt(5000)));
        }
        hashMap.print();
        System.out.println(hashMap.get(3));
        System.out.println(hashMap.remove(2));
    }

    static class HashMap<K, V> {

        private LinkedList<Node<K, V>>[] bucket;
        private int items = 0;
        private int N = 4;

        public HashMap() {
            bucket = new LinkedList[N];
            for (int i = 0; i < N; i++) {
                bucket[i] = new LinkedList<>();
            }
        }

        public void put(K key, V value) {
            int bucketIndex = getHashKey(key);
            int nodeIndex = getNodeIndex(key, bucketIndex);
            if (nodeIndex == -1) {
                bucket[bucketIndex].add(new Node<>(key, value));
                items++;
                rehash();
            } else {
                Node<K, V> node = bucket[bucketIndex].remove(nodeIndex);
                bucket[bucketIndex].add(node);
            }
        }

        public V get(K key) {
            int bucketIndex = getHashKey(key);
            int nodeIndex = getNodeIndex(key, bucketIndex);
            if (nodeIndex == -1) return null;
            return bucket[bucketIndex].get(nodeIndex).value;
        }
        public V remove(K key){
            int bucketIndex = getHashKey(key);
            int nodeIndex = getNodeIndex(key, bucketIndex);
            if (nodeIndex == -1 ) return null;
            items--;
            return bucket[bucketIndex].remove(nodeIndex).value;
        }
        private void rehash(){
            if (items/bucket.length >= 3){
                System.out.println("Rehashing.........\nold");
                print();
                N *= 2;
                items = 0;
                LinkedList<Node<K, V>>[] temp = bucket;
                bucket = new LinkedList[N];
                for (int i = 0; i < N; i++) {
                    bucket[i] = new LinkedList<>();
                }
                for (LinkedList<Node<K, V>> linkedList : temp) {
                    for (Node<K, V> node : linkedList) {
                        put(node.key,node.value);
                    }
                }
                System.out.println("New");
                print();
            }
        }

        private int getNodeIndex(K key, int bucketIndex) {
            LinkedList<Node<K, V>> ll = bucket[bucketIndex];
            for (int i = 0; i < ll.size(); i++) {
                if (ll.get(i).key == key) return i;
            }
            return -1;
        }

        private int getHashKey(K key) {
            return Math.abs(key.hashCode()) % bucket.length;
        }

        public void print() {
            System.out.println();
            int row = 0;
            for (int i = 0; i < bucket.length; i++) {
                System.out.print("-");
            }
            System.out.println();
            while (true) {
                boolean update = false;
                for (int i = 0; i < bucket.length; i++) {
                    if (bucket[i].size() > row) {
                        System.out.print("#");
                        update = true;
                    }else System.out.print(" ");
                }
                row++;
                if (!update) break;
                System.out.println();
            }
            System.out.println();
        }

        static class Node<K, V> {
            public K key;
            public V value;

            public Node(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }

    }
}
