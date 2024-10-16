package org.example.recursion;

public class FriendPairCount {
    //a,b,c|ab,c|a,bc|ac,b
    public static void main(String[] args) {
        System.out.println(friendPairCount(3));
    }
    private static int friendPairCount(int n) {
        if (n <= 2) return n;
        return friendPairCount(n - 1)+ (n-1)*friendPairCount(n - 2);
    }
}
