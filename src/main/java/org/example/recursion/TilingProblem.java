package org.example.recursion;

public class TilingProblem {
    public static void main(String[] args) {
        int lengthOfBoard = 5;
        int result = totalTypeOfArranginTileInBoard(lengthOfBoard,"");
        System.out.println("Types of arrangement = "+result);
    }
    private static int totalTypeOfArranginTileInBoard(int lengthOfBoard,String s){
        if (lengthOfBoard <= 1) {
            System.out.println(lengthOfBoard == 1 ? s+"|" : s);
            return 1;
        }
        return totalTypeOfArranginTileInBoard(lengthOfBoard-1,s+"|")+
                totalTypeOfArranginTileInBoard(lengthOfBoard-2,s+" = ");
    }
}
