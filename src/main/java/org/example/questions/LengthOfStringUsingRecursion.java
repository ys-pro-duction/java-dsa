package org.example.questions;

public class LengthOfStringUsingRecursion {
    public static void main(String[] args) {
        String s = "123456";
        System.out.println(lengthOfString(s,0));
    }
    private static int lengthOfString(String s,int index){
        try{
            s.charAt(index);
            return lengthOfString(s,index+1);
        }catch (Exception e){
            return index;
        }
    }
}
